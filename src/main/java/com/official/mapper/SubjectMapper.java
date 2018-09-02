package com.official.mapper;

import java.util.List;

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
	 * @return List
	 */
	List<Subject> selectWithPaper();

	/**
	 * 删除所有数据
	 * 
	 * @return int
	 */
	int deleteAll();
}