package com.official.service.score.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.official.entity.Score;
import com.official.mapper.ScoreMapper;
import com.official.service.score.ScoreService;

/**
 * 
 * 成绩业务接口实现类
 *
 * <p>
 * 
 * @author huanghuapeng 2018年8月17日
 * @see
 * @since 1.0
 */
@Service
public class ScoreServiceImpl implements ScoreService {

	@Autowired
	private ScoreMapper scoreMapper;

	@Override
	public int insert(Score score) {
		return scoreMapper.save(score);
	}

	@Override
	public List<Score> compute() {
		return scoreMapper.computeScore();
	}

	@Override
	public int deleteAll() {
		return scoreMapper.deleteAll();
	}

}
