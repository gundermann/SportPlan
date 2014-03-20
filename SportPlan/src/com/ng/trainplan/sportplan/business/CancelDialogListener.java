package com.ng.trainplan.sportplan.business;


import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public class CancelDialogListener implements OnClickListener {
	
	private PersonSetupListener setup;

	public CancelDialogListener(PersonSetupListener setup) {
		this.setup = setup;
	}

	@Override
	public void onClick(DialogInterface dialog, int which) {
		dialog.dismiss();
		setup.doFinishPersonSetup();
	}

}
