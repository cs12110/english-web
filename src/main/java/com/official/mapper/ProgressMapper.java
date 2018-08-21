package com.official.mapper;

import com.official.entity.Progress;
import com.official.util.MyMapper;

/**
 * Mapper 接口
 *
 * <p>
 * detailed comment
 * 
 * @author huanghuapeng 2018年8月21日
 * @see
 * @since 1.0
 */
public interface ProgressMapper extends MyMapper<Progress> {

	/**
	 * 更新数据
	 * 
	 * @param value
	 *            值
	 * @return int
	 */
	int openExam(Progress value);

	/**
	 * 更新数据
	 * 
	 * @param value
	 *            值
	 * @return int
	 */
	int closeOtherExam(Progress value);
}