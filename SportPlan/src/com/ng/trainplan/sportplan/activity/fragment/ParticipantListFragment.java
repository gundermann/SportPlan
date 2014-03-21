package com.ng.trainplan.sportplan.activity.fragment;

import com.ng.trainplan.sportplan.business.Person;

import android.widget.ArrayAdapter;
import android.widget.ListAdapter;


public class ParticipantListFragment extends AbstractListFragment {

	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the
	 * fragment (e.g. upon screen orientation changes).
	 */
	public ParticipantListFragment() {
	}

//	@Override
//	public void onResume() {
//		super.onResume();
//		updateList();
//	}

	@Override
	protected ListAdapter getSpecificListAdapter() {
		return new ArrayAdapter<Person>(getActivity(),
				android.R.layout.simple_list_item_1, app
				.getActualMemberList());
	}
}
