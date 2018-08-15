package com.official.entity.reply;

import java.util.List;

import com.official.util.JSONUtil;

public class BaseResultEntity<T> {

	private String code;

	private String desc;

	private T value;

	private List<T> values;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public List<T> getValues() {
		return values;
	}

	public void setValues(List<T> values) {
		this.values = values;
	}

	@Override
	public String toString() {
		return JSONUtil.toJSONStr(this);
	}

}
