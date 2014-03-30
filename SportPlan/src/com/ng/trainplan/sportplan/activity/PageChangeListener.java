package com.ng.trainplan.sportplan.activity;

import android.app.ActionBar;
import android.support.v4.view.ViewPager.OnPageChangeListener;

public class PageChangeListener implements OnPageChangeListener {

	private ActionBar actionBar;

	public PageChangeListener(ActionBar actionBar) {
		this.actionBar = actionBar;
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageSelected(int position) {
		 // on changing the page
        // make respected tab selected
        actionBar.setSelectedNavigationItem(position);

	}

}
