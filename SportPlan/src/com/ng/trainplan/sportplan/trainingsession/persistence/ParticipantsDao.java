package com.ng.trainplan.sportplan.trainingsession.persistence;

import org.droidpersistence.dao.DroidDao;

import android.database.sqlite.SQLiteDatabase;

import com.ng.trainplan.sportplan.trainingsession.persistence.table.ParticipantsTableDefinition;
import com.ng.trainplan.sportplan.trainingsession.persistence.table.model.ParticipantsTableModel;

public class ParticipantsDao extends DroidDao<ParticipantsTableModel, Long> {

	public ParticipantsDao(ParticipantsTableDefinition tableDefinition,
			SQLiteDatabase database) {
		super(ParticipantsTableModel.class, tableDefinition, database);
	}
}
