package com.official.entity;

import javax.persistence.Table;

import com.official.util.JSONUtil;

@Table(name = "subject_t")
public class Subject extends BaseEntity {

	private String sentence;

	private String keyword;

	private Integer type;

	private String question;

	private String answer;

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
	 * @return keyword
	 */
	public String getKeyword() {
		return keyword;
	}

	/**
	 * @param keyword
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword == null ? null : keyword.trim();
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

	@Override
	public String toString() {
		return JSONUtil.toJSONStr(this);
	}

}