package com.official.service.customer;

import com.official.entity.Customer;

/**
 * Customer业务接口
 *
 * @author huanghuapeng 2018年8月17日
 * @see
 * @since 1.0
 */
public interface CustomerService {

	/**
	 * 查找用户
	 * 
	 * @param search
	 *            查询条件
	 * @return {@link Customer}
	 */
	public Customer selectOne(Customer search);

	/**
	 * 插入新用户
	 * 
	 * @param customer
	 *            用户
	 * @return int
	 */
	public int insert(Customer customer);

	/**
	 * 删除所有用户
	 * 
	 * @return int
	 */
	public int deleteAll();

}
