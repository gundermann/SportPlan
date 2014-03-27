package com.ng.trainplan.sportplan.trainingsession.business;

import java.util.List;

import com.ng.trainplan.sportplan.person.Person;

public interface TrainingSession {

	String getDate();

	void setDate(String dateString);

	List<Object> getExercises();

	void addExcersise(Object exercise);

	long getLength();

	void setLength(long time);

	List<Person> getMember();

	void addParticipiant(Person participiant);

}
