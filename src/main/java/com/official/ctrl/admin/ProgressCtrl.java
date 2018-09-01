package com.official.ctrl.admin;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.official.entity.Progress;
import com.official.entity.reply.Reply;
import com.official.enums.OpenEnum;
import com.official.enums.StatusEnum;
import com.official.service.progress.ProgressService;
import com.official.util.DateUtil;

/**
 * 进度控制类
 *
 * <p>
 * detailed comment
 * 
 * @author huanghuapeng 2018年8月21日
 * @see
 * @since 1.0
 */
@Controller
@RequestMapping("/progress/")
public class ProgressCtrl {

	private static Logger logger = LoggerFactory.getLogger(ProgressCtrl.class);

	@Autowired
	private ProgressService progressService;

	/**
	 * 当前测试
	 * 
	 * @param req HttpServletRequest
	 * @return String of {@link Reply}
	 */
	@RequestMapping("/current")
	@ResponseBody
	public String current(HttpServletRequest req) {

		Reply reply = new Reply();
		reply.setStatus(StatusEnum.SUCCESS.getValue());

		Progress search = new Progress();
		search.setOpen(OpenEnum.OPEN.getValue());

		Progress current = progressService.findOne(search);
		reply.setData(current);

		return reply.toString();
	}

	/**
	 * 更新当前进度
	 * 
	 * @param req   请求
	 * @param value 进度
	 * @return String
	 */
	@RequestMapping("/update")
	@ResponseBody
	public String updateProgress(HttpServletRequest req, Progress value) {
		Reply reply = new Reply();
		reply.setStatus(StatusEnum.SUCCESS.getValue());

		value.setOpTime(DateUtil.getCurrentTime());
		value.setOpen(OpenEnum.OPEN.getValue());

		logger.info("Progress on {} now", value.getPaper());
		progressService.openExam(value);
		progressService.closeOtherExam(value);

		return reply.toString();

	}
}
