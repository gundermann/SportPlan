package com.ng.trainplan.sportplan.activity;

import com.ng.trainplan.sportplan.R;
import com.ng.trainplan.sportplan.R.id;
import com.ng.trainplan.sportplan.R.layout;
import com.ng.trainplan.sportplan.R.menu;
import com.ng.trainplan.sportplan.activity.fragment.AbstractFragment;
import com.ng.trainplan.sportplan.activity.fragment.ItemDetailFragment;
import com.ng.trainplan.sportplan.activity.fragment.ParticipantListFragment;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class ParticipantListActivity extends AbstractDetailActivity {

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

	@Override
	protected int getContentView() {
		return R.layout.activity_member_list;
	}

	@Override
	protected int getDetailContainer() {
		return R.id.item_detail_container;
	}

	@Override
	protected AbstractFragment getSpecificFragment() {
		return new ParticipantListFragment();
	}
}
