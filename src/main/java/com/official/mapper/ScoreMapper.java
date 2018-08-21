package com.official.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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
	 * @param codeOfCustomer
	 *            学号
	 * 
	 * @param paper
	 *            测试类型
	 * 
	 * @return List
	 */
	List<Score> computeScore(@Param("code") String codeOfCustomer, @Param("paper") Integer paper);

	/**
	 * 删除全部
	 * 
	 * @return
	 */
	int deleteAll();

	/**
	 * 保存数据
	 * 
	 * @param score
	 *            数据
	 * @return int
	 */
	int save(Score score);
}