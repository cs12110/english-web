package com.official.service.score;

import java.util.List;

import com.official.entity.Score;

/**
 * 成绩业务接口
 *
 * @author huanghuapeng 2018年8月17日
 * @see
 * @since 1.0
 */
public interface ScoreService {

	/**
	 * 统计成绩
	 * 
	 * @return
	 */
	List<Score> compute();

	/**
	 * 新增数据
	 * 
	 * @param score
	 *            成绩
	 * @return int
	 */
	int insert(Score score);

	/**
	 * 删除所有记录
	 * 
	 * @return
	 */
	int deleteAll();

}
