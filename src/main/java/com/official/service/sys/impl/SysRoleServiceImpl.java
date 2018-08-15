package com.official.service.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.official.entity.sys.SysRole;
import com.official.mapper.SysRoleMapper;
import com.official.service.sys.SysRoleService;

/**
 * 系统角色业务实现类
 *
 * <p>
 * detailed comment
 * 
 * @author huanghuapeng 2017年11月3日
 * @see
 * @since 1.0
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

	@Autowired
	private SysRoleMapper sysRoleMapper;

	@Override
	public List<SysRole> findRoleByUserId(Integer userId) {

		return sysRoleMapper.findRoleByUserId(userId);
	}

}
