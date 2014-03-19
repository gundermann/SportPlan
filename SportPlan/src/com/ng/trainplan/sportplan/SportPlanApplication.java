package com.ng.trainplan.sportplan;

import java.util.ArrayList;
import java.util.List;

import com.ng.trainplan.sportplan.bussines.Factory;
import com.ng.trainplan.sportplan.bussines.MasterListItem;
import com.ng.trainplan.sportplan.bussines.TrainingSession;

import android.app.Application;

public class SportPlanApplication extends Application {

	private static TrainingSession actualSession;
	private List<String> member = new ArrayList<String>();

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

	public List<String> getActualMemberList() {
		return getActualTrainingSession().getMember();
	}

	public List<String> getDefaultMember() {
		if (member.isEmpty()) {
			member.add("Nick Gundermann");
			member.add("Daniel Schwenn");
		}

		return member;
	}

	public void setupParticipiants(List<String> checkedMembers) {
		for (String participiant : checkedMembers) {
			getActualTrainingSession().addParticipiant(participiant);
		}
	}

	public void addToDefaultMemberList(String string) {
		member.add(string);
	}

}
