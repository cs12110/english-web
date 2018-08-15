package com.official.ctrl.sys;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SysCtrl {

	@RequestMapping("/")
	public String toIndexHtml() {
		return "index";
	}

	@RequestMapping("/login")
	public String toLoginHtml() {
		return "sys/login";
	}

	@RequestMapping("/sysLogin")
	public String toSysLoginHtml() {
		return "sys/sysLogin";
	}

	/**
	 * 用户退出
	 *
	 * @param req
	 *            HttpServletRequest
	 * @param res
	 *            HttpServletResponse
	 * @return Html
	 */
	@RequestMapping(value = "/logout")
	public String iAmOut(HttpServletRequest req, HttpServletResponse res) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(req, res, auth);
		}
		return "sys/login";
	}

	
}
