package com.official.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.official.entity.sys.SysRole;

import tk.mybatis.mapper.common.Mapper;

/**
 * 系统角色Mapper
 *
 * <p>
 * 
 * @author huanghuapeng 2017年11月3日
 * @see
 * @since 1.0
 */
public interface SysRoleMapper extends Mapper<SysRole> {

	/**
	 * 查找和用户关联的角色名称
	 * 
	 * @param userId
	 *            用户Id
	 * @return List
	 */
	public List<SysRole> findRoleByUserId(@Param("userId") Integer userId);

}