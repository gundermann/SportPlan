package com.ng.trainplan.sportplan;

import java.util.List;

import android.app.Application;
import android.util.Log;

import com.ng.trainplan.sportplan.business.Factory;
import com.ng.trainplan.sportplan.business.MasterListItem;
import com.ng.trainplan.sportplan.person.Person;
import com.ng.trainplan.sportplan.person.persistence.PersonDataManager;
import com.ng.trainplan.sportplan.person.persistence.PersonDataManagerImpl;
import com.ng.trainplan.sportplan.trainingsession.business.TrainingSession;
import com.ng.trainplan.sportplan.trainingsession.persistence.TrainingSessionDataManager;
import com.ng.trainplan.sportplan.trainingsession.persistence.TrainingSessionDataManagerImpl;

public class SportPlanApplication extends Application {

	private static TrainingSession actualSession;
	private PersonDataManager pDbHelper;
	private TrainingSessionDataManager tsDbHelper;

	public TrainingSession getActualTrainingSession() {
		if (actualSession == null) {
			actualSession = Factory.getInstance().createTrainingSession();
		}
		return actualSession;
	}

	public void setActualTrainingSession(TrainingSession trainingSession) {
		actualSession = trainingSession;
	}

	public List<MasterListItem> getMasterList() {
		return getTrainigSessionDBHelper()
				.getMasterListItems();
	}

	public MasterListItem getMasterListItemById(long id) {
		return getTrainigSessionDBHelper().getMasterListItem(id);
	}

	public List<Person> getActualMemberList() {
		return getActualTrainingSession().getMember();
	}

	public List<Person> getDefaultMember() {
		return getPersonDBHelper().getPersonList();
	}

	private PersonDataManager getPersonDBHelper() {
		if (pDbHelper == null)
			pDbHelper = new PersonDataManagerImpl(this);
		return pDbHelper;
	}

	private TrainingSessionDataManager getTrainigSessionDBHelper() {
		if (tsDbHelper == null) {
			tsDbHelper = new TrainingSessionDataManagerImpl(this);
		}
		return tsDbHelper;
	}

	public void setupParticipiants(List<Person> checkedMembers) {
		for (Person participiant : checkedMembers) {
			getActualTrainingSession().addParticipiant(participiant);
		}
	}

	public void addPerson(Person person) {
		getPersonDBHelper().savePerson(person);
	}

	public void saveTrainingSession(TrainingSession trainingSession) {
		try {
			getTrainigSessionDBHelper().saveTrainingSession(trainingSession);
		} catch (Exception e) {
			Log.e("TRAININGSESSION", e.getMessage());
		}
	}

}
