package com.official.mapper;

import java.util.List;

import com.official.entity.Score;
import com.official.util.MyMapper;

public interface ScoreMapper extends MyMapper<Score> {

	/**
	 * 统计成绩
	 * 
	 * @return List
	 */
	List<Score> computeScore();

	/**
	 * 删除全部
	 * 
	 * @return
	 */
	int deleteAll();
}