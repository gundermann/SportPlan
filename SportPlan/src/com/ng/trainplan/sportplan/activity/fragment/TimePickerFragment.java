package com.ng.trainplan.sportplan.activity.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TimePicker;

import com.ng.trainplan.sportplan.R;

public class TimePickerFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_time_picker, container, false);
        TimePicker picker = (TimePicker) rootView.findViewById(R.id.time_picker);
        picker.setIs24HourView(true);
        return rootView;
	}
}
