package com.ng.trainplan.sportplan.activity.fragment;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ng.trainplan.sportplan.R;

public class MemberCheckAdapter extends ArrayAdapter<String> implements OnClickListener {

	private Context context;
	private List<String> defaultMember;
	private List<String> checkedMember = new ArrayList<String>();

	public MemberCheckAdapter(Context context, List<String> defaultMember) {
		super(context, R.layout.member_list, R.id.member_name, defaultMember);
		this.context = context;
		this.defaultMember = defaultMember;
	}
	
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.member_list, parent,
				false);
		CheckBox checkBox = (CheckBox) rowView.findViewById(R.id.member_check);
		checkBox.setOnClickListener(this);
		updateView(position, rowView);

		return rowView;
	}

	private void updateView(int position, View rowView) {
		TextView nameTextView = (TextView) rowView.findViewById(R.id.member_name);
		nameTextView.setText(defaultMember.get(position));
	}

	public List<String> getCheckedMember() {
		return checkedMember;
	}

	@Override
	public void onClick(View checkBox) {
		LinearLayout parent = (LinearLayout) checkBox.getParent();
		TextView nameTV = (TextView) parent.findViewById(R.id.member_name);
		if(((CheckBox) checkBox).isChecked()){
			checkedMember.add(nameTV.getText().toString());
		}
		else {
			checkedMember.remove(nameTV.getText().toString());
		}
	}

}
