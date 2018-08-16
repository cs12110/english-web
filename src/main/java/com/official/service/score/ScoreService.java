package com.official.service.score;

import java.util.List;

import com.official.entity.Score;

public interface ScoreService {

	/**
	 * 统计成绩
	 * 
	 * @return
	 */
	List<Score> compute();

	int insert(Score score);

}
