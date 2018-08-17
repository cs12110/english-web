package com.official.mapper;

import java.util.List;

import com.official.entity.Score;
import com.official.util.MyMapper;

/**
 * 成绩Mapper接口
 * 
 * @author huanghuapeng 2018年8月17日
 * @see
 * @since 1.0
 */
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