package com.ng.trainplan.sportplan.business;

import org.droidpersistence.annotation.Column;
import org.droidpersistence.annotation.PrimaryKey;
import org.droidpersistence.annotation.Table;

import com.ng.trainplan.sportplan.util.DateHelper;

@Table(name = "Training_Session_Common")
public class MasterListItem {

	@PrimaryKey(autoIncrement=true)
	@Column(name="id")
	private long id;
	
	@Column(name="start")
	private long start;
	
	@Column(name="end")
	private long end;
	
	@Column(name="date")
	private String date;
	
	
	public long getStart() {
		return start;
	}

	public void setStart(long start) {
		this.start = start;
	}

	public long getEnd() {
		return end;
	}

	public void setEnd(long end) {
		this.end = end;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getLenght() {
		return start;
	}

	public void setLenght(long lenght) {
		this.start = lenght;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public long getLength(){
		return end-start;
	}
	
	@Override
	public String toString() {
		return date + " - " + DateHelper.getTimeAsString(start);
	}

	
}
