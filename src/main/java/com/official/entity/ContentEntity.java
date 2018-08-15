package com.official.entity;

import java.io.Serializable;

import com.official.util.JSONUtil;

/**
 * 
 * 内容实体类
 * <p>
 * 
 * @author huanghuapeng 2017年11月1日
 * @see
 * @since 1.0
 */
public class ContentEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * id主键
	 */
	protected Integer id;

	protected Integer orderNum;
	/**
	 * 名称
	 */
	protected String name;

	/**
	 * 描述
	 */
	protected String summary;

	/**
	 * 具体内容
	 */
	protected String content;

	/**
	 * 创建时间
	 */
	protected String createTime;

	/**
	 * 更新时间
	 */
	protected String updateTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return summary;
	}

	public void setDesc(String desc) {
		this.summary = desc;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return JSONUtil.toJSONStr(this);
	}

}
