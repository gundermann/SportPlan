package com.ng.trainplan.sportplan.business;

import java.util.ArrayList;
import java.util.List;

import com.ng.trainplan.sportplan.util.DateHelper;

public class TrainingSessionImpl implements TrainingSession {

	// TODO use id from database when persistence is enabled
	private int id = 0;
	private String date;
	private List<Object> exercises;
	private long length;
	private List<Person> participants;

	public TrainingSessionImpl() {

	}

	@Override
	public String toString() {
		return "Trainingseinheit: " + getDate();
	}

	@Override
	public String getDate() {
		if (date == null) {
			setDate(DateHelper.getCurrentDateAsString());
		}
		return this.date;
	}

	@Override
	public void setDate(String dateString) {
		this.date = dateString;
	}

	@Override
	public List<Object> getExercises() {
		if (this.exercises == null) {
			this.exercises = new ArrayList<Object>();
		}
		return this.exercises;
	}

	@Override
	public void addExcersise(Object exercise) {
		if (this.exercises == null) {
			this.exercises = new ArrayList<Object>();
		}
		this.exercises.add(exercise);
	}

	@Override
	public long getLength() {
		return this.length;
	}

	@Override
	public void setLength(long time) {
		this.length = time;
	}

	@Override
	public List<Person> getMember() {
		if (participants == null) {
			this.participants = new ArrayList<Person>();
		}
		return participants;
	}

	@Override
	public void addParticipiant(Person participiant) {
		if (this.participants == null) {
			this.participants = new ArrayList<Person>();
		}
		this.participants.add(participiant);
	}

	@Override
	public int getId() {
		return id;
	}
}
