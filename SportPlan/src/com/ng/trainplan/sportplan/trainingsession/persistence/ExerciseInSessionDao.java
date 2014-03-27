package com.ng.trainplan.sportplan.trainingsession.persistence;

import org.droidpersistence.dao.DroidDao;

import android.database.sqlite.SQLiteDatabase;

import com.ng.trainplan.sportplan.trainingsession.persistence.table.ExerciseInSessionTableDefinition;
import com.ng.trainplan.sportplan.trainingsession.persistence.table.model.ExercisesInTrainingSessionTableModel;

public class ExerciseInSessionDao extends DroidDao<ExercisesInTrainingSessionTableModel, Long> {

	public ExerciseInSessionDao(ExerciseInSessionTableDefinition tableDefinition,
			SQLiteDatabase database) {
		super(ExercisesInTrainingSessionTableModel.class, tableDefinition, database);
		
	}
}
