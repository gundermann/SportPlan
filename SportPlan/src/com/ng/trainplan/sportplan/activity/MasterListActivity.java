package com.ng.trainplan.sportplan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.ng.trainplan.sportplan.R;
import com.ng.trainplan.sportplan.activity.fragment.AbstractListFragment;
import com.ng.trainplan.sportplan.activity.fragment.ItemDetailFragment;
import com.ng.trainplan.sportplan.activity.fragment.MasterListFragment;
import com.ng.trainplan.sportplan.business.MasterListCallbacks;
import com.ng.trainplan.sportplan.trainingsession.TrainingSessionConfigurator;
import com.ng.trainplan.sportplan.trainingsession.business.TrainingSession;
import com.ng.trainplan.sportplan.trainingsession.business.TrainingSessionOrganizer;
import com.ng.trainplan.sportplan.trainingsession.business.TrainingTargetOrganizer;
import com.ng.trainplan.sportplan.trainingsession.ui.ParticipantListFragment;

public class MasterListActivity extends AbstractActivity implements
		MasterListCallbacks, TrainingTargetOrganizer, TrainingSessionOrganizer {

	private boolean mTwoPane;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_item_list);
		if (findViewById(R.id.item_detail_container) != null) {
			// only in the large-screen layouts
			mTwoPane = true;
			((MasterListFragment) getSpecificFragment())
					.setActivateOnItemClick(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		Log.i("init menu", TAG);
		getMenuInflater().inflate(R.menu.mastermenu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.add_trainig_target:
			addNewTrainingTarget();
			break;
		case R.id.add_new_workout:
			addNewTrainingSession();
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * Callback method from {@link MasterListFragment.MasterListCallbacks}
	 * indicating that the item with the given ID was selected.
	 */
	@Override
	public void onItemSelected(String id) {
		if (mTwoPane) {

			// In two-pane mode, show the detail view in this activity by
			// adding or replacing the detail fragment using a
			// fragment transaction.
			Fragment fragment;
			Bundle arguments = new Bundle();
			arguments.putString(ItemDetailFragment.ARG_ITEM_ID, id);
//			if (id.equals("0")) {
				fragment = new ParticipantListFragment();
//			} else {
//				fragment = new ItemDetailFragment();
//			}
			fragment.setArguments(arguments);
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.item_detail_container, fragment).commit();

		} else {
			// In single-pane mode, simply start the detail activity
			// for the selected item ID.
			Intent detailIntent;
//			if (id.equals("0")) {
				detailIntent = new Intent(this,
						ParticipantListActivity.class);
//			} else {
//				detailIntent = new Intent(this, ItemDetailActivity.class);
//			}
			detailIntent.putExtra(ItemDetailFragment.ARG_ITEM_ID, id);
			startActivity(detailIntent);
		}
	}

	@Override
	public void addNewTrainingTarget() {
		// TODO Auto-generated method stub
	}

	@Override
	public void addNewTrainingSession() {
		DateTimePickerPopup.show(this, new TrainingSessionConfigurator(this));
	}

	@Override
	public void saveTrainingSession(TrainingSession trainingSession) {
		app.saveTrainingSession(trainingSession);
		((AbstractListFragment) fragment).updateList();
	}

	@Override
	protected Fragment getSpecificFragment() {
		return getSupportFragmentManager().findFragmentById(R.id.item_list);
	}
}
