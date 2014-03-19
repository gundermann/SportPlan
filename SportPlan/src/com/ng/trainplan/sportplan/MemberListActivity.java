package com.ng.trainplan.sportplan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MemberListActivity extends FragmentActivity {

	private static final String TAG = MemberListActivity.class.getSimpleName();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_member_list);
		/** Show the Up button in the action bar. */
		getActionBar().setDisplayHomeAsUpEnabled(true);
		if (savedInstanceState == null) {
			Bundle arguments = new Bundle();
			arguments.putString(ItemDetailFragment.ARG_ITEM_ID, getIntent()
					.getStringExtra(ItemDetailFragment.ARG_ITEM_ID));
			MemberListFragment fragment = new MemberListFragment();
			fragment.setArguments(arguments);
			getSupportFragmentManager().beginTransaction()
					.add(R.id.item_detail_container, fragment).commit();
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		Log.i("init menu", TAG);
		getMenuInflater().inflate(R.menu.member_list_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			Intent intent = new Intent(this,
					TrainingSessionDetailActivity.class);
			intent.putExtra(ItemDetailFragment.ARG_ITEM_ID, getIntent()
					.getStringExtra(ItemDetailFragment.ARG_ITEM_ID));
			NavUtils.navigateUpTo(this, intent);
			return true;
		case R.id.add_member:
			Intent memberOverviewIntent = new Intent(this,
					MemberOverviewActivity.class);
			memberOverviewIntent.putExtra(ItemDetailFragment.ARG_ITEM_ID,
					getIntent().getStringExtra(ItemDetailFragment.ARG_ITEM_ID));
			startActivity(memberOverviewIntent);
			return true;
		case R.id.save:
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
