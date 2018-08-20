package com.official.ctrl.admin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.official.util.Md5Util;
import com.official.util.PaperUtil;
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

	/**
	 * 删除所有的cutomer和成绩数据
	 * 
	 * @param req
	 *            请求
	 * @return String
	 */
	@RequestMapping("/deleteAll")
	@ResponseBody
	public String deleteAll(HttpServletRequest req) {
		if (!isAdminLogined(req)) {
			return pleaseLoginHandsup().toString();
		}

		logger.info("Delete all the customer and score's record");

		customerService.deleteAll();
		scoreService.deleteAll();

		Reply reply = new Reply();
		reply.setStatus(StatusEnum.SUCCESS.getValue());
		reply.setMessage("全部删除");
		HttpSession session = req.getSession();
		session.setAttribute(Const.CURRENT_USER, null);
		return reply.toString();

	}

	/**
	 * 登录判断
	 * 
	 * @param req
	 *            请求
	 * @return String
	 */
	@RequestMapping("/loginCheck")
	@ResponseBody
	public String loginCheck(HttpServletRequest req) {
		Reply reply = new Reply();
		reply.setStatus(StatusEnum.SUCCESS.getValue());
		if (!isAdminLogined(req)) {
			reply.setStatus(StatusEnum.FAILURE.getValue());
		}
		return reply.toString();
	}

	/**
	 * 判断管理员是否已登录
	 * 
	 * @param req
	 *            请求
	 * @return boolean
	 */
	private boolean isAdminLogined(HttpServletRequest req) {
		HttpSession session = req.getSession();
		Object admin = session.getAttribute(Const.ADMIN);
		return null != admin;
	}

	/**
	 * 管理员登录
	 * 
	 * @param req
	 *            请求
	 * @param user
	 *            管理员登录参数对象
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
				session.setAttribute(Const.ADMIN, target);
			}
		}

		return reply.toString();
	}

	/**
	 * 退出
	 * 
	 * @param req
	 *            请求
	 * @return String
	 */
	@RequestMapping("/logout")
	@ResponseBody
	public String logout(HttpServletRequest req) {
		logger.info("Admin is logout now");

		Reply reply = new Reply(StatusEnum.SUCCESS.getValue());
		HttpSession session = req.getSession();
		session.setAttribute(Const.ADMIN, null);

		return reply.toString();
	}

	/**
	 * 上传文件
	 * 
	 * @param req
	 *            请求
	 * @param file
	 *            文件
	 * @return String
	 * @throws IOException
	 */
	@RequestMapping("/upload")
	@ResponseBody
	public String uploadExcel(HttpServletRequest req, MultipartFile file, String paper) throws IOException {
		if (!isAdminLogined(req)) {
			return pleaseLoginHandsup().toString();
		}

		Reply reply = new Reply(StatusEnum.SUCCESS.getValue());
		try {
			String name = file.getOriginalFilename();
			if (!name.endsWith("xlsx")) {
				reply.setStatus(StatusEnum.FAILURE.getValue());
				reply.setMessage("文件必须为excel(.xlsx)文件");
				return reply.toString();
			}

			PaperEnum paperEnum = PaperUtil.getEnumValue(paper);
			deletePrevData(paperEnum);

			Map<String, Integer> result = processExcel(file.getInputStream());
			reply.setData(result);

			logger.info("Upload {} file {} is done, {}", paper, name, result.toString());
		} catch (Exception e) {
			e.printStackTrace();
			reply.setStatus(StatusEnum.FAILURE.getValue());
		}
		return reply.toString();
	}

	/**
	 * 请登录提醒
	 * 
	 * @return {@link Reply}
	 */
	private Reply pleaseLoginHandsup() {
		Reply reply = new Reply();
		reply.setStatus(StatusEnum.FAILURE.getValue());
		reply.setMessage("请先登录");
		return reply;
	}

	/**
	 * 处理excel文件
	 * 
	 * @param stream
	 *            文件流
	 * @return Map
	 */
	private Map<String, Integer> processExcel(InputStream stream) {
		Map<String, Integer> map = new HashMap<String, Integer>(1);
		try {
			Workbook workBook = WorkbookFactory.create(stream);
			Sheet sheet = workBook.getSheetAt(0);
			int rows = sheet.getPhysicalNumberOfRows();

			int success = 0;
			int failure = 0;
			for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
				Row row = sheet.getRow(rowIndex);
				Subject subject = ExcelUtil.parseToSubject(row);
				// 执行数据库增加操作,这里要进行批处理操作.
				if (null != subject) {
					try {
						subjectService.insert(subject);
						success++;
					} catch (Exception e) {
						logger.error("Have an error on:{}", subject.toString());
						e.printStackTrace();
						failure++;
					}
				}
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
	 * @param paperEnum
	 *            上传文件类型
	 */
	private void deletePrevData(PaperEnum paperEnum) {

		Subject subject = new Subject();
		subject.setPaper(paperEnum.getValue());

		subjectService.delete(subject);
	}

	/**
	 * 下载结果
	 */
	@RequestMapping("/export")
	public void export(HttpServletRequest req, HttpServletResponse response) {
		if (isAdminLogined(req)) {
			logger.info("Export the result for excel");
			List<Score> list = scoreService.compute();
			File file = ExcelUtil.buildScoreResultExcel(list);
			FileUtil.download(response, file.getAbsolutePath());
			file.delete();
		}
	}

}
