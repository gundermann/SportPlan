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
import com.ng.trainplan.sportplan.business.Person;

public class MemberCheckAdapter extends ArrayAdapter<Person> implements OnClickListener {

	private Context context;
	private List<Person> defaultMember;
	private List<Person> checkedMember = new ArrayList<Person>();

	public MemberCheckAdapter(Context context, List<Person> defaultMember) {
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
		nameTextView.setText(defaultMember.get(position).toString());
	}

	public List<Person> getCheckedMember() {
		return checkedMember;
	}

	@Override
	public void onClick(View checkBox) {
		LinearLayout parent = (LinearLayout) checkBox.getParent();
		TextView nameTV = (TextView) parent.findViewById(R.id.member_name);
		Person changedPerson = getDefaultMemberByName(nameTV.getText());
		if(((CheckBox) checkBox).isChecked()){
			checkedMember.add(changedPerson);
		}
		else {
			checkedMember.remove(changedPerson);
		}
	}

	private Person getDefaultMemberByName(CharSequence name) {
		for(Person person : defaultMember){
			if(person.toString().equals(name))
				return person;
		}
		return null;
	}

}
