package com.ng.trainplan.sportplan.business;

import org.droidpersistence.annotation.Column;
import org.droidpersistence.annotation.PrimaryKey;
import org.droidpersistence.annotation.Table;

@Table(name = "Training_Session_Common")
public class MasterListItem {

	//TODO set date as id -- can not set date as id. Multiple trainingsessions can take place at the one day
	@PrimaryKey(autoIncrement=true)
	@Column(name="id")
	private long id;
	
	@Column(name="length")
	private long lenght;
	
	@Column(name="date")
	private String date;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getLenght() {
		return lenght;
	}

	public void setLenght(long lenght) {
		this.lenght = lenght;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return date;
	}

	
}
