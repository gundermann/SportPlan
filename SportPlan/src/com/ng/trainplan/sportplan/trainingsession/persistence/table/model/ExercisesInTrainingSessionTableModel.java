package com.ng.trainplan.sportplan.trainingsession.persistence.table.model;

import org.droidpersistence.annotation.Column;
import org.droidpersistence.annotation.PrimaryKey;
import org.droidpersistence.annotation.Table;

@Table(name = "Exercises_In_Session")
public class ExercisesInTrainingSessionTableModel {
	
	@PrimaryKey
	@Column(name="trainig_session_id")
	private long trainingSessionId;
	
	//TODO
	//Framework doens't support more than on primary key
	@Column(name="exercise_id")
	private long exerciseId;

	public long getTrainingSessionId() {
		return trainingSessionId;
	}

	public void setTrainingSessionId(long trainingSessionId) {
		this.trainingSessionId = trainingSessionId;
	}

	public long getExerciseId() {
		return exerciseId;
	}

	public void setExerciseId(long exerciseId) {
		this.exerciseId = exerciseId;
	}
	
	

}
