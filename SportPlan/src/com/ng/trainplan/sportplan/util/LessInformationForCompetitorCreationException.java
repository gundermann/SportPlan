package com.ng.trainplan.sportplan.util;

public class LessInformationForCompetitorCreationException extends Exception{

	private static final long serialVersionUID = 8295305719210001801L;
	private static final String MESSAGE = "Competitor has no firstname";
	
	@Override
	public String getMessage() {
		return MESSAGE;
	}

	
}
