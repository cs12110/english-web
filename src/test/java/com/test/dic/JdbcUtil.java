package com.test.dic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Jdbc工具类
 *
 * <p>
 * 
 * @author cs12110 2018年3月30日上午8:33:25
 *
 */
public class JdbcUtil {

	/**
	 * 获取mysql数据库连接
	 * 
	 * @param url      url连接地址
	 * @param user     用户
	 * @param password 密码
	 * @return {@link Connection}
	 */
	public static Connection getMySqlConn(String url, String user, String password) {
		String driver = "com.mysql.jdbc.Driver";
		return getConnection(driver, url, user, password);
	}

	/**
	 * 获取数据库连接
	 * 
	 * @param driverName 驱动名称
	 * @param url        数据库连接url
	 * @param user       数据库连接用户
	 * @param password   用户登录密码
	 * @return {@link Connection}
	 */
	public static Connection getConnection(String driverName, String url, String user, String password) {
		Connection conn = null;
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 释放资源
	 * 
	 * @param conn 连接
	 * @param stm  声明
	 * @param rs   结果集
	 */
	public static void fuckoff(Connection conn, Statement stm, ResultSet rs) {
		try {
			if (null != rs && !rs.isClosed()) {
				rs.close();
			}
		} catch (Exception e) {
			// do nothing
		}

		try {
			if (null != stm && !stm.isClosed()) {
				stm.close();
			}
		} catch (Exception e) {
			// do nothing
		}

		try {
			if (null != conn && !conn.isClosed()) {
				conn.close();
			}
		} catch (Exception e) {
			// do nothing
		}
	}
}
