package com.ng.trainplan.sportplan;

import java.util.List;

import android.content.Context;
import android.widget.ArrayAdapter;

public class MemberCheckAdapter extends ArrayAdapter<String> {

	public MemberCheckAdapter(Context activity,
			List<String> defaultMember) {
		super(activity, R.layout.member_list, R.id.member_name, defaultMember);
	}

}
