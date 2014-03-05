package com.ng.trainplan.exerciseplan.util;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ng.trainplan.exerciseplan.R;

public class DragListener implements OnDragListener {
	
	Drawable enterShape;
	Drawable normalShape;

	public DragListener(Activity activity) {
		enterShape = activity.getResources().getDrawable(
				R.drawable.shape_droptarget);
		normalShape = activity.getResources().getDrawable(R.drawable.shape);
	}

	@Override
	public boolean onDrag(View v, DragEvent event) {
		switch (event.getAction()) {
		case DragEvent.ACTION_DRAG_STARTED:
			// do nothing
			break;
		case DragEvent.ACTION_DRAG_ENTERED:
			v.setBackgroundDrawable(enterShape);
			break;
		case DragEvent.ACTION_DRAG_EXITED:
			v.setBackgroundDrawable(normalShape);
			break;
		case DragEvent.ACTION_DROP:
			// Dropped, reassign View to ViewGroup
			View view = (View) event.getLocalState();
			ViewGroup owner = (ViewGroup) view.getParent();
			owner.removeView(view);
			LinearLayout container = (LinearLayout) v;
			container.addView(view);
			view.setVisibility(View.VISIBLE);
			break;
		case DragEvent.ACTION_DRAG_ENDED:
			v.setBackgroundDrawable(normalShape);
		default:
			break;
		}
		return true;
	}
}
