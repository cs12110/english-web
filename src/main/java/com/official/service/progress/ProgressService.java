package com.official.service.progress;

import com.official.entity.Progress;

/**
 * 业务接口类
 *
 * <p>
 * 
 * @author huanghuapeng 2018年8月21日
 * @see
 * @since 1.0
 */
public interface ProgressService {

	/**
	 * 当前进度
	 * 
	 * @param search
	 *            查询条件
	 * 
	 * @return {@link Process}
	 */
	Progress findOne(Progress search);

	/**
	 * 更新数据
	 * 
	 * @param value
	 *            值
	 * @return int
	 */
	int openExam(Progress value);

	/**
	 * 关闭其他测试
	 * 
	 * @param value
	 *            当前打开测试值
	 * @return int
	 */
	int closeOtherExam(Progress value);
}
