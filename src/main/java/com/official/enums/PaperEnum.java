package com.official.enums;

/**
 * 试卷类型
 *
 * <p>
 * 
 * @author huanghuapeng 2018年8月17日
 * @see
 * @since 1.0
 */
public enum PaperEnum {

	/**
	 * 前测
	 */
	BEFORE(1),
	/**
	 * 学习1
	 */
	LEARNING1(2),
	/**
	 * 学习2
	 */
	LEARNING2(3),
	/**
	 * 后测
	 */
	AFTER(4),
	/**
	 * 追踪
	 */
	TRACE(5);

	private final int value;

	private PaperEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
