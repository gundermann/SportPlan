package com.ng.trainplan.sportplan.activity;

import com.ng.trainplan.sportplan.activity.fragment.AbstractFragment;
import com.ng.trainplan.sportplan.activity.fragment.ItemDetailFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * An activity representing a single Item detail screen. This activity is only
 * used on handset devices. On tablet-size devices, item details are presented
 * side-by-side with a list of items in a {@link ItemListActivity}.
 * <p>
 * This activity is mostly just a 'shell' activity containing nothing more than
 * a {@link ItemDetailFragment}.
 */
public abstract class AbstractDetailActivity extends AbstractActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(getContentView());
		/** Show the Up button in the action bar. */
		getActionBar().setDisplayHomeAsUpEnabled(true);
		// savedInstanceState is non-null when there is fragment state
		// saved from previous configurations of this activity
		// (e.g. when rotating the screen from portrait to landscape).
		// In this case, the fragment will automatically be re-added
		// to its container so we don't need to manually add it.
		// For more information, see the Fragments API guide at:
		//
		// http://developer.android.com/guide/components/fragments.html
		//
		if (savedInstanceState == null) {
			// Create the detail fragment and add it to the activity
			// using a fragment transaction.
			Bundle arguments = new Bundle();
			arguments.putString(AbstractFragment.ARG_ITEM_ID, getIntent()
					.getStringExtra(AbstractFragment.ARG_ITEM_ID));
			fragment = getSpecificFragment();
			fragment.setArguments(arguments);
			getSupportFragmentManager().beginTransaction()
					.add(getDetailContainer(), fragment).commit();
		}
	}

	protected abstract int getDetailContainer();

	protected abstract Fragment getSpecificFragment();

	protected abstract int getContentView();
}
