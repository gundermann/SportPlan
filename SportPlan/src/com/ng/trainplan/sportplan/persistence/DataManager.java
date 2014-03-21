package com.ng.trainplan.sportplan.persistence;

import java.util.List;

import com.ng.trainplan.sportplan.business.Person;

public interface DataManager {
	
	long savePerson(Person person);
	
	List<Person> getPersonList();
	
	Person getPerson(Long id);

}
