package com.official.mapper;

import org.apache.ibatis.annotations.Param;

import com.official.entity.sys.SysUser;

import tk.mybatis.mapper.common.Mapper;

/**
 * 系统用户Mapper
 *
 * <p>
 * 
 * @author huanghuapeng 2017年11月3日
 * @see
 * @since 1.0
 */
public interface SysUserMapper extends Mapper<SysUser> {

	/**
	 * 根据名称查找用户
	 * 
	 * @param userName
	 *            用户名称
	 * @return SysUser
	 */
	public SysUser findUserByName(@Param("userName") String userName);

}