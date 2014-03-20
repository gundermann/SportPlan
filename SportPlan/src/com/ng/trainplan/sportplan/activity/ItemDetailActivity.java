package com.ng.trainplan.sportplan.activity;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;

import com.ng.trainplan.sportplan.R;
import com.ng.trainplan.sportplan.activity.fragment.AbstractFragment;
import com.ng.trainplan.sportplan.activity.fragment.ItemDetailFragment;


public class ItemDetailActivity extends AbstractDetailActivity {

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpTo(this,
					new Intent(this, ItemListActivity.class));
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected int getContentView() {
		return R.layout.activity_item_detail;
	}

	@Override
	protected int getDetailContainer() {
		return R.id.item_detail_container;
	}

	@Override
	protected AbstractFragment getSpecificFragment() {
		return new ItemDetailFragment();
	}
}
