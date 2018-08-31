package com.official.entity;

import javax.persistence.Table;

import com.official.util.JsonUtil;

/**
 * 句子对象
 * 
 * @author huanghuapeng 2018年8月17日
 * @see
 * @since 1.0
 */
@Table(name = "subject_t")
public class Subject extends BaseEntity {

	/**
	 * 句子
	 */
	private String sentence;

	/**
	 * 类型
	 */
	private Integer type;

	/**
	 * 问题
	 */
	private String question;

	/**
	 * 答案
	 */
	private String answer;

	/**
	 * 测试类型
	 */
	private Integer paper;

	/**
	 * 原句子
	 */
	private String origin;

	/**
	 * @return sentence
	 */
	public String getSentence() {
		return sentence;
	}

	/**
	 * @param sentence
	 */
	public void setSentence(String sentence) {
		this.sentence = sentence == null ? null : sentence.trim();
	}

	/**
	 * @return type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * @param type
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * @return question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @param question
	 */
	public void setQuestion(String question) {
		this.question = question == null ? null : question.trim();
	}

	/**
	 * @return answer
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * @param answer
	 */
	public void setAnswer(String answer) {
		this.answer = answer == null ? null : answer.trim();
	}

	public Integer getPaper() {
		return paper;
	}

	public void setPaper(Integer paper) {
		this.paper = paper;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	@Override
	public String toString() {
		return JsonUtil.toJSONStr(this);
	}

}