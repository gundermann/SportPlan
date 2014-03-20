package com.ng.trainplan.sportplan.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.EditText;

import com.ng.trainplan.sportplan.R;
import com.ng.trainplan.sportplan.business.CancelDialogListener;
import com.ng.trainplan.sportplan.business.Person;
import com.ng.trainplan.sportplan.business.PersonSetupListener;
import com.ng.trainplan.sportplan.business.SubmitCompetitorListener;

public class NewPersonDialog extends DialogFragment {

	private PersonSetupListener personSetupListener;
	private EditText personNameField;

	public static final NewPersonDialog newInstance(
			PersonSetupListener matchChangeListener) {
		NewPersonDialog dialog = new NewPersonDialog();

		dialog.setMatchChangeListener(matchChangeListener);
		dialog.setCancelable(false);
		return dialog;
	}

	private void setMatchChangeListener(PersonSetupListener matchChangeListener) {
		this.personSetupListener = matchChangeListener;
	}

	public PersonSetupListener getPersonListChangeListener() {
		return personSetupListener;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		View view = getCurrentView();
		instantiaveViews(view);
		return buildDialog(view);
	}
	
	

	private Dialog buildDialog(View view) {
		AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(
				getActivity());
		dialogBuilder
				.setView(view)
				.setPositiveButton(android.R.string.ok,
						new SubmitCompetitorListener(this))
				.setNegativeButton(android.R.string.cancel,
						new CancelDialogListener(personSetupListener)).setCancelable(false);
		return dialogBuilder.create();
	}

	
	
	private View getCurrentView() {
		View view = getActivity().getLayoutInflater().inflate(
				R.layout.new_competitor_dialog, null);
		return view;
	}

	private void instantiaveViews(View view) {
		personNameField = (EditText) view.findViewById(R.id.personName);
	}

	public void updatePersonList(Person person) {
		getPersonListChangeListener().updatePerson(person);
	}

	public String getCompetitorName() {
		return personNameField.getText().toString();
	}

}
