package com.ng.trainplan.sportplan.business;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

import com.ng.trainplan.sportplan.activity.NewPersonDialog;
import com.ng.trainplan.sportplan.util.PersonBuilder;

public class SubmitCompetitorListener implements OnClickListener {

	private NewPersonDialog dialog;

	public SubmitCompetitorListener(NewPersonDialog newCompetitorDialog) {
		this.dialog = newCompetitorDialog;
	}

	@Override
	public void onClick(DialogInterface dialog, int which) {
		String compName = this.dialog.getCompetitorName();
		String firstName = "";
		String lastName = "";
		if (compName.contains(" ")) {
			firstName = compName.substring(0, compName.lastIndexOf(" "));
			lastName = compName.substring(firstName.length());
		} else {
			firstName = compName;
		}
		this.dialog.updatePersonList(new PersonBuilder()
				.setFirstname(firstName).setLastname(lastName).build());
	}

}
