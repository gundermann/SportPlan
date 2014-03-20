package com.ng.trainplan.sportplan.activity;

import com.ng.trainplan.sportplan.SportPlanApplication;
import com.ng.trainplan.sportplan.activity.fragment.AbstractFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public abstract class AbstractActivity extends FragmentActivity {

	protected static String TAG;
	protected AbstractFragment fragment;
	protected SportPlanApplication app;
	
	@Override
	protected void onCreate(Bundle savedBundle) {
		super.onCreate(savedBundle);
		TAG = this.getClass().getSimpleName();
		app = (SportPlanApplication) getApplication();
	}
	
}
