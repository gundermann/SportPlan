package com.ng.trainplan.sportplan.person.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;


public class PersonDBOpenHelper extends SQLiteOpenHelper {

	

	public PersonDBOpenHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		getReadableDatabase();
	}
	
	@Override
	public void onOpen(SQLiteDatabase db) {
		super.onOpen(db);
	      if (!db.isReadOnly()) {
	    	  db.execSQL("PRAGMA foreign_keys=ON;");
	      }
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		try{
			PersonTableDefinition personTableDefinition = new PersonTableDefinition();
			//necessary!!!
			personTableDefinition.onCreate(db);
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