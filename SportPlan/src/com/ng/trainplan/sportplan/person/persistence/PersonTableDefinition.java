package com.ng.trainplan.sportplan.person.persistence;

import org.droidpersistence.dao.TableDefinition;

import com.ng.trainplan.sportplan.person.Person;


public class PersonTableDefinition extends TableDefinition<Person> {

	public PersonTableDefinition() {
		super(Person.class);
	}

}
