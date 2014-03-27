package com.ng.trainplan.sportplan.trainingsession.persistence;

import java.util.List;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ng.trainplan.sportplan.business.MasterListItem;
import com.ng.trainplan.sportplan.persistence.MasterListItemDao;
import com.ng.trainplan.sportplan.persistence.MasterListItemTableDefinition;
import com.ng.trainplan.sportplan.persistence.OpenHelper;
import com.ng.trainplan.sportplan.trainingsession.business.TrainingSession;
import com.ng.trainplan.sportplan.trainingsession.persistence.table.ExerciseInSessionTableDefinition;
import com.ng.trainplan.sportplan.trainingsession.persistence.table.ParticipantsTableDefinition;

public class TrainingSessionDataManagerImpl implements TrainingSessionDataManager{
	
	private SQLiteDatabase database;
	private MasterListItemDao masterListItemDao;
	private ExerciseInSessionDao exerciseInSessionDao;
	private ParticipantsDao participantDao;

	public TrainingSessionDataManagerImpl(Context context){
		SQLiteOpenHelper openHelper = new OpenHelper(context);
		setDatabase(openHelper.getWritableDatabase());

		masterListItemDao = new MasterListItemDao(new MasterListItemTableDefinition(), database);
		exerciseInSessionDao = new ExerciseInSessionDao(new ExerciseInSessionTableDefinition(), database);
		participantDao = new ParticipantsDao(new ParticipantsTableDefinition(), database);
	}

	private void setDatabase(SQLiteDatabase writableDatabase) {
		this.database = writableDatabase;
	}
	
	@Override
	public long saveTrainingSession(TrainingSession trainingSession) throws Exception {
		MasterListItem item = new MasterListItem();
		item.setDate(trainingSession.getDate());
		return masterListItemDao.save(item);
	}

	@Override
	public List<TrainingSession> getTrainingSessionList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MasterListItem getMasterListItem(Long id) {
		return masterListItemDao.get(id);
	}

	@Override
	public List<MasterListItem> getMasterListItems() {
		return masterListItemDao.getAll();
	}

}
