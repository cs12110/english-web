package com.official.service.subject.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.official.entity.Subject;
import com.official.mapper.SubjectMapper;
import com.official.service.subject.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectMapper subjectMapper;

	@Override
	public List<Subject> list(Subject search) {
		Page<Subject> page = PageHelper.startPage(search.getPage(), search.getRows());
		List<Subject> subjects = subjectMapper.select(search);
		search.setTotalCount(page.getTotal());

		return subjects;
	}

	@Override
	public Subject findOne(Subject search) {
		return subjectMapper.selectOne(search);
	}

	@Override
	public int insert(Subject subject) {
		return subjectMapper.insert(subject);
	}

}
