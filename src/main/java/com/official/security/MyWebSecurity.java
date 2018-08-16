package com.official.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 
 * Spring security安全校验
 * <p>
 * 
 * @author huanghuapeng 2017年11月3日
 * @see
 * @since 1.0
 */
@Configuration
@EnableWebSecurity
public class MyWebSecurity extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// 关闭csrf
		http.csrf().disable();

		http.authorizeRequests()
				/*
				 * home不需要校验
				 */
				.antMatchers("/home").permitAll()
				/*
				 * 任何请求,登录后可以访问
				 */
				.anyRequest().authenticated()
				/*
				 * 登录页面和登录成功后跳转页面
				 */
				.and().formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/", true)
				/*
				 * 登录失败后跳转页面
				 */
				.failureUrl("/login").permitAll()
				/*
				 * 
				 */
				.and().logout().permitAll();

	}

	/**
	 * 使用自定义权限提供类
	 * 
	 */
	@Bean
	public AuthenticationProvider authenticationProvider() {
		AuthenticationProvider authenticationProvider = new MyAuthenticationProvider();
		return authenticationProvider;
	}

	/**
	 * 身份验证配置，用于注入自定义身份验证Bean和密码校验规则
	 * 
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
		auth.eraseCredentials(false);
	}

	/**
	 * 配置web不要求校验的路径
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/**", "/pics/**", "/customer/**", "/subject/**", "/score/**");
	}
}
