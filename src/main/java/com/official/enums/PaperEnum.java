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
	BEFORE(1, "前测"),
	/**
	 * 学习1
	 */
	LEARNING1(2, "学习1"),
	/**
	 * 学习2
	 */
	LEARNING2(3, "学习2"),
	/**
	 * 后测
	 */
	AFTER(4, "后测"),
	/**
	 * 追踪
	 */
	TRACE(5, "追踪");

	private final int value;

	private final String name;

	private PaperEnum(int value, String name) {
		this.value = value;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getValue() {
		return value;
	}
}
