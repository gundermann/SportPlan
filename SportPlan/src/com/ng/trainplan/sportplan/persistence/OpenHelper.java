package com.ng.trainplan.sportplan.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ng.trainplan.sportplan.person.persistence.PersonTableDefinition;
import com.ng.trainplan.sportplan.trainingsession.persistence.table.ExerciseInSessionTableDefinition;
import com.ng.trainplan.sportplan.trainingsession.persistence.table.ParticipantsTableDefinition;


public class OpenHelper extends SQLiteOpenHelper {

	

	private static final int VERSION = 1;
	private static final String NAME = "SportPlan.db";

	public OpenHelper(Context context) {
		super(context, NAME, null, VERSION);
		getReadableDatabase();
	}
	
	@Override
	public void onOpen(SQLiteDatabase db) {
		super.onOpen(db);
	      if (!db.isReadOnly()) {
	    	  db.execSQL("PRAGMA foreign_keys=ON;");
	      }
	}

	@SuppressWarnings("static-access")
	@Override
	public void onCreate(SQLiteDatabase db) {
		try{
			PersonTableDefinition personTableDefinition = new PersonTableDefinition();
			//necessary!!!
			personTableDefinition.onCreate(db);
			MasterListItemTableDefinition masterListItemTableDefinition = new MasterListItemTableDefinition();
			masterListItemTableDefinition.onCreate(db);
			ExerciseInSessionTableDefinition exerciseInSessionTableDefinition = new ExerciseInSessionTableDefinition();
			exerciseInSessionTableDefinition.onCreate(db);
			ParticipantsTableDefinition participantsTableDefinition = new ParticipantsTableDefinition();
			participantsTableDefinition.onCreate(db);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		try{
			PersonTableDefinition.onUpgrade(db, oldVersion, newVersion);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
