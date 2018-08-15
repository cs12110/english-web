package com.official.util;


/**
 * 字符串工具类
 * 
 * @author 3306 2017年9月27日下午7:26:35
 *
 */
public class StrUtil {

	/**
	 * 判断字符串是否不为空
	 *
	 * @param str
	 *            字符串
	 * @return boolean
	 */
	public static boolean isNotEmpty(String str) {
		return isEmpty(str) ? false : true;
	}

	/**
	 * 判断字符串是否为空,空则返回true
	 *
	 * @param str
	 *            字符串
	 * @return boolean
	 */
	public static boolean isEmpty(String str) {
		return null == str || "".equals(str.trim());
	}
}
