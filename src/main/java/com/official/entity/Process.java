package com.official.entity;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "process_t")
public class Process extends BaseEntity {

	/**
	 * 试卷类型
	 */
	private Integer paper;

	private String name;

	/**
	 * 是否打开测试,0:否,1:是
	 */
	private Integer open;

	@Column(name = "open_time")
	private String openTime;

	/**
	 * 获取试卷类型
	 *
	 * @return paper - 试卷类型
	 */
	public Integer getPaper() {
		return paper;
	}

	/**
	 * 设置试卷类型
	 *
	 * @param paper
	 *            试卷类型
	 */
	public void setPaper(Integer paper) {
		this.paper = paper;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * 获取是否打开测试,0:否,1:是
	 *
	 * @return open - 是否打开测试,0:否,1:是
	 */
	public Integer getOpen() {
		return open;
	}

	/**
	 * 设置是否打开测试,0:否,1:是
	 *
	 * @param open
	 *            是否打开测试,0:否,1:是
	 */
	public void setOpen(Integer open) {
		this.open = open;
	}

	/**
	 * @return open_time
	 */
	public String getOpenTime() {
		return openTime;
	}

	/**
	 * @param openTime
	 */
	public void setOpenTime(String openTime) {
		this.openTime = openTime == null ? null : openTime.trim();
	}
}