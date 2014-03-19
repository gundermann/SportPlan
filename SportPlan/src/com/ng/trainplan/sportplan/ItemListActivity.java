package com.ng.trainplan.sportplan;

import com.ng.trainplan.sportplan.bussines.Factory;
import com.ng.trainplan.sportplan.bussines.MasterListCallbacks;
import com.ng.trainplan.sportplan.bussines.TrainingSessionOrganizer;
import com.ng.trainplan.sportplan.bussines.TrainingTargetOrganizer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class ItemListActivity extends FragmentActivity implements
		MasterListCallbacks, TrainingTargetOrganizer, TrainingSessionOrganizer{

	private static final String TAG = ItemDetailActivity.class.getSimpleName();
	private boolean mTwoPane;
	private SportPlanApplication app;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_item_list);
		if (findViewById(R.id.item_detail_container) != null) {
			// only in the large-screen layouts 
			mTwoPane = true;
			((ItemListFragment) getSupportFragmentManager().findFragmentById(
					R.id.item_list)).setActivateOnItemClick(true);
		}
		app = (SportPlanApplication) getApplication();
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
	 * Callback method from {@link ItemListFragment.MasterListCallbacks} indicating that
	 * the item with the given ID was selected.
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
			if(id.equals("0")){
				fragment = new TrainingSessionDetailFragment();
			}else {
				fragment = new ItemDetailFragment();
			}
			fragment.setArguments(arguments);
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.item_detail_container, fragment).commit();

		} else {
			// In single-pane mode, simply start the detail activity
			// for the selected item ID.
			Intent detailIntent;
			if(id.equals("0")){
				detailIntent = new Intent(this, TrainingSessionDetailActivity.class);
			}else{
				detailIntent = new Intent(this, ItemDetailActivity.class);
			}
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
		app.setActualTrainingSession(Factory.getInstance().createTrainingSession());
	}
}
