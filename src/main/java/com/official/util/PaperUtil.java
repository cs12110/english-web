package com.official.util;

import com.official.enums.PaperEnum;

/**
 * PaperEnum工具类
 *
 * <p>
 * detailed comment
 * 
 * @author huanghuapeng 2018年8月20日
 * @see
 * @since 1.0
 */
public class PaperUtil {

	/**
	 * 获取上传数据类型
	 * 
	 * @param value
	 *            数据
	 * @return {@link PaperEnum}
	 */
	public static PaperEnum getEnumValue(String value) {
		for (PaperEnum e : PaperEnum.values()) {
			if (String.valueOf(e.getValue()).equals(value)) {
				return e;
			}
		}
		return null;
	}

}
