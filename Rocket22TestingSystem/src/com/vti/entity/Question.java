package com.vti.entity;

import java.time.LocalDate;

public class Question {

	private long questionId;

	private String content;

	private CategoryQuestion category;

	private TypeQuestion type;

	private Account creator;

	private LocalDate createDate;

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public CategoryQuestion getCategory() {
		return category;
	}

	public void setCategory(CategoryQuestion category) {
		this.category = category;
	}

	public TypeQuestion getType() {
		return type;
	}

	public void setType(TypeQuestion type) {
		this.type = type;
	}

	public Account getCreator() {
		return creator;
	}

	public void setCreator(Account creator) {
		this.creator = creator;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

}
