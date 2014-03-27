package com.ng.trainplan.sportplan.person.business;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

import com.ng.trainplan.sportplan.person.PersonBuilder;
import com.ng.trainplan.sportplan.person.ui.NewPersonDialog;

public class SubmitPersonListener implements OnClickListener {

	private NewPersonDialog dialog;

	public SubmitPersonListener(NewPersonDialog newPersonDialog) {
		this.dialog = newPersonDialog;
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
