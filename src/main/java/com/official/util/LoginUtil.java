package com.official.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.official.entity.Customer;
import com.official.entity.reply.Reply;
import com.official.enums.StatusEnum;

/**
 * 登录判断工具类
 *
 * <p>
 * detailed comment
 * 
 * @author huanghuapeng 2018年8月21日
 * @see
 * @since 1.0
 */
public class LoginUtil {
	/**
	 * 判断管理员是否已登录
	 * 
	 * @param req 请求
	 * @return boolean
	 */
	public static boolean isAdminLogined(HttpServletRequest req) {
		HttpSession session = req.getSession();
		Object admin = session.getAttribute(Const.ADMIN_SESSION_KEY);
		return null != admin;
	}

	/**
	 * 获取当前请求用户
	 * 
	 * @param req {@link HttpServletRequest}
	 * @return {@link Customer}
	 */
	public static Customer getCurrentCustomer(HttpServletRequest req) {
		HttpSession session = req.getSession();
		Object user = session.getAttribute(Const.USER_SESSION_KEY);
		return user == null ? null : (Customer) user;
	}

	/**
	 * 请登录提醒
	 * 
	 * @return {@link Reply}
	 */
	public static Reply pleaseLoginHandsup() {
		Reply reply = new Reply();
		reply.setStatus(StatusEnum.FAILURE.getValue());
		reply.setMessage("请先登录");
		return reply;
	}

}
