package com.vti.entity;

public class TypeQuestion {

	private long typeId;

	private TypeQuestEnum typeName;

	public long getTypeId() {
		return typeId;
	}

	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}

	public TypeQuestEnum getTypeName() {
		return typeName;
	}

	public void setTypeName(TypeQuestEnum typeName) {
		this.typeName = typeName;
	}

}
