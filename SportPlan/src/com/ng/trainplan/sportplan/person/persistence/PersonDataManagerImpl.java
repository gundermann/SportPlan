package com.ng.trainplan.sportplan.person.persistence;

import java.util.List;

import com.ng.trainplan.sportplan.person.business.Person;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class PersonDataManagerImpl implements PersonDataManager {

	private SQLiteDatabase database;
	private PersonDao personDao;

	public PersonDataManagerImpl(Context context){
		SQLiteOpenHelper openHelper = new PersonDBOpenHelper(context, "GAMEDATABASE",
				null, 2);
		setDatabase(openHelper.getWritableDatabase());

		this.personDao = new PersonDao(new PersonTableDefinition(), database);
	}

	private void setDatabase(SQLiteDatabase writableDatabase) {
		this.database = writableDatabase;
	}

	public Person getPerson(Long id) {
		return getPersonDao().get(id);
	}

	private PersonDao getPersonDao() {
		return personDao;
	}

	public List<Person> getPersonList() {
		return getPersonDao().getAll();
	}

	public long savePerson(Person person) {
		long result = 0;
		try {
			getDatabase().beginTransaction();
			result = getPersonDao().save(person);
			getDatabase().setTransactionSuccessful();
		} catch (Exception e) {
			e.printStackTrace();
		}
		getDatabase().endTransaction();
		return result;
	}

	private SQLiteDatabase getDatabase() {
		return database;
	}

}
