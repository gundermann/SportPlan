package com.ng.trainplan.sportplan.activity.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import com.ng.trainplan.sportplan.R;
import com.ng.trainplan.sportplan.trainingsession.TrainingSessionConfigurator;

public class DatePickerFragment extends Fragment {

	private TrainingSessionConfigurator configurator;

	public static DatePickerFragment newInstance(TrainingSessionConfigurator configurator) {
		DatePickerFragment fragment = new DatePickerFragment();
		fragment.configurator = configurator;
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_date_picker, container, false);
        DatePicker picker = (DatePicker) rootView.findViewById(R.id.date_picker);
        picker.init(picker.getYear(), picker.getMonth(), picker.getDayOfMonth(), configurator);
        return rootView;
	}

}
