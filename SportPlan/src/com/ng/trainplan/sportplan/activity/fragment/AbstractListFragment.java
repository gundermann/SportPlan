package com.ng.trainplan.sportplan.activity.fragment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.ng.trainplan.sportplan.SportPlanApplication;
import com.ng.trainplan.sportplan.activity.ItemDetailActivity;
import com.ng.trainplan.sportplan.activity.MasterListActivity;
import com.ng.trainplan.sportplan.business.MasterListItem;

/**
 * A fragment representing a single Item detail screen. This fragment is either
 * contained in a {@link MasterListActivity} in two-pane mode (on tablets) or a
 * {@link ItemDetailActivity} on handsets.
 */
public abstract class AbstractListFragment extends ListFragment {

	/**
	 * The fragment argument representing the item ID that this fragment
	 * represents.
	 */
	public static final String ARG_ITEM_ID = "item_id";

	/**
	 * Is null if this is master list
	 */
	protected MasterListItem mItem;

	/**
	 * The serialization (saved instance state) Bundle key representing the
	 * activated item position. Only used on tablets.
	 */
	protected static final String STATE_ACTIVATED_POSITION = "activated_position";

	/**
	 * The current activated item position. Only used on tablets.
	 */
	protected int mActivatedPosition = ListView.INVALID_POSITION;

	public SportPlanApplication app;

	@Override
	public void onResume() {
		super.onResume();
		app = (SportPlanApplication) getActivity().getApplication();
		updateList();
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
	}
	
	public void updateList() {
		setListAdapter(getSpecificListAdapter());
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		// Restore the previously serialized activated item position.
		if (savedInstanceState != null
				&& savedInstanceState.containsKey(STATE_ACTIVATED_POSITION)) {
			setActivatedPosition(savedInstanceState
					.getInt(STATE_ACTIVATED_POSITION));
		}
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		if (mActivatedPosition != ListView.INVALID_POSITION) {
			outState.putInt(STATE_ACTIVATED_POSITION, mActivatedPosition);
		}
	}
	
	private void setActivatedPosition(int position) {
		if (position == ListView.INVALID_POSITION) {
			getListView().setItemChecked(mActivatedPosition, false);
		} else {
			getListView().setItemChecked(position, true);
		}

		mActivatedPosition = position;
	}

	protected abstract ListAdapter getSpecificListAdapter();
}
