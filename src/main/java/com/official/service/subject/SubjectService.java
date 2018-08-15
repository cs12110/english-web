package com.official.service.subject;

import java.util.List;

import com.official.entity.Subject;

public interface SubjectService {

	public List<Subject> list(Subject search);

	public Subject findOne(Subject search);

	int insert(Subject subject);

}
