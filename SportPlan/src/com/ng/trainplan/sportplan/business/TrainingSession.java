package com.ng.trainplan.sportplan.business;

import java.util.List;


public interface TrainingSession extends MasterListItem{

	String getDate();

	void setDate(String dateString);

	List<Object> getExercises();

	void addExcersise(Object exercise);

	long getLength();

	void setLength(long time);
	
	List<Person> getMember();
	
	void addParticipiant(Person participiant);

 }
