package com.ng.trainplan.sportplan.person;

import com.ng.trainplan.sportplan.person.business.Person;


public class PersonBuilder {
	
	private String firstname = "";
	private String lastname = "";

	public PersonBuilder setFirstname(String firstName) {
		firstname = firstName;
		return this;
	}

	public PersonBuilder setLastname(String lastName) {
		lastname = lastName;
		return this;
	}
	
	public Person build(){
		Person person = new Person();
		person.setFirstname(firstname);
		person.setLastname(lastname);
		return person;
	}
}
