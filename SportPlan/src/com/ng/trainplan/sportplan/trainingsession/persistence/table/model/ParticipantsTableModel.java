package com.ng.trainplan.sportplan.trainingsession.persistence.table.model;

import org.droidpersistence.annotation.Column;
import org.droidpersistence.annotation.PrimaryKey;
import org.droidpersistence.annotation.Table;

@Table(name="Participants")
public class ParticipantsTableModel {

	@PrimaryKey
	@Column(name="id")
	private long id;
	
	@Column(name="training_session_id")
	private long trainingSessionId;
	
	@Column(name="person_id")
	private long personId;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTrainingSessionId() {
		return trainingSessionId;
	}

	public void setTrainingSessionId(long trainingSessionId) {
		this.trainingSessionId = trainingSessionId;
	}

	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}
}
