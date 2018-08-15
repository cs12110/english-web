package com.official.ctrl.subject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.official.entity.Subject;
import com.official.service.subject.SubjectService;
import com.official.util.JSONUtil;

@Controller
@RequestMapping("/subject/")
public class SubjectCtrl {

	@Autowired
	private SubjectService subjectService;

	@RequestMapping("/list")
	@ResponseBody
	public String getList(Subject search) {

		List<Subject> list = subjectService.list(search);

		return JSONUtil.toJSONStr(list);
	}

	@RequestMapping("/html")
	public String toSubjectHtml() {
		return "/customer/subject";
	}
}
