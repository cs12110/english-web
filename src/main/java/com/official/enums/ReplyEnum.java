package com.official.enums;

public enum ReplyEnum {

	SUCCESS(1),

	FAILURE(0);

	private final int value;

	private ReplyEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
