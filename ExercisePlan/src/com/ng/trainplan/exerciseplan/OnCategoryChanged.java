package com.ng.trainplan.exerciseplan;


import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

import com.ng.trainplan.exerciseplan.business.Category;

public class OnCategoryChanged implements OnItemSelectedListener {

	private CategoryChanger catChanger;

	public OnCategoryChanged(CategoryChanger catChanger) {
		this.catChanger = catChanger;
	}

	@Override
	public void onItemSelected(AdapterView<?> adapterView, View arg1, int position,
			long arg3) {
		Category cat = (Category) adapterView.getAdapter().getItem(position);
		catChanger.changeCategory(cat);
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		//Do nothing
	}
}
