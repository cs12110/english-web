package com.official.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.official.entity.sys.SysUser;
import com.official.service.sys.SysRoleService;
import com.official.service.sys.SysUserService;

/**
 * 系统安全业务类
 *
 * <p>
 * 
 * @author huanghuapeng 2017年11月3日
 * @see
 * @since 1.0
 */
@Service
public class SysSecurityServiceImpl implements UserDetailsService {

	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private SysRoleService sysRoleService;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		SysUser sysUser = sysUserService.findByUserName(username);

		if (null == sysUser) {
			throw new UsernameNotFoundException("用户名不存在");
		}

		return new SysSecurityUser(sysUser, sysRoleService);
	}
}
