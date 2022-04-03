package com.vti.entity;

import java.time.LocalDate;

public class Group {

	private long groupId;

	private String groupName;

	private Account creator;

	private LocalDate createDate;

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
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
