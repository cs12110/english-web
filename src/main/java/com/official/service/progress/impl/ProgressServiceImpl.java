package com.official.service.progress.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.official.entity.Progress;
import com.official.enums.OpenEnum;
import com.official.mapper.ProgressMapper;
import com.official.service.progress.ProgressService;

/**
 * 业务接口实现类
 *
 * <p>
 * 
 * @author huanghuapeng 2018年8月21日
 * @see
 * @since 1.0
 */
@Service
public class ProgressServiceImpl implements ProgressService {

	@Autowired
	private ProgressMapper progressMapper;

	@Override
	public Progress findOne(Progress search) {
		return progressMapper.selectOne(search);
	}

	@Override
	public int openExam(Progress value) {
		return progressMapper.openExam(value);
	}

	@Override
	public int closeOtherExam(Progress value) {
		value.setOpen(OpenEnum.CLOSE.getValue());
		return progressMapper.closeOtherExam(value);
	}

	@Override
	public Progress findConcurrentOpen() {
		Progress search = new Progress();
		search.setOpen(OpenEnum.OPEN.getValue());
		Progress current = progressMapper.selectOne(search);
		return current;
	}
}
