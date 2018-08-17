package com.official.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 简单工具类
 * <p>
 * 
 * @author 3306 2017年9月18日
 * @see
 * @since 1.0
 */
public class ListMapUtil {

	/**
	 * 创建Map
	 *
	 * @return HashMap
	 */
	public static <K, V> Map<K, V> buildMap() {
		return new HashMap<K,V>(10);
	}

	/**
	 * 创建List
	 *
	 * @return ArrayList
	 */
	public static <T> List<T> buildList() {
		return new ArrayList<T>(10);
	}

	/**
	 * 创建Set
	 *
	 * @return HashSet
	 */
	public static <T> Set<T> buildSet() {
		return new HashSet<T>();
	}

	/**
	 * 判断collection是否为空,如果为空返回true
	 *
	 * @param listOrSet
	 *            集合list或者set元素
	 * @return boolean
	 */
	public static <T> boolean isEmpty(Collection<T> listOrSet) {
		return null == listOrSet || listOrSet.isEmpty();
	}

	/**
	 * 判断Map是否为空
	 *
	 * @param map
	 *            Map
	 * @return boolean
	 */
	public static <K, V> boolean isEmpty(Map<K, V> map) {
		return null == map || 0 == map.size();
	}

	/**
	 * 判断数组是否为空
	 *
	 * @param arr
	 *            数组
	 * @return boolean
	 */
	public static <T> boolean isEmpty(T[] arr) {
		return null == arr || 0 == arr.length;
	}

	/**
	 * 将数组转换成List
	 *
	 * @param arr
	 *            数组
	 * @return List
	 */
	public static <T> List<T> toList(T[] arr) {
		if (null == arr || 0 == arr.length) {
			return Collections.emptyList();
		}

		List<T> list = buildList();
		for (T each : arr) {
			list.add(each);
		}
		return list;
	}

}
