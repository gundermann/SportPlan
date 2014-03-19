package com.ng.trainplan.sportplan;

import com.ng.trainplan.sportplan.business.Person;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MemberOverviewActivity extends FragmentActivity implements PersonSetupListener {

	private static final String TAG = MemberOverviewActivity.class.getSimpleName();
	private MemberOverviewFragment fragment;
	private SportPlanApplication app;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_member_list);
		app = (SportPlanApplication) getApplication();
		/** Show the Up button in the action bar.*/
		getActionBar().setDisplayHomeAsUpEnabled(true);
		if (savedInstanceState == null) {
			Bundle arguments = new Bundle();
			arguments.putString(ItemDetailFragment.ARG_ITEM_ID, getIntent()
					.getStringExtra(ItemDetailFragment.ARG_ITEM_ID));
			fragment = new MemberOverviewFragment();
			fragment.setArguments(arguments);
			getSupportFragmentManager().beginTransaction()
					.add(R.id.item_detail_container, fragment).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		Log.i("init menu", TAG);
		getMenuInflater().inflate(R.menu.member_overview_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			app.setupParticipiants(fragment.getCheckedMembers());
			Intent intent = new Intent(this, ParticipantListActivity.class);
			intent.putExtra(ItemDetailFragment.ARG_ITEM_ID, getIntent()
					.getStringExtra(ItemDetailFragment.ARG_ITEM_ID));
			NavUtils.navigateUpTo(this,
					intent );
			return true;
		case R.id.add_member:
			NewPersonDialog.newInstance(this).show(getSupportFragmentManager(), TAG);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void doFinishPersonSetup() {
		//do nothing
	}

	@Override
	public void updatePerson(Person person) {
		app.addToDefaultMemberList(person.toString());
	}
}
