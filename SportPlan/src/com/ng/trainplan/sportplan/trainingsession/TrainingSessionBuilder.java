package com.ng.trainplan.sportplan.trainingsession;

import com.ng.trainplan.sportplan.trainingsession.business.TrainingSession;
import com.ng.trainplan.sportplan.trainingsession.business.TrainingSessionImpl;
import com.ng.trainplan.sportplan.util.DateHelper;

public class TrainingSessionBuilder {
	
	
	private long time = DateHelper.getCurrentTime();
	private String date = DateHelper.getCurrentDateAsString();

	public TrainingSessionBuilder setDate(String date){
		this.date  = date;
		return this;
	}
	
	public TrainingSession build(){
		TrainingSession ts = new TrainingSessionImpl();
		ts.setDate(date);
		ts.setStart(time);
		return ts;
	}

	public TrainingSessionBuilder setTime(long time) {
		this.time  = time;
		return this;
	}
}
