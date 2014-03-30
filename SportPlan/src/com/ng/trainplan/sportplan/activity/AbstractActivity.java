package com.ng.trainplan.sportplan.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.ng.trainplan.sportplan.SportPlanApplication;

public abstract class AbstractActivity extends FragmentActivity {

	protected static String TAG;
	protected Fragment fragment;
	protected SportPlanApplication app;
	
	@Override
	protected void onCreate(Bundle savedBundle) {
		super.onCreate(savedBundle);
		TAG = this.getClass().getSimpleName();
		app = (SportPlanApplication) getApplication();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		fragment = getSpecificFragment();
	}
	
	protected abstract Fragment getSpecificFragment();
	
}
