package com.ng.trainplan.sportplan.trainingsession;

import android.app.DatePickerDialog.OnDateSetListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

import com.ng.trainplan.sportplan.trainingsession.business.TrainingSessionOrganizer;
import com.ng.trainplan.sportplan.util.DateHelper;

public class TrainingSessionConfigurator implements OnDateSetListener, OnTimeChangedListener, OnClickListener,  OnDateChangedListener {

	private TrainingSessionOrganizer organziser;
	private TrainingSessionBuilder trainingSessionBuilder;

	public TrainingSessionConfigurator(TrainingSessionOrganizer organziser) {
		this.organziser = organziser;
		this.trainingSessionBuilder = new TrainingSessionBuilder();
	}

	@Override
	public void onDateSet(DatePicker datePicher, int year, int month, int day) {
		trainingSessionBuilder.setDate(DateHelper.getDateAsString(day, month, year));
	}

	public void setupTrainingSession() {
		organziser.saveTrainingSession(trainingSessionBuilder.build());
	}

	@Override
	public void onTimeChanged(TimePicker timePicker, int hours, int minutes) {
		trainingSessionBuilder.setTime(DateHelper.convertHoursAndMinutesToLong(hours, minutes));
	}

	/**
	 * On date changed
	 * @param v
	 */
	@Override
	public void onClick(View view) {
		int year = ((DatePicker) view).getYear();
		int month = ((DatePicker) view).getMonth();
		int day = ((DatePicker) view).getDayOfMonth();
		String date = DateHelper.getDateAsString(day, month, year);
		trainingSessionBuilder.setDate(date.toString() );
	}

	@Override
	public void onDateChanged(DatePicker view, int year, int month, int day) {
		String date = DateHelper.getDateAsString(day, month, year);
		trainingSessionBuilder.setDate(date.toString() );
	}

}
