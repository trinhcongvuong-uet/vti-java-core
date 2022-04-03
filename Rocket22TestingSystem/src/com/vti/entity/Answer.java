package com.vti.entity;

public class Answer {

	private long answerId;

	private String content;

	private Question question;

	private boolean isCorrect;

	public long getAnswerId() {
		return answerId;
	}

	public void setAnswerId(long answerId) {
		this.answerId = answerId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

}
