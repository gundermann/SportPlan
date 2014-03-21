package com.ng.trainplan.sportplan.persistence;

public enum SQLType {
	TEXT, NUMBER;

	public static SQLType valueOfJavaType(String type) {
		if (type.equals("Integer"))
			return NUMBER;
		return TEXT;
	}

	@Override
	public String toString() {
		return super.toString().toLowerCase();
	}

}
