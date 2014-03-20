package com.ng.trainplan.sportplan.activity.fragment;

import java.util.List;

import android.widget.ListAdapter;

import com.ng.trainplan.sportplan.MemberCheckAdapter;

public class MemberOverviewFragment extends AbstractListFragment {

	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the
	 * fragment (e.g. upon screen orientation changes).
	 */
	public MemberOverviewFragment() {
	}

	public List<String> getCheckedMembers() {
		return ((MemberCheckAdapter) getListAdapter()).getCheckedMember();
	}

	@Override
	protected ListAdapter getSpecificListAdapter() {
		return new MemberCheckAdapter(getActivity(), app.getDefaultMember());
	}
}
