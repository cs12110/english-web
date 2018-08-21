package com.official.entity;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 进度实体类
 *
 * <p>
 * detailed comment
 * 
 * @author huanghuapeng 2018年8月21日
 * @see
 * @since 1.0
 */
@Table(name = "progress_t")
public class Progress extends BaseEntity {

	/**
	 * 试卷类型
	 */
	private Integer paper;

	private String name;

	/**
	 * 是否打开测试,0:否,1:是
	 */
	private Integer open;

	@Column(name = "op_time")
	private String opTime;

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
	 * @return op_time
	 */
	public String getOpTime() {
		return opTime;
	}

	/**
	 * @param opTime
	 */
	public void setOpTime(String opTime) {
		this.opTime = opTime == null ? null : opTime.trim();
	}
}