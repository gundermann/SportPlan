package com.ng.trainplan.sportplan;

import java.util.ArrayList;
import java.util.List;

import com.ng.trainplan.sportplan.business.Factory;
import com.ng.trainplan.sportplan.business.MasterListItem;
import com.ng.trainplan.sportplan.business.Person;
import com.ng.trainplan.sportplan.business.TrainingSession;
import com.ng.trainplan.sportplan.persistence.DBHelper;
import com.ng.trainplan.sportplan.persistence.DataManager;
import com.ng.trainplan.sportplan.persistence.DataManagerImpl;

import android.app.Application;

public class SportPlanApplication extends Application {

	private static TrainingSession actualSession;
	private List<String> member = new ArrayList<String>();
	private DataManager dbHelper;

	public TrainingSession getActualTrainingSession() {
		if (actualSession == null) {
			actualSession = Factory.getInstance().createTrainingSession();
		}
		return actualSession;
	}

	public void setActualTrainingSession(TrainingSession createTrainingSession) {
		actualSession = Factory.getInstance().createTrainingSession();
	}

	public List<MasterListItem> getMasterList() {
		List<MasterListItem> masterList = new ArrayList<MasterListItem>();
		masterList.add(0, getActualTrainingSession());
		return masterList;
	}

	public MasterListItem getMasterListItemById(String id) {
		// TODO change when persistence is enabled
		for (MasterListItem item : getMasterList()) {
			if (Integer.parseInt(id) == item.getId())
				return item;
		}
		return null;
	}

	public List<Person> getActualMemberList() {
		return getActualTrainingSession().getMember();
	}

	public List<Person> getDefaultMember() {
		return getPersonDBHelper().getPersonList();
	}

	private DataManager getPersonDBHelper() {
		if(dbHelper ==null)
			dbHelper = new DataManagerImpl(this);
		return dbHelper;
	}


	public void setupParticipiants(List<Person> checkedMembers) {
		for (Person participiant : checkedMembers) {
			getActualTrainingSession().addParticipiant(participiant);
		}
	}

	
	public void addPerson(Person person){
		dbHelper.savePerson(person);
	}

}
