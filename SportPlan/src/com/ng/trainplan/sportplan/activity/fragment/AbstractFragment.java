package com.ng.trainplan.sportplan.activity.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ng.trainplan.sportplan.SportPlanApplication;
import com.ng.trainplan.sportplan.business.MasterListItem;

public abstract class AbstractFragment extends Fragment {
	/**
	 * The fragment argument representing the item ID that this fragment
	 * represents.
	 */
	public static final String ARG_ITEM_ID = "item_id";

	/**
	 * The dummy content this fragment is presenting.
	 */
	protected MasterListItem mItem;

	public SportPlanApplication app;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		app = (SportPlanApplication) getActivity().getApplication();
		if (getArguments().containsKey(ARG_ITEM_ID)) {
			mItem = app.getMasterListItemById(getArguments().getString(
					ARG_ITEM_ID));
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(getFragmentLayout(), container, false);
		if (mItem != null) {
			((TextView) rootView.findViewById(getMasterItemViewId()))
					.setText(mItem.toString());
		}

		return rootView;
	}

	protected abstract int getFragmentLayout();

	protected abstract int getMasterItemViewId();

}
