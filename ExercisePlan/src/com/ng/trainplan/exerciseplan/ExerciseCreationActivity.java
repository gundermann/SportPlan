package com.ng.trainplan.exerciseplan;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.Spinner;

import com.ng.trainplan.exerciseplan.business.Category;
import com.ng.trainplan.exerciseplan.business.ExerciseComponent;
import com.ng.trainplan.exerciseplan.mock.ExerciseComponentMock;
import com.ng.trainplan.exerciseplan.util.DragListener;

public class ExerciseCreationActivity extends Activity implements
		CategoryChanger {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exercise_creation);
		findViewById(R.id.top).setOnDragListener(new DragListener(this));
		findViewById(R.id.middle).setOnDragListener(new DragListener(this));
		findViewById(R.id.bottom).setOnDragListener(new DragListener(this));
		findViewById(R.id.categorySelection).setOnDragListener(
				new DragListener(this));
		((Spinner) findViewById(R.id.categorySpinner))
				.setAdapter(new CategoryAdapter(this));
		((Spinner) findViewById(R.id.categorySpinner))
				.setOnItemSelectedListener(new OnCategoryChanged(this));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.exercise_creation, menu);
		return true;
	}

	@Override
	public void changeCategory(Category category) {
		List<ExerciseComponent> currentList = getComponentFromCategory(category);
		((ListView) findViewById(R.id.categorySelection))
				.setAdapter(new DragListAdapter(this, currentList));
	}

	private List<ExerciseComponent> getComponentFromCategory(Category category) {
		return ExerciseComponentMock.createList();
	}

}
