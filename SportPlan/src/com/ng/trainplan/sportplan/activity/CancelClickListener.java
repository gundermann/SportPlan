package com.ng.trainplan.sportplan.activity;

import android.view.View;
import android.view.View.OnClickListener;

public class CancelClickListener implements OnClickListener {

	private PopupElement popup;

	public CancelClickListener(PopupElement popup) {
		this.popup = popup;
	}

	@Override
	public void onClick(View view) {
		popup.close();
	}

}
