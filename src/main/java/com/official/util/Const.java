package com.official.util;

/**
 * 静态常量
 *
 * <p>
 * 
 * @author huanghuapeng 2018年8月17日
 * @see
 * @since 1.0
 */
public class Const {

	/**
	 * 超级管理员名称
	 */
	public static final String SYS_ADMIN = "admin";

	/**
	 * 超级管理员角色
	 */
	public final static String ADMIN_ROLE = Const.ROLE_PREFIX + "ADMIN";

	/**
	 * 角色前缀"ROLE_"
	 */
	public final static String ROLE_PREFIX = "ROLE_";

	/**
	 * 保存用户的session key
	 */
	public final static String USER_SESSION_KEY = "user";

	/**
	 * 保存管理员的session key
	 */
	public final static String ADMIN_SESSION_KEY = "admin";

	/**
	 * 多个单词之间的分隔符
	 */
	public static final String EACH_SPLIT = ",";

	/**
	 * 每个单词和时间之间的分隔符
	 */
	public static final String BETWEEN_SPLIT = "#";
}
