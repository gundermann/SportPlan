package com.ng.trainplan.sportplan.persistence;

import java.util.List;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ng.trainplan.sportplan.business.Person;
import com.ng.trainplan.sportplan.persistence.table.PersonTableDefinition;

public class DataManagerImpl implements DataManager {

	private SQLiteDatabase database;
	private PersonDao personDao;

	public DataManagerImpl(Context context){
		SQLiteOpenHelper openHelper = new OpenHelper(context, "GAMEDATABASE",
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
