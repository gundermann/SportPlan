package com.ng.trainplan.sportplan;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ng.trainplan.sportplan.bussines.MasterListItem;

/**
 * A fragment representing a single Item detail screen. This fragment is either
 * contained in a {@link ItemListActivity} in two-pane mode (on tablets) or a
 * {@link ItemDetailActivity} on handsets.
 */
public class MemberOverviewFragment extends Fragment {
	/**
	 * The fragment argument representing the item ID that this fragment
	 * represents.
	 */
	public static final String ARG_ITEM_ID = "item_id";

	private SportPlanApplication app;
	/**
	 * The dummy content this fragment is presenting.
	 */
	private MasterListItem mItem;
	private ListView memberListView;

	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the
	 * fragment (e.g. upon screen orientation changes).
	 */
	public MemberOverviewFragment() {
	}

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
		View rootView = inflater.inflate(R.layout.fragment_member_list,
				container, false);
		memberListView = (ListView) rootView.findViewById(R.id.member_list);
		memberListView.setAdapter(new MemberCheckAdapter(getActivity(), app
				.getDefaultMember()));
		return rootView;
	}
}
