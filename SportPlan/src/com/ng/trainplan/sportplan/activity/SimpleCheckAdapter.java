package com.ng.trainplan.sportplan.activity;

import java.util.List;

import com.ng.trainplan.sportplan.R;
import com.ng.trainplan.sportplan.R.id;
import com.ng.trainplan.sportplan.R.layout;

import android.content.Context;
import android.widget.ArrayAdapter;

public class SimpleCheckAdapter extends ArrayAdapter<String> {

	public SimpleCheckAdapter(Context context, List<String> objects) {
		super(context, R.layout.member_list, R.id.member_name, objects);
		// TODO Auto-generated constructor stub
	}

}
