package com.ng.trainplan.sportplan;

import com.ng.trainplan.sportplan.business.Person;

public interface PersonSetupListener {

	void doFinishPersonSetup();

	void updatePerson(Person person);

}

