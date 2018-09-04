package com.official.ctrl.admin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

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
import com.official.util.DateUtil;
import com.official.util.ExcelUtil;
import com.official.util.FileUtil;
import com.official.util.LoginUtil;
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
		if (!LoginUtil.isAdminLogined(req)) {
			return LoginUtil.pleaseLoginHandsup().toString();
		}
		logger.info("Delete all customer,score,subject");

		customerService.deleteAll();
		scoreService.deleteAll();
		subjectService.deleteAll();

		logger.info("Delete all customer,score,subject done");

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
		if (!LoginUtil.isAdminLogined(req)) {
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
		if (!LoginUtil.isAdminLogined(req)) {
			return LoginUtil.pleaseLoginHandsup().toString();
		}

		Reply reply = new Reply(StatusEnum.SUCCESS.getValue());
		try {
			String name = file == null ? "" : file.getOriginalFilename().trim();
			if (!name.endsWith(Const.LATEST_EXCEL_SUBFFIX) && !name.endsWith(Const.OLD_EXCEL_SUBFFIX)) {
				reply.setStatus(StatusEnum.FAILURE.getValue());
				reply.setMessage("文件必须为excel(`xlsx`/`xls`)后缀文件");
				return reply.toString();
			}
			logger.info("Start to process:{}", name);
			long start = System.currentTimeMillis();
			PaperEnum paperEnum = PaperUtil.getEnumValue(paper);
			deletePrevData(paperEnum);

			Map<String, Integer> result = ExcelUtil.saveSubjectExcelIntoDb(dataSource, file.getInputStream(),
					paperEnum);
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
	 * 每一次上传都删除前面版本的测试数据
	 * 
	 * @param paperEnum 上传文件类型
	 */
	private void deletePrevData(PaperEnum paperEnum) {
		logger.info("Delete prev data of {}", paperEnum);

		Subject subject = new Subject();
		subject.setPaper(paperEnum.getValue());

		subjectService.delete(subject);
	}

	/**
	 * 下载结果
	 * 
	 * @param req      {@link HttpServletRequest}
	 * @param response {@link HttpServletResponse}
	 * @param paper    试卷类型
	 */
	@RequestMapping("/export")
	public void export(HttpServletRequest req, HttpServletResponse response, Integer paper) {
		if (LoginUtil.isAdminLogined(req)) {
			long start = System.currentTimeMillis();
			List<Integer> customerIdList = scoreService.selectCusIdByPaper(paper);
			if (null != customerIdList) {
				List<File> excelFileList = new ArrayList<File>();
				for (Integer each : customerIdList) {
					List<Score> list = scoreService.compute(String.valueOf(each), paper);
					String code = "";
					if (null != list && list.size() > 0) {
						try {
							code = list.get(0).getCustomer().getCode();
						} catch (Exception e) {
							e.printStackTrace();
							logger.error("Get code from Score have an error:{}", e.getMessage());
						}
					}
					String excelName = code + "-" + PaperUtil.getName(paper);
					File file = ExcelUtil.buildScoreResultExcel(excelName, list);
					excelFileList.add(file);
					logger.info("Generator score file:{}", file.getName());
				}

				// 加入压缩包
				if (excelFileList.size() > 0) {
					try {
						String zipName = buildZipFileName(paper);
						File zipFile = new File(zipName);
						FileUtil.zip(excelFileList, zipFile.getPath());

						FileUtil.download(response, zipFile.getPath());
						logger.info("Zip [{}] is done", zipName);
						zipFile.delete();
						logger.info("Delete [{}] is done ", zipName);

						for (File each : excelFileList) {
							each.delete();
						}
					} catch (Exception e) {
						e.printStackTrace();
						logger.error("Zip score file error:{}", e.getMessage());
					}
				}
			}
			long end = System.currentTimeMillis();
			logger.info("Export excel spend: {} mills", (end - start));
		} else {
			logger.info("Must be logging and code disallow to be empty");
			try {
				PrintWriter writer = response.getWriter();
				writer.write("请先登录管理员账号!");
				writer.flush();
				writer.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 创建成绩压缩包
	 * 
	 * @param paper 试卷类型
	 * @return String
	 */
	private String buildZipFileName(Integer paper) {
		StringBuilder name = new StringBuilder();
		name.append(DateUtil.getFormatDate("yyyyMMdd"));
		name.append("-");
		name.append(PaperUtil.getName(paper));
		name.append("成绩.zip");
		return name.toString();
	}

}
