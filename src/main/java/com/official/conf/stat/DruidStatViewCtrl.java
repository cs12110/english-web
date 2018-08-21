package com.official.conf.stat;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.alibaba.druid.support.http.StatViewServlet;

@WebServlet(urlPatterns = "/druid/*", initParams = {
		/**
		 * User
		 */
		@WebInitParam(name = "loginUsername", value = "admin"),
		/**
		 * password
		 */
		@WebInitParam(name = "loginPassword", value = "admin")})
/**
 * Druid Stat
 *
 * <p>
 * 
 * @author huanghuapeng 2018年8月21日
 * @see
 * @since 1.0
 */
public class DruidStatViewCtrl extends StatViewServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
