package com.ng.trainplan.sportplan.business;


public class Factory {

	private static Factory instance;

	public static Factory getInstance() {
		if(instance == null){
			instance = new Factory();
		}
		return instance;
	}

	public TrainingSession createTrainingSession() {
		return new TrainingSessionImpl();
	}

}
