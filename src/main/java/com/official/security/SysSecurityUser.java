package com.official.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.official.entity.sys.SysUser;
import com.official.service.sys.SysRoleService;

/**
 * 系统安全校验用户类
 *
 * <p>
 * detailed comment
 * 
 * @author huanghuapeng 2017年11月3日
 * @see
 * @since 1.0
 */
public class SysSecurityUser extends SysUser implements UserDetails {

	public SysSecurityUser(SysUser user, SysRoleService sysRoleService) {
		if (user != null) {
			this.setId(user.getId());
			this.setUserName(user.getUserName());
			this.setPassword(user.getPassword());
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		return authorities;
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
