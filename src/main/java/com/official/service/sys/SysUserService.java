package com.official.service.sys;

import com.official.entity.sys.SysUser;

/**
 * 
 * 系统用户业务接口
 * <p>
 * detailed comment
 * 
 * @author huanghuapeng 2017年11月3日
 * @see
 * @since 1.0
 */
public interface SysUserService {

	/**
	 * 根据名称查找系统用户
	 * 
	 * @param userName
	 *            用户名称
	 * @return SysUser
	 */
	public SysUser findByUserName(String userName);
}
