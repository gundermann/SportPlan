package com.ng.trainplan.sportplan.person.persistence;

import java.util.List;

import com.ng.trainplan.sportplan.person.Person;


public interface PersonDataManager {
	
	long savePerson(Person person);
	
	List<Person> getPersonList();
	
	Person getPerson(Long id);

}
