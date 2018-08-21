package com.official.ctrl.admin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.official.entity.Score;
import com.official.entity.Subject;
import com.official.entity.reply.Reply;
import com.official.entity.sys.SysUser;
import com.official.enums.PaperEnum;
import com.official.enums.StatusEnum;
import com.official.service.customer.CustomerService;
import com.official.service.score.ScoreService;
import com.official.service.subject.SubjectService;
import com.official.service.sys.SysUserService;
import com.official.util.Const;
import com.official.util.ExcelUtil;
import com.official.util.FileUtil;
import com.official.util.JdbcBatchUtil;
import com.official.util.LoginCheckUtil;
import com.official.util.Md5Util;
import com.official.util.PaperUtil;
import com.official.util.StrUtil;

/**
 * 管理员控制类
 *
 * <p>
 * 
 * @author huanghuapeng 2018年8月17日
 * @see
 * @since 1.0
 */
@Controller
@RequestMapping("/admin/")
public class AdminCtrl {

	private static Logger logger = LoggerFactory.getLogger(AdminCtrl.class);

	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private SubjectService subjectService;

	@Autowired
	private ScoreService scoreService;

	@Autowired
	private DataSource dataSource;

	/**
	 * 删除所有的cutomer和成绩数据
	 * 
	 * @param req 请求
	 * @return String
	 */
	@RequestMapping("/deleteAll")
	@ResponseBody
	public String deleteAll(HttpServletRequest req) {
		if (!LoginCheckUtil.isAdminLogined(req)) {
			return LoginCheckUtil.pleaseLoginHandsup().toString();
		}

		logger.info("Delete all the customer and score's record");

		customerService.deleteAll();
		scoreService.deleteAll();

		Reply reply = new Reply();
		reply.setStatus(StatusEnum.SUCCESS.getValue());
		reply.setMessage("全部删除");
		HttpSession session = req.getSession();
		session.setAttribute(Const.USER_SESSION_KEY, null);
		return reply.toString();

	}

	/**
	 * 登录判断
	 * 
	 * @param req 请求
	 * @return String
	 */
	@RequestMapping("/loginCheck")
	@ResponseBody
	public String loginCheck(HttpServletRequest req) {
		Reply reply = new Reply();
		reply.setStatus(StatusEnum.SUCCESS.getValue());
		if (!LoginCheckUtil.isAdminLogined(req)) {
			reply.setStatus(StatusEnum.FAILURE.getValue());
		}
		return reply.toString();
	}

	/**
	 * 管理员登录
	 * 
	 * @param req  请求
	 * @param user 管理员登录参数对象
	 * @return String
	 */
	@RequestMapping("/login")
	@ResponseBody
	public String login(HttpServletRequest req, SysUser user) {
		logger.info("User {} of admin is login now", user.getUserName());

		SysUser target = sysUserService.findByUserName(user.getUserName());
		Reply reply = new Reply();
		if (target == null) {
			reply.setStatus(StatusEnum.FAILURE.getValue());
			reply.setMessage("用户名[" + user.getUserName() + "]不存在");
			return reply.toString();
		} else {
			String password = user.getPassword();
			String encode = Md5Util.encode(password);
			if (!encode.equals(target.getPassword())) {
				reply.setStatus(StatusEnum.FAILURE.getValue());
				reply.setMessage("登录密码不正确");
				return reply.toString();
			} else {
				reply.setStatus(StatusEnum.SUCCESS.getValue());
				HttpSession session = req.getSession();
				session.setAttribute(Const.ADMIN_SESSION_KEY, target);
			}
		}

		return reply.toString();
	}

	/**
	 * 退出
	 * 
	 * @param req 请求
	 * @return String
	 */
	@RequestMapping("/logout")
	@ResponseBody
	public String logout(HttpServletRequest req) {
		logger.info("Admin is logout now");

		Reply reply = new Reply(StatusEnum.SUCCESS.getValue());
		HttpSession session = req.getSession();
		session.setAttribute(Const.ADMIN_SESSION_KEY, null);

		return reply.toString();
	}

	/**
	 * 上传文件
	 * 
	 * @param req  请求
	 * @param file 文件
	 * @return String
	 * @throws IOException
	 */
	@RequestMapping("/upload")
	@ResponseBody
	public String uploadExcel(HttpServletRequest req, MultipartFile file, Integer paper) throws IOException {
		if (!LoginCheckUtil.isAdminLogined(req)) {
			return LoginCheckUtil.pleaseLoginHandsup().toString();
		}

		Reply reply = new Reply(StatusEnum.SUCCESS.getValue());
		try {
			String name = file == null ? "" : file.getOriginalFilename();
			if (!name.endsWith("xlsx")) {
				reply.setStatus(StatusEnum.FAILURE.getValue());
				reply.setMessage("文件必须为excel(.xlsx)文件");
				return reply.toString();
			}

			long start = System.currentTimeMillis();
			PaperEnum paperEnum = PaperUtil.getEnumValue(paper);
			deletePrevData(paperEnum);

			Map<String, Integer> result = processExcel(file.getInputStream(), paperEnum);
			reply.setData(result);

			long end = System.currentTimeMillis();
			logger.info("Upload {} file {} is done, {}, spend:{} ", paper, name, result.toString(), (end - start));
		} catch (Exception e) {
			e.printStackTrace();
			reply.setStatus(StatusEnum.FAILURE.getValue());
		}
		return reply.toString();
	}

	/**
	 * 处理excel文件
	 * 
	 * @param stream 文件流
	 * @return Map
	 */
	private Map<String, Integer> processExcel(InputStream stream, PaperEnum paperEnum) {
		Map<String, Integer> map = new HashMap<String, Integer>(1);
		try {
			JdbcBatchUtil batchUtil = new JdbcBatchUtil(dataSource);
			Workbook workBook = WorkbookFactory.create(stream);
			Sheet sheet = workBook.getSheetAt(0);
			int rows = sheet.getPhysicalNumberOfRows();

			int success = 0;
			int failure = 0;
			int batch = 50;

			List<Subject> list = new ArrayList<Subject>();
			for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
				Row row = sheet.getRow(rowIndex);
				Subject subject = ExcelUtil.parseToSubject(row);

				if (null != subject) {
					subject.setPaper(paperEnum.getValue());
					list.add(subject);
				}

				if (list.size() % batch == 0) {
					try {
						batchUtil.process(list);
						list.clear();
						success += batch;
					} catch (Exception e) {
						logger.error("Jdbc batch error:{}", e.getMessage());
						failure += batch;
					}
				}
			}

			if (list.size() > 0) {
				success += list.size();
				batchUtil.process(list);
			}
			map.put("success", success);
			map.put("failure", failure);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 每一次上传都删除前面版本的测试数据
	 * 
	 * @param paperEnum 上传文件类型
	 */
	private void deletePrevData(PaperEnum paperEnum) {

		Subject subject = new Subject();
		subject.setPaper(paperEnum.getValue());

		subjectService.delete(subject);
	}

	/**
	 * 下载结果
	 * 
	 * @param req      {@link HttpServletRequest}
	 * @param response {@link HttpServletResponse}
	 * @param code     学号
	 * @param paper    试卷类型
	 */
	@RequestMapping("/export")
	public void export(HttpServletRequest req, HttpServletResponse response, String code, Integer paper) {

		if (LoginCheckUtil.isAdminLogined(req) && !StrUtil.isEmpty(code)) {
			long start = System.currentTimeMillis();
			List<Score> list = scoreService.compute(code, paper);
			String excelName = code + "-" + PaperUtil.getName(paper);
			File file = ExcelUtil.buildScoreResultExcel(excelName, list);
			FileUtil.download(response, file.getAbsolutePath());
			file.delete();
			long end = System.currentTimeMillis();
			logger.info("Export {} score for excel,spend: {} mills", code, (end - start));
		} else {
			logger.info("Must be logging and code disallow to be empty");
		}
	}

}
