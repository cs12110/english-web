package com.official.entity;

import javax.persistence.*;

import com.official.util.JsonUtil;

/**
 * 成绩实体类
 *
 * @author huanghuapeng 2018年8月17日
 * @see
 * @since 1.0
 */
@Table(name = "score_t")
public class Score extends BaseEntity {

	/**
	 * 用户Id
	 */
	@Column(name = "cus_id")
	private Integer cusId;

	/**
	 * 句子Id
	 */
	@Column(name = "sub_id")
	private Integer subId;

	/**
	 * 答案是否正确
	 */
	private Integer correct;

	private String stopwatch;

	/**
	 * 关联用户对象
	 */
	@Transient
	private Customer customer;

	/**
	 * 关联句子对象
	 */
	@Transient
	private Subject subject;

	/**
	 * @return cus_id
	 */
	public Integer getCusId() {
		return cusId;
	}

	/**
	 * @param cusId
	 */
	public void setCusId(Integer cusId) {
		this.cusId = cusId;
	}

	/**
	 * @return sub_id
	 */
	public Integer getSubId() {
		return subId;
	}

	/**
	 * @param subId
	 */
	public void setSubId(Integer subId) {
		this.subId = subId;
	}

	public Integer getCorrect() {
		return correct;
	}

	public void setCorrect(Integer correct) {
		this.correct = correct;
	}

	public String getStopwatch() {
		return stopwatch;
	}

	public void setStopwatch(String stopwatch) {
		this.stopwatch = stopwatch;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return JsonUtil.toJSONStr(this);
	}

}