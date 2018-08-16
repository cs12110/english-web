package com.official.ctrl.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.official.entity.Score;
import com.official.entity.reply.Reply;
import com.official.entity.sys.SysUser;
import com.official.enums.ReplyEnum;
import com.official.service.customer.CustomerService;
import com.official.service.score.ScoreService;
import com.official.service.sys.SysUserService;
import com.official.util.Const;
import com.official.util.ExcelUtil;
import com.official.util.FileUtil;
import com.official.util.Md5Util;

@Controller
@RequestMapping("/admin/")
public class AdminCtrl {

	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private ScoreService scoreService;

	@RequestMapping("/deleteAll")
	@ResponseBody
	public String deleteAll(HttpServletRequest req) {

		customerService.deleteAll();
		scoreService.deleteAll();

		Reply reply = new Reply();
		reply.setStatus(ReplyEnum.SUCCESS.getValue());
		reply.setMessage("全部删除");

		HttpSession session = req.getSession();
		session.setAttribute(Const.CURRENT_USER, null);
		return reply.toString();

	}

	@RequestMapping("/loginCheck")
	@ResponseBody
	public String loginCheck(HttpServletRequest req) {
		HttpSession session = req.getSession();
		Reply reply = new Reply();
		reply.setStatus(ReplyEnum.SUCCESS.getValue());
		Object admin = session.getAttribute(Const.ADMIN);
		if (null == admin) {
			reply.setStatus(ReplyEnum.FAILURE.getValue());
		}
		return reply.toString();
	}

	@RequestMapping("/login")
	@ResponseBody
	public String login(HttpServletRequest req, SysUser user) {
		Reply reply = new Reply();

		SysUser target = sysUserService.findByUserName(user.getUserName());
		if (target == null) {
			reply.setStatus(ReplyEnum.FAILURE.getValue());
			reply.setMessage("用户名[" + user.getUserName() + "]不存在");
			return reply.toString();
		} else {
			String password = user.getPassword();
			String encode = Md5Util.encode(password);
			if (!encode.equals(target.getPassword())) {
				reply.setStatus(ReplyEnum.FAILURE.getValue());
				reply.setMessage("登录密码不正确");
				return reply.toString();
			} else {
				reply.setStatus(ReplyEnum.SUCCESS.getValue());
				HttpSession session = req.getSession();
				session.setAttribute(Const.ADMIN, target);
			}
		}

		return reply.toString();
	}

	@RequestMapping("/logout")
	@ResponseBody
	public String logout(HttpServletRequest req) {
		Reply reply = new Reply();

		reply.setStatus(ReplyEnum.SUCCESS.getValue());
		HttpSession session = req.getSession();
		session.setAttribute(Const.ADMIN, null);

		return reply.toString();
	}

	/**
	 * 下载结果
	 */
	@RequestMapping("/export")
	public void export(HttpServletResponse response) {
		List<Score> list = scoreService.compute();
		File file = buildResultExcel(list);
		FileUtil.download(response, file.getAbsolutePath());
		file.delete();
	}

	/**
	 * 创建结果excel
	 * 
	 * @return File
	 */
	private File buildResultExcel(List<Score> list) {
		String[] titles = {"姓名", "学号", "开始学习英语年龄", "年龄", "四级分数", "六级分数", "专业", "句子类型	原句（逐词呈现的句子）", "单词１阅读时间",
				"单词２阅读时间", "单词３阅读时间", "单词４阅读时间", "单词５阅读时间", "问题回答正确率"};

		File file = new File("统计结果.xlsx");

		try {

			// 创建工作簿
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("统计结果");
			XSSFRow row = sheet.createRow(0);

			for (int index = 0, len = titles.length; index < len; index++) {
				XSSFCell cell = row.createCell(index);
				cell.setCellValue(titles[index]);
			}

			if (null != list && list.size() > 0) {
				for (int index = 0, size = list.size(); index < size; index++) {
					row = sheet.createRow(index + 1);
					Score score = list.get(index);
					ExcelUtil.parseScoreToRow(row, score);
				}
			}
			// 创建输出流
			FileOutputStream fos = new FileOutputStream(file);
			workbook.write(fos);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return file;
	}
}
