package com.official.service.sys;

import java.util.List;

import com.official.entity.sys.SysRole;

/**
 * 
 * 系统角色业务接口
 * <p>
 * detailed comment
 * 
 * @author huanghuapeng 2017年11月3日
 * @see
 * @since 1.0
 */
public interface SysRoleService {

	/**
	 * 根据用户Id查找关联角色
	 * 
	 * @param userId
	 *            用户Id
	 * @return List
	 */
	public List<SysRole> findRoleByUserId(Integer userId);
}
