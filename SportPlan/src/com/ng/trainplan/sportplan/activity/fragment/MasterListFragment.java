package com.ng.trainplan.sportplan.activity.fragment;

import android.app.Activity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.ng.trainplan.sportplan.SportPlanApplication;
import com.ng.trainplan.sportplan.business.MasterListCallbacks;
import com.ng.trainplan.sportplan.business.MasterListItem;

/**
 * A list fragment representing a list of Items. This fragment also supports
 * tablet devices by allowing list items to be given an 'activated' state upon
 * selection. This helps indicate which item is currently being viewed in a
 * {@link ItemDetailFragment}.
 * <p>
 * Activities containing this fragment MUST implement the
 * {@link MasterListCallbacks} interface.
 */
public class MasterListFragment extends AbstractListFragment {

	/**
	 * The fragment's current callback object, which is notified of list item
	 * clicks.
	 */
	private MasterListCallbacks masterListCallbacks;

	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the
	 * fragment (e.g. upon screen orientation changes).
	 */
	public MasterListFragment() {
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

		// Activities containing this fragment must implement its callbacks.
		if (!(activity instanceof MasterListCallbacks)) {
			throw new IllegalStateException(
					"Activity must implement fragment's callbacks.");
		}
		masterListCallbacks = (MasterListCallbacks) activity;
	}

	@Override
	public void onListItemClick(ListView listView, View view, int position,
			long id) {
		super.onListItemClick(listView, view, position, id);
		masterListCallbacks.onItemSelected(String.valueOf(app.getMasterList()
				.get(position).getId()));
	}

	/**
	 * Turns on activate-on-click mode. When this mode is on, list items will be
	 * given the 'activated' state when touched.
	 */
	public void setActivateOnItemClick(boolean activateOnItemClick) {
		// When setting CHOICE_MODE_SINGLE, ListView will automatically
		// give items the 'activated' state when touched.
		getListView().setChoiceMode(
				activateOnItemClick ? ListView.CHOICE_MODE_SINGLE
						: ListView.CHOICE_MODE_NONE);
	}

	@Override
	protected ListAdapter getSpecificListAdapter() {
		return new ArrayAdapter<MasterListItem>(getActivity(),
				android.R.layout.simple_list_item_activated_1,
				android.R.id.text1, ((SportPlanApplication) getActivity()
						.getApplication()).getMasterList());
	}
}
