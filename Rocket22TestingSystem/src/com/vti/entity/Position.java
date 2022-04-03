package com.vti.entity;

public class Position {

	private long positionId;

	private PositionNameEnum positionName;

	public long getPositionId() {
		return positionId;
	}

	public void setPositionId(long positionId) {
		this.positionId = positionId;
	}

	public PositionNameEnum getPositionName() {
		return positionName;
	}

	public void setPositionName(PositionNameEnum positionName) {
		this.positionName = positionName;
	}

}
