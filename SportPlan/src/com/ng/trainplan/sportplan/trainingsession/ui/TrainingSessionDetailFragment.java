package com.ng.trainplan.sportplan.trainingsession.ui;

import com.ng.trainplan.sportplan.R;
import com.ng.trainplan.sportplan.activity.ItemDetailActivity;
import com.ng.trainplan.sportplan.activity.MasterListActivity;
import com.ng.trainplan.sportplan.activity.fragment.AbstractFragment;

/**
 * A fragment representing a single Item detail screen. This fragment is either
 * contained in a {@link MasterListActivity} in two-pane mode (on tablets) or a
 * {@link ItemDetailActivity} on handsets.
 */
public class TrainingSessionDetailFragment extends AbstractFragment {

	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the
	 * fragment (e.g. upon screen orientation changes).
	 */
	public TrainingSessionDetailFragment() {
	}

	@Override
	protected int getFragmentLayout() {
		return R.layout.fragment_item_detail;
	}

	@Override
	protected int getMasterItemViewId() {
		return R.id.item_detail;
	}
}
