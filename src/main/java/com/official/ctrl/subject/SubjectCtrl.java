package com.official.ctrl.subject;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.official.entity.Subject;
import com.official.service.subject.SubjectService;
import com.official.util.JsonUtil;
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

	/**
	 * 获取分页数据
	 * 
	 * @param search
	 *            查询数据
	 * @return String
	 */
	@RequestMapping("/list")
	@ResponseBody
	public String getList(Subject search) {
		logger.info("Get subject page {} rows {} ", search.getPage(), search.getRows());
		List<Subject> list = subjectService.list(search);

		return JsonUtil.toJSONStr(list);
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
