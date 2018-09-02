package com.official.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.official.entity.Subject;
import com.official.util.MyMapper;

/**
 * Subject Mapper接口
 *
 * @author huanghuapeng 2018年8月17日
 * @see
 * @since 1.0
 */
public interface SubjectMapper extends MyMapper<Subject> {

	/**
	 * 查询数据
	 * 
	 * @param paper      试卷类型
	 * @param customerId 当前学生Id
	 * 
	 * @return List
	 */
	List<Subject> selectWithPaper(@Param("paper") Integer paper, @Param("customerId") Integer customerId);

	/**
	 * 删除所有数据
	 * 
	 * @return int
	 */
	int deleteAll();
}