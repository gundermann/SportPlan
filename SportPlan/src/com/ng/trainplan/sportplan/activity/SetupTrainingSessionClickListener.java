package com.ng.trainplan.sportplan.activity;

import com.ng.trainplan.sportplan.trainingsession.TrainingSessionConfigurator;

import android.view.View;
import android.view.View.OnClickListener;

public class SetupTrainingSessionClickListener implements OnClickListener {

	private TrainingSessionConfigurator configurator;
	private PopupElement popup;

	public SetupTrainingSessionClickListener(
			TrainingSessionConfigurator configurator, PopupElement popup) {
		this.popup = popup;
				this.configurator = configurator;
	}

	@Override
	public void onClick(View view) {
		popup.close();
		configurator.setupTrainingSession();
	}

}
