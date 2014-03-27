package com.ng.trainplan.sportplan.trainingsession;

import android.app.DatePickerDialog.OnDateSetListener;
import android.widget.DatePicker;

import com.ng.trainplan.sportplan.trainingsession.business.TrainingSessionOrganizer;
import com.ng.trainplan.sportplan.util.DateHelper;

public class TrainingSessionConfigurator implements OnDateSetListener {

	private TrainingSessionOrganizer organziser;
	private TrainingSessionBuilder trainingSessionBuilder;

	public TrainingSessionConfigurator(TrainingSessionOrganizer organziser) {
		this.organziser = organziser;
		this.trainingSessionBuilder = new TrainingSessionBuilder();
	}

	@Override
	public void onDateSet(DatePicker datePicher, int year, int month, int day) {
		trainingSessionBuilder.setDate(DateHelper.getDateAsString(day, month, year));
		setupTrainingSession();
	}

	private void setupTrainingSession() {
		organziser.saveTrainingSession(trainingSessionBuilder.build());
	}

}
