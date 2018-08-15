package com.official.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * JSON工具类
 *
 * <p>
 *
 * @author 3306 2017年9月20日下午9:24:28
 *
 */
public class JSONUtil {

	/**
	 * Ajax跨域请求回传数据
	 * 
	 * @param obj
	 *            回传数据
	 * @return String
	 */
	public static <T> String buildCallbackJSONStr(T obj) {
		StringBuilder callback = new StringBuilder();
		callback.append("callback");
		callback.append("(");
		callback.append(toJSONStr(obj));
		callback.append(")");

		return callback.toString();
	}

	/**
	 * 将对象转换成JSON字符串
	 * <p>
	 * 如果对象为空,返回 ""
	 * 
	 * @param obj
	 *            对象
	 * @return String
	 */
	public static <T> String toJSONStr(T obj) {
		if (null == obj) {
			return "";
		}
		return JSON.toJSONString(obj);
	}

	/**
	 * 将json字符串转换成对象
	 * 
	 * @param clazz
	 *            class of T
	 * @param jsonStr
	 *            json字符串
	 * @return T
	 */
	public static <T> T parse(Class<T> clazz, String jsonStr) {
		JSONObject tmp = JSON.parseObject(jsonStr);
		return JSON.toJavaObject(tmp, clazz);
	}

}
