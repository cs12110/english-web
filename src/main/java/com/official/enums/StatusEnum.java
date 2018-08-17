package com.official.enums;

/**
 * 回复状态
 *
 * <p>
 * 
 * @author huanghuapeng 2018年8月17日
 * @see
 * @since 1.0
 */
public enum StatusEnum {

	/**
	 * 成功
	 */
	SUCCESS(1),

	/**
	 * 失败
	 */
	FAILURE(0);

	private final int value;

	private StatusEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
