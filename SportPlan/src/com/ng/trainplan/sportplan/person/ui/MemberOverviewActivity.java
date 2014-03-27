package com.ng.trainplan.sportplan.person.ui;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.ng.trainplan.sportplan.R;
import com.ng.trainplan.sportplan.activity.AbstractDetailActivity;
import com.ng.trainplan.sportplan.activity.ParticipantListActivity;
import com.ng.trainplan.sportplan.activity.fragment.ItemDetailFragment;
import com.ng.trainplan.sportplan.person.Person;
import com.ng.trainplan.sportplan.person.business.PersonSetupListener;

public class MemberOverviewActivity extends AbstractDetailActivity implements PersonSetupListener {

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
			app.setupParticipiants(((MemberOverviewFragment) fragment).getCheckedMembers());
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
		app.addPerson(person);
		((MemberOverviewFragment) fragment).updateList();
	}

	@Override
	protected int getContentView() {
		return R.layout.activity_member_list;
	}

	@Override
	protected int getDetailContainer() {
		return R.id.item_detail_container;
	}

	@Override
	protected Fragment getSpecificFragment() {
		return new MemberOverviewFragment();
	}
}
