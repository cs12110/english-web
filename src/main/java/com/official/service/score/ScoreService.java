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
	 * 新增数据
	 * 
	 * @param score 成绩
	 * @return int
	 */
	int insert(Score score);

	/**
	 * 删除所有记录
	 * 
	 * @return
	 */
	int deleteAll();

	/**
	 * 统计成绩
	 * 
	 * @param codeOfCustomer 学生Id
	 * @param paper          测试类型
	 * @return List
	 */
	List<Score> compute(String codeOfCustomer, Integer paper);

	/**
	 * 查询考了paper的学生Id
	 * 
	 * @param paper 试卷类型
	 * @return List
	 */
	List<Integer> selectCusIdByPaper(Integer paper);

}
