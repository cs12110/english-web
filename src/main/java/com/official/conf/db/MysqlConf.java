package com.official.conf.db;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.alibaba.fastjson.JSONObject;

/**
 * mysql数据库配置类
 *
 * <p>
 * 
 * @author huanghuapeng 2017年5月19日
 * @see
 * @since 1.0
 */
@ConfigurationProperties(prefix = MysqlConf.DB_SETTING_PREFIX)
public class MysqlConf {

	public static final String DB_SETTING_PREFIX = "druid";

	/**
	 * 数据库url
	 */
	private String url;

	/**
	 * 数据库登录用户
	 */
	private String username;

	/**
	 * 数据库密码
	 */
	private String password;

	private int maxActive;
	private int minIdle;
	private int initialSize;
	private boolean testOnBorrow;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getMaxActive() {
		return maxActive;
	}

	public void setMaxActive(int maxActive) {
		this.maxActive = maxActive;
	}

	public int getMinIdle() {
		return minIdle;
	}

	public void setMinIdle(int minIdle) {
		this.minIdle = minIdle;
	}

	public int getInitialSize() {
		return initialSize;
	}

	public void setInitialSize(int initialSize) {
		this.initialSize = initialSize;
	}

	public boolean isTestOnBorrow() {
		return testOnBorrow;
	}

	public void setTestOnBorrow(boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}

	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}

}
