package com.ng.trainplan.sportplan;

import java.util.ArrayList;
import java.util.List;

import android.app.Application;

import com.ng.trainplan.sportplan.business.Factory;
import com.ng.trainplan.sportplan.business.MasterListItem;
import com.ng.trainplan.sportplan.business.TrainingSession;
import com.ng.trainplan.sportplan.person.business.Person;
import com.ng.trainplan.sportplan.person.persistence.PersonDataManager;
import com.ng.trainplan.sportplan.person.persistence.PersonDataManagerImpl;

public class SportPlanApplication extends Application {

	private static TrainingSession actualSession;
	private PersonDataManager dbHelper;

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

	private PersonDataManager getPersonDBHelper() {
		if(dbHelper ==null)
			dbHelper = new PersonDataManagerImpl(this);
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
