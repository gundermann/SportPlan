package com.ng.trainplan.exerciseplan;

import java.util.List;

import com.ng.trainplan.exerciseplan.business.ExerciseComponent;

import android.widget.ArrayAdapter;

public class DragListAdapter extends ArrayAdapter<ExerciseComponent> {

	public DragListAdapter(ExerciseCreationActivity exerciseCreationActivity,
			List<ExerciseComponent> currentList) {
		super(exerciseCreationActivity, android.R.layout.simple_list_item_1, currentList);
	}

}
