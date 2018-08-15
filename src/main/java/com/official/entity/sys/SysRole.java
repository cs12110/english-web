package com.official.entity.sys;

import com.official.util.JSONUtil;

/**
 * 系统角色类
 *
 * <p>
 * 
 * 映射数据表: sys_role
 * 
 * @author huanghuapeng 2017年11月3日
 * @see
 * @since 1.0
 */
public class SysRole {

	private Integer id;

	private String roleName;

	private String roleCode;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	@Override
	public String toString() {
		return JSONUtil.toJSONStr(this);
	}

}
