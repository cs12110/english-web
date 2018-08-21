package com.official.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * stopwatch处理工具类
 *
 * <p>
 * 
 * @author huanghuapeng 2018年8月19日
 * @see
 * @since 1.0
 */
public class StopwatchUtil {

	private static final String EACH_SPLIT = ",";
	private static final String BETWEEN_SPLIT = "#";

	/**
	 * 将字符串转成Map
	 * 
	 * @param stopwatch
	 *            字符串
	 * @return Map
	 */
	public static Map<String, Integer> fat(String stopwatch) {
		if (StrUtil.isEmpty(stopwatch)) {
			return Collections.emptyMap();
		}

		String[] valueArr = stopwatch.split(EACH_SPLIT);
		Map<String, Integer> map = new HashMap<String, Integer>(valueArr.length);

		for (String each : valueArr) {
			try {
				String[] values = each.split(BETWEEN_SPLIT);
				map.put(values[0], Integer.parseInt(values[1]));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return map;
	}

}
