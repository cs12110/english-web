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
	 * 阅读时间1
	 */
	@Column(name = "read_time1")
	private Integer readTime1;

	/**
	 * 阅读时间2
	 */
	@Column(name = "read_time2")
	private Integer readTime2;

	/**
	 * 阅读时间3
	 */
	@Column(name = "read_time3")
	private Integer readTime3;

	/**
	 * 阅读时间4
	 */
	@Column(name = "read_time4")
	private Integer readTime4;

	/**
	 * 阅读时间5
	 */
	@Column(name = "read_time5")
	private Integer readTime5;

	/**
	 * 答案是否正确
	 */
	private Integer correct;

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

	/**
	 * @return read_time1
	 */
	public Integer getReadTime1() {
		return readTime1;
	}

	/**
	 * @param readTime1
	 */
	public void setReadTime1(Integer readTime1) {
		this.readTime1 = readTime1;
	}

	/**
	 * @return read_time2
	 */
	public Integer getReadTime2() {
		return readTime2;
	}

	/**
	 * @param readTime2
	 */
	public void setReadTime2(Integer readTime2) {
		this.readTime2 = readTime2;
	}

	/**
	 * @return read_time3
	 */
	public Integer getReadTime3() {
		return readTime3;
	}

	/**
	 * @param readTime3
	 */
	public void setReadTime3(Integer readTime3) {
		this.readTime3 = readTime3;
	}

	/**
	 * @return read_time4
	 */
	public Integer getReadTime4() {
		return readTime4;
	}

	/**
	 * @param readTime4
	 */
	public void setReadTime4(Integer readTime4) {
		this.readTime4 = readTime4;
	}

	/**
	 * @return read_time5
	 */
	public Integer getReadTime5() {
		return readTime5;
	}

	/**
	 * @param readTime5
	 */
	public void setReadTime5(Integer readTime5) {
		this.readTime5 = readTime5;
	}

	public Integer getCorrect() {
		return correct;
	}

	public void setCorrect(Integer correct) {
		this.correct = correct;
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