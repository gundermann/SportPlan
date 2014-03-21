package com.ng.trainplan.sportplan.persistence.table;

import org.droidpersistence.dao.TableDefinition;

import com.ng.trainplan.sportplan.business.Person;

public class PersonTableDefinition extends TableDefinition<Person> {

	public PersonTableDefinition() {
		super(Person.class);
	}

}
