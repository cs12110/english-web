package com.official.ctrl.sys;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 系统类
 *
 * <p>
 * 
 * @author huanghuapeng 2018年8月17日
 * @see
 * @since 1.0
 */
@Controller
public class SysCtrl {

	@RequestMapping("/")
	public String toIndexHtml() {
		return "index";
	}

	// @RequestMapping("/login")
	// public String toLoginHtml() {
	// return "sys/login";
	// }
	//
	// @RequestMapping("/sysLogin")
	// public String toSysLoginHtml() {
	// return "sys/sysLogin";
	// }
	//
	// /**
	// * 用户退出
	// *
	// * @param req
	// * HttpServletRequest
	// * @param res
	// * HttpServletResponse
	// * @return Html
	// */
	// @RequestMapping(value = "/logout")
	// public String iAmOut(HttpServletRequest req, HttpServletResponse res) {
	// Authentication auth =
	// SecurityContextHolder.getContext().getAuthentication();
	// if (auth != null) {
	// new SecurityContextLogoutHandler().logout(req, res, auth);
	// }
	// return "sys/login";
	// }

}
