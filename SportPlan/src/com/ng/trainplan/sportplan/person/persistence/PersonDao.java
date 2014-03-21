package com.ng.trainplan.sportplan.person.persistence;

import org.droidpersistence.dao.DroidDao;
import org.droidpersistence.dao.TableDefinition;

import com.ng.trainplan.sportplan.person.business.Person;

import android.database.sqlite.SQLiteDatabase;


public class PersonDao extends DroidDao<Person, Long> {

	public PersonDao(TableDefinition<Person> tableDefinition,
			SQLiteDatabase database) {
		super(Person.class, tableDefinition, database);
	}

}
