package com.ng.trainplan.sportplan.business;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

import com.ng.trainplan.sportplan.person.business.PersonSetupListener;

public class CancelDialogListener implements OnClickListener {

	private PersonSetupListener personSetupListener;

	public CancelDialogListener(PersonSetupListener personSetupListener) {
		this.personSetupListener = personSetupListener;
	}

	@Override
	public void onClick(DialogInterface dialog, int arg1) {
		personSetupListener.doFinishPersonSetup();
	}

}
