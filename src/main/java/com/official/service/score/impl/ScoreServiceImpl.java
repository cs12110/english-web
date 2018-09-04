package com.official.service.score.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.official.entity.Score;
import com.official.mapper.ScoreMapper;
import com.official.service.score.ScoreService;
import com.official.util.ListMapUtil;

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
	public List<Score> compute(String customerId, Integer paper) {
		List<Score> list = scoreMapper.computeScore(customerId, paper);
		return ListMapUtil.gentle(list);
	}

	@Override
	public int deleteAll() {
		return scoreMapper.deleteAll();
	}

	@Override
	public List<Integer> selectCusIdByPaper(Integer paper) {
		List<Integer> list = scoreMapper.selectCusIdByPaper(paper);
		return ListMapUtil.gentle(list);
	}

}
