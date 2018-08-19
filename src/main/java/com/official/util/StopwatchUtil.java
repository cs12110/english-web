package com.official.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

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
	 * 处理前端传递过来的json字符串
	 * 
	 * 格式为:
	 * 
	 * <pre>
	 *     word1#times,word2#times...
	 * </pre>
	 * 
	 * @param stopwatch
	 *            每个单词的统计时间
	 * @return String
	 */
	public static String flat(String stopwatch) {
		StringBuilder builder = new StringBuilder();
		try {
			JSONObject jsonObject = JSON.parseObject(stopwatch);
			Set<Entry<String, Object>> entrys = jsonObject.entrySet();
			int size = entrys.size();

			int index = 0;
			for (Entry<String, Object> each : entrys) {
				Integer time = (Integer) each.getValue();
				builder.append(each.getKey()).append(BETWEEN_SPLIT).append(time);
				if (index++ < size - 1) {
					builder.append(EACH_SPLIT);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return builder.toString();
	}

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

		Map<String, Integer> map = new HashMap<String, Integer>();
		String[] valueArr = stopwatch.split(EACH_SPLIT);
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
