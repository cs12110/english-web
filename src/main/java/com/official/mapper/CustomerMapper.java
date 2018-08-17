package com.official.mapper;

import com.official.entity.Customer;
import com.official.util.MyMapper;

/**
 * 
 * Customer Mapper接口
 * 
 * @author huanghuapeng 2018年8月17日
 * @see
 * @since 1.0
 */
public interface CustomerMapper extends MyMapper<Customer> {

	/**
	 * 删除所有数据
	 * 
	 * @return int
	 */
	int deleteAll();
}