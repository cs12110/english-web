package com.official.util;

import java.security.MessageDigest;

/**
 * MD5加密工具类
 *
 * <p>
 * 
 * @author huanghuapeng 2017年11月3日
 * @see
 * @since 1.0
 */
public class Md5Util {

	/**
	 * 附加加密字符串
	 */
	private static final String SALT = "MisterBook";

	/**
	 * 加密密码
	 * 
	 * @param password 密码
	 * @param len      长度
	 * @return String
	 */
	public static String encode(String password, int len) {
		return encode(password).substring(0, len);
	}

	/**
	 * 带盐加密
	 * 
	 * @param password 密码
	 * 
	 * @return String
	 */
	public static String encodeWithSalt(String password) {
		return encode(password + SALT);
	}

	/**
	 * 加密密码(加盐)
	 * 
	 * @param password 密码
	 * @return String 32位长度字符串
	 */
	public static String encode(String password) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		byte[] md5Bytes = md5.digest(password.getBytes());
		StringBuffer hexValue = new StringBuffer();

		for (int i = 0, len = md5Bytes.length; i < len; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16) {
				hexValue.append("0");
			}
			hexValue.append(Integer.toHexString(val));
		}

		return hexValue.toString();
	}

	public static void main(String[] args) {
		System.out.println(encode("123456"));
	}
}
