/*
 * 
 */
package com.official.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * 实体基类
 *
 * <p>
 * 包含主键 Id<br/>
 * 页码数page，默认值为1<br/>
 * 每页显示条数rows，默认值为10<br/>
 * 
 * @author leaf 2017年2月8日 https://www.leaf17.com
 * @see
 * @since 1.0
 */
public class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Transient
	private Integer page = 1;

	@Transient
	private Integer rows = 10;

	@Transient
	private Long totalCount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

}
