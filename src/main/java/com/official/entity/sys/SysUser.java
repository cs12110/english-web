package com.official.entity.sys;

import java.util.List;

import javax.persistence.Transient;

import com.official.util.JsonUtil;

/**
 * 系统用户类
 *
 * <p>
 * 映射数据表: sys_user
 * 
 * @author huanghuapeng 2017年11月3日
 * @see
 * @since 1.0
 */
public class SysUser {

	private Integer id;

	private String userName;

	private String password;

	@Transient
	private List<SysRole> roles;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<SysRole> getRoles() {
		return roles;
	}

	public void setRoles(List<SysRole> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return JsonUtil.toJSONStr(this);
	}

}
