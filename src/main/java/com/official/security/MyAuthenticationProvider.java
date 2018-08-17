package com.official.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.official.util.Md5Util;

/**
 * 
 * 权限供应
 * <p>
 * 
 * @author huanghuapeng 2017年11月3日
 * @see
 * @since 1.0
 */
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private SysSecurityServiceImpl securityService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = authentication.getName();
		String password = (String) authentication.getCredentials();
		String secret = Md5Util.encode(password);

		SysSecurityUser userDetials = (SysSecurityUser) securityService.loadUserByUsername(username);

		// 输入密码与账号密码不一致
		if (!secret.equals(userDetials.getPassword())) {
			throw new BadCredentialsException("密码不正确");
		}

		return new UsernamePasswordAuthenticationToken(userDetials, password, userDetials.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}
