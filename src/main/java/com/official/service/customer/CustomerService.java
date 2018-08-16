package com.official.service.customer;

import com.official.entity.Customer;

public interface CustomerService {

	/**
	 * 插入新用户
	 * 
	 * @param customer
	 *            用户
	 * @return int
	 */
	public int insert(Customer customer);

}
