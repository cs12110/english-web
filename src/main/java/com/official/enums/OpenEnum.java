package com.official.enums;

/**
 * 
 * 打开关闭枚举类
 *
 * @author huanghuapeng 2018年8月21日
 * @see
 * @since 1.0
 */
public enum OpenEnum {

	/**
	 * 关闭
	 */
	CLOSE(0),

	/**
	 * 关闭
	 */
	OPEN(1);

	private final int value;
	private OpenEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
