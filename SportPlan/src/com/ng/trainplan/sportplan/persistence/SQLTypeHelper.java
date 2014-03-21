package com.ng.trainplan.sportplan.persistence;

import java.util.Set;

public class SQLTypeHelper {

	public static String[] toStringArray(Set<String> keySet) {
		String[] stringArray = new String[keySet.size()];
		int counter = 0;
		for(String string : keySet){
			stringArray[counter] = string;
			counter++;
		}
		return stringArray;
	}

	public static String extractTableNameFromClassName(String name) {
		return name.substring(name.lastIndexOf('.')+1);
	}

}
