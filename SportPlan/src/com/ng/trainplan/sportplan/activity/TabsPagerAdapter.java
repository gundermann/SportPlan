package com.ng.trainplan.sportplan.activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ng.trainplan.sportplan.activity.fragment.DatePickerFragment;
import com.ng.trainplan.sportplan.activity.fragment.TimePickerFragment;
import com.ng.trainplan.sportplan.trainingsession.TrainingSessionConfigurator;
 
public class TabsPagerAdapter extends FragmentPagerAdapter {
 
    private TrainingSessionConfigurator configurator;

	public TabsPagerAdapter(FragmentManager fm, TrainingSessionConfigurator configurator) {
        super(fm);
		this.configurator = configurator;
    }
 
    @Override
    public Fragment getItem(int index) {
 
        switch (index) {
        case 0:
            return DatePickerFragment.newInstance(configurator);
        default:
            return TimePickerFragment.newInstance(configurator);
        }
    }
 
    @Override
    public int getCount() {
        return 2;
    }
 
}