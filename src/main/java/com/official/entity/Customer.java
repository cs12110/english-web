package com.official.entity;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "customer_t")
public class Customer extends BaseEntity {

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 学号
	 */
	private String code;

	/**
	 * 四级成绩
	 */
	private Integer cet4;

	/**
	 * 六级成绩
	 */
	private String cet6;

	/**
	 * 年龄
	 */
	private Integer age;

	/**
	 * 学习英语成绩
	 */
	@Column(name = "eng_age")
	private Integer engAge;

	/**
	 * 四级专业
	 */
	private String major;

	/**
	 * 性别,0:女,1:女
	 */
	private Integer gender;

	/**
	 * 获取名称
	 *
	 * @return name - 名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置名称
	 *
	 * @param name
	 *            名称
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * 获取学号
	 *
	 * @return code - 学号
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 设置学号
	 *
	 * @param code
	 *            学号
	 */
	public void setCode(String code) {
		this.code = code == null ? null : code.trim();
	}

	/**
	 * 获取四级成绩
	 *
	 * @return cet4 - 四级成绩
	 */
	public Integer getCet4() {
		return cet4;
	}

	/**
	 * 设置四级成绩
	 *
	 * @param cet4
	 *            四级成绩
	 */
	public void setCet4(Integer cet4) {
		this.cet4 = cet4;
	}

	/**
	 * 获取六级成绩
	 *
	 * @return cet6 - 六级成绩
	 */
	public String getCet6() {
		return cet6;
	}

	/**
	 * 设置六级成绩
	 *
	 * @param cet6
	 *            六级成绩
	 */
	public void setCet6(String cet6) {
		this.cet6 = cet6 == null ? null : cet6.trim();
	}

	/**
	 * 获取年龄
	 *
	 * @return age - 年龄
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * 设置年龄
	 *
	 * @param age
	 *            年龄
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * 获取学习英语成绩
	 *
	 * @return eng_age - 学习英语成绩
	 */
	public Integer getEngAge() {
		return engAge;
	}

	/**
	 * 设置学习英语成绩
	 *
	 * @param engAge
	 *            学习英语成绩
	 */
	public void setEngAge(Integer engAge) {
		this.engAge = engAge;
	}

	/**
	 * 获取四级专业
	 *
	 * @return major - 四级专业
	 */
	public String getMajor() {
		return major;
	}

	/**
	 * 设置四级专业
	 *
	 * @param major
	 *            四级专业
	 */
	public void setMajor(String major) {
		this.major = major == null ? null : major.trim();
	}

	/**
	 * 获取性别,0:女,1:女
	 *
	 * @return gender - 性别,0:女,1:女
	 */
	public Integer getGender() {
		return gender;
	}

	/**
	 * 设置性别,0:女,1:女
	 *
	 * @param gender
	 *            性别,0:女,1:女
	 */
	public void setGender(Integer gender) {
		this.gender = gender;
	}
}