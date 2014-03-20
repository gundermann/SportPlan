package com.ng.trainplan.sportplan.activity;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.ng.trainplan.sportplan.R;
import com.ng.trainplan.sportplan.activity.fragment.AbstractFragment;
import com.ng.trainplan.sportplan.activity.fragment.ItemDetailFragment;

public class TrainingSessionDetailActivity extends AbstractDetailActivity {

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		Log.i("init menu", TAG);
		getMenuInflater().inflate(R.menu.training_session_detail_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			NavUtils.navigateUpTo(this,
					new Intent(this, ItemListActivity.class));
			return true;
		case R.id.close_training_session:
			return true;
		case R.id.open_list_of_members:
			Intent detailIntent;
			detailIntent = new Intent(this, ParticipantListActivity.class);
			detailIntent.putExtra(ItemDetailFragment.ARG_ITEM_ID, getIntent()
					.getStringExtra(ItemDetailFragment.ARG_ITEM_ID));
			startActivity(detailIntent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected int getDetailContainer() {
		return R.id.item_detail_container;
	}

	@Override
	protected AbstractFragment getSpecificFragment() {
		return new ItemDetailFragment();
	}

	@Override
	protected int getContentView() {
		return  R.layout.activity_item_detail;
	}
}
