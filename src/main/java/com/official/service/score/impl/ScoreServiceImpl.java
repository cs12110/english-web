package com.official.service.score.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.official.entity.Score;
import com.official.mapper.ScoreMapper;
import com.official.service.score.ScoreService;

@Service
public class ScoreServiceImpl implements ScoreService {

	@Autowired
	private ScoreMapper scoreMapper;

	
	@Override
	public int insert(Score score) {
		return scoreMapper.insert(score);
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
