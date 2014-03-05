package com.ng.trainplan.exerciseplan;

import android.widget.ArrayAdapter;

import com.ng.trainplan.exerciseplan.business.Category;

public class CategoryAdapter extends ArrayAdapter<Category> {

	public CategoryAdapter(ExerciseCreationActivity exerciseCreationActivity) {
		super(exerciseCreationActivity,
				android.R.layout.simple_spinner_dropdown_item, Category
						.values());
	}
}
