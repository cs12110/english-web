package com.official.service.subject;

import java.util.List;

import com.official.entity.Subject;

/**
 * 题目接口类
 *
 * <p>
 * detailed comment
 * 
 * @author huanghuapeng 2018年8月17日
 * @see
 * @since 1.0
 */
public interface SubjectService {

	/**
	 * 分页查询
	 * 
	 * @param search     查询条件
	 * @param paper      当前测试进度
	 * @param customerId 用户Id
	 * @return List
	 */
	public List<Subject> list(Subject search, Integer paper, Integer customerId);

	/**
	 * 查找数据
	 * 
	 * @param search 查询条件
	 * @return Subject
	 */
	public Subject findOne(Subject search);

	/**
	 * 插入数据
	 * 
	 * @param subject 题目
	 * @return int
	 */
	public int insert(Subject subject);

	/**
	 * 删除数据
	 * 
	 * @param subject 条件
	 * @return int
	 */
	public int delete(Subject subject);

	/**
	 * 删除全部数据
	 */
	public void deleteAll();

}
