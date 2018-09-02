package com.test.dic;

import com.alibaba.fastjson.JSON;

/**
 * 字段信息实体类
 * 
 * @author root
 *
 */
public class FieldBean {

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 类型
	 */
	private String type;

	/**
	 * 长度
	 */
	private String length;

	/**
	 * 是否为空
	 */
	private String nullable;

	/**
	 * 描述
	 */
	private String desc;

	/**
	 * 主键
	 */
	private String isKey;

	/**
	 * 自动增长
	 */
	private String autoIncre;

	/**
	 * 默认值
	 */
	private String defValue;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getNullable() {
		return nullable;
	}

	public void setNullable(String nullable) {
		this.nullable = nullable;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getIsKey() {
		return isKey;
	}

	public void setIsKey(String isKey) {
		this.isKey = isKey;
	}

	public String getAutoIncre() {
		return autoIncre;
	}

	public void setAutoIncre(String autoIncre) {
		this.autoIncre = autoIncre;
	}

	public String getDefValue() {
		return defValue;
	}

	public void setDefValue(String defValue) {
		this.defValue = defValue;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}