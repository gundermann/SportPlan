package com.ng.trainplan.sportplan.persistence;

import org.droidpersistence.dao.DroidDao;
import org.droidpersistence.dao.TableDefinition;

import android.database.sqlite.SQLiteDatabase;

import com.ng.trainplan.sportplan.business.Person;

public class PersonDao extends DroidDao<Person, Long> {

	public PersonDao(TableDefinition<Person> tableDefinition,
			SQLiteDatabase database) {
		super(Person.class, tableDefinition, database);
	}

}
