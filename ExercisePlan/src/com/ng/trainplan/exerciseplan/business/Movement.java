package com.ng.trainplan.exerciseplan.business;

public class Movement extends ExerciseComponent {

	private Direction direction;
	private Position nextPosition;

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Position getNextPosition() {
		return nextPosition;
	}

	public void setNextPosition(Position nextPosition) {
		this.nextPosition = nextPosition;
	}

}
