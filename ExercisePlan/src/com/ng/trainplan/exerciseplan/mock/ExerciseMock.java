package com.ng.trainplan.exerciseplan.mock;


import java.util.Random;

import org.mockito.Mockito;

import com.ng.trainplan.exerciseplan.business.Direction;
import com.ng.trainplan.exerciseplan.business.Exercise;
import com.ng.trainplan.exerciseplan.business.Movement;
import com.ng.trainplan.exerciseplan.business.Position;
import com.ng.trainplan.exerciseplan.business.Techniuqe;
public class ExerciseMock {

	public static Exercise createExerciseMock(){
		Exercise ex = Mockito.mock(Exercise.class);
		
		Mockito.when(ex.getInitinalPosition()).thenReturn(getRandomPose());
		
		Mockito.when(ex.getMovement()).thenReturn(getRandomMovement());
		
		Mockito.when(ex.getTechnique()).thenReturn(getRandomTechnique());
		
		return ex;
	}

	private static Movement getRandomMovement() {
			Movement m = new Movement();
			m.setNextPosition(getRandomPose());
			m.setDirection(getRandomDirection());
			return m;
	}

	private static Direction getRandomDirection() {
		
		switch (new Random(2).nextInt()) {
		case 0:
			return Direction.BACKWARD;
		case 1:
			return Direction.FORWARD;
		case 2:
			return Direction.LEFT;
		default:
			return Direction.RIGHT;
		}
	}

	private static Techniuqe getRandomTechnique() {
		Techniuqe tech = new Techniuqe();
		tech.setName("OI-Tsuki");
		return tech;
	}

	private static Position getRandomPose() {
		Position pos = new Position();
		pos.setName("ZKD");
		return pos;
	}
}
