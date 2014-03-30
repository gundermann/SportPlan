package com.ng.trainplan.sportplan.activity;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.Dialog;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.sax.StartElementListener;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

import com.ng.trainplan.sportplan.R;
import com.ng.trainplan.sportplan.trainingsession.TrainingSessionConfigurator;

public class DateTimePickerPopup extends FragmentActivity implements TabListener {
	private ViewPager viewPager;
	private TabsPagerAdapter mAdapter;
	private ActionBar actionBar;
	private String[] tabs = { "Datum", "Uhrzeit" };
	private static TrainingSessionConfigurator configurator;

	public static void show(Context context, TrainingSessionConfigurator configurator){
		DateTimePickerPopup.configurator = configurator;
		Intent intent = new Intent(context, DateTimePickerPopup.class);
		context.startActivity(intent);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		showAsPopup(this);
	}
	
	private void initViews() {
		// Initilization
		viewPager = (ViewPager) findViewById(R.id.pager);
		actionBar = getActionBar();
		mAdapter = new TabsPagerAdapter(getSupportFragmentManager());
		actionBar.setLogo(null);
		actionBar.setIcon(null);
		viewPager.setAdapter(mAdapter);
		viewPager.setOnPageChangeListener(new PageChangeListener(actionBar));
		actionBar.setHomeButtonEnabled(false);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		// Adding Tabs
		for (String tab_name : tabs) {
			actionBar.addTab(actionBar.newTab().setText(tab_name)
					.setTabListener(this));
		}

	}

	public void showAsPopup(Activity activity) {
	    activity.requestWindowFeature(Window.FEATURE_ACTION_BAR);
	    activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND,
	            WindowManager.LayoutParams.FLAG_DIM_BEHIND);
	    LayoutParams params = activity.getWindow().getAttributes(); 
	    params.height = 450;
	    params.width = 350;
	    activity.getWindow().setAttributes((android.view.WindowManager.LayoutParams) params); 
	    setContentView(R.layout.popup_activity);
	    initViews();
	}
	
	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction arg1) {
		viewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub

	}

}
