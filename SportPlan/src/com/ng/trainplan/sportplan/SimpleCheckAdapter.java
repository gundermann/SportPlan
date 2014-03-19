package com.ng.trainplan.sportplan;

import java.util.List;

import android.content.Context;
import android.widget.ArrayAdapter;

public class SimpleCheckAdapter extends ArrayAdapter<String> {

	public SimpleCheckAdapter(Context context, List<String> objects) {
		super(context, R.layout.member_list, R.id.member_name, objects);
		// TODO Auto-generated constructor stub
	}

}
