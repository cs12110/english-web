package com.official.service.sys.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.official.entity.sys.SysUser;
import com.official.mapper.SysUserMapper;
import com.official.service.sys.SysUserService;
import com.official.util.StrUtil;

/**
 * 系统用户业务实现类
 *
 * <p>
 * detailed comment
 * 
 * @author huanghuapeng 2017年11月3日
 * @see
 * @since 1.0
 */
@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public SysUser findByUserName(String userName) {

		if (StrUtil.isEmpty(userName)) {
			return null;
		}

		return sysUserMapper.findUserByName(userName);
	}

}
