package com.official.ctrl.subject;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.official.entity.Customer;
import com.official.entity.Progress;
import com.official.entity.Subject;
import com.official.entity.reply.Reply;
import com.official.enums.StatusEnum;
import com.official.service.progress.ProgressService;
import com.official.service.subject.SubjectService;
import com.official.util.LoginUtil;

/**
 * Subject控制类
 *
 * <p>
 * 
 * @author huanghuapeng 2018年8月17日
 * @see
 * @since 1.0
 */
@Controller
@RequestMapping("/subject/")
public class SubjectCtrl {

	private static Logger logger = LoggerFactory.getLogger(SubjectCtrl.class);

	@Autowired
	private SubjectService subjectService;

	@Autowired
	private ProgressService progressService;

	/**
	 * 获取分页数据
	 * 
	 * @param search 查询数据
	 * @return String
	 */
	@RequestMapping("/list")
	@ResponseBody
	public String getList(HttpServletRequest req, Subject search) {
		Reply reply = new Reply();
		reply.setStatus(StatusEnum.SUCCESS.getValue());

		Customer customer = LoginUtil.getCurrentCustomer(req);
		if (null == customer) {
			logger.debug("Current user is null,we can't get any subject for him");
			reply.setStatus(StatusEnum.FAILURE.getValue());
			reply.setData(Collections.emptyList());
			return reply.toString();
		}

		Progress progress = progressService.findConcurrentOpen();
		Integer cusId = customer.getId();
		Integer paper = progress.getPaper();

		/**
		 * 要排除已经测试过的试题
		 */
		List<Subject> list = subjectService.list(search, paper, cusId);
		reply.setData(list);

		logger.info("{} total sentences is:{}", customer.getCode(), search.getTotalCount());

		return reply.toString();
	}

	/**
	 * 跳转到html页面
	 * 
	 * @return String
	 */
	@RequestMapping("/html")
	public String toSubjectHtml() {
		return "/customer/subject";
	}
}
