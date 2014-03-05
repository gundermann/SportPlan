package com.ng.trainplan.exerciseplan.mock;

import java.util.ArrayList;
import java.util.List;

import com.ng.trainplan.exerciseplan.business.ExerciseComponent;
import com.ng.trainplan.exerciseplan.business.Position;

public class ExerciseComponentMock {

	public static List<ExerciseComponent> createList() {
		List<ExerciseComponent> mocklist = new ArrayList<ExerciseComponent>();

		mocklist.add(create("Oi-Tsuki"));
		mocklist.add(create("ZKD"));
		mocklist.add(create("Vorwärts in ZKD"));
		
		return mocklist;
	}

	private static ExerciseComponent create(String name) {
		Position pos = new Position();
		pos.setName(name);
		return pos;
	}

	

}
