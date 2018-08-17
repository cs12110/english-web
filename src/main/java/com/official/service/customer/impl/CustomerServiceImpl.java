package com.official.service.customer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.official.entity.Customer;
import com.official.mapper.CustomerMapper;
import com.official.service.customer.CustomerService;

/**
 * 用户业务接口实现类
 *
 * @author huanghuapeng 2018年8月17日
 * @see
 * @since 1.0
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public int insert(Customer customer) {
		if (null == customer) {
			return 0;
		}
		return customerMapper.insert(customer);
	}

	@Override
	public int deleteAll() {
		// TODO Auto-generated method stub
		return customerMapper.deleteAll();
	}

	@Override
	public Customer selectOne(Customer search) {
		return customerMapper.selectOne(search);
	}

}
