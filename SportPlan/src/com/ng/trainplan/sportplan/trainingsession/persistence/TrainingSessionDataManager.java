package com.ng.trainplan.sportplan.trainingsession.persistence;

import java.util.List;

import com.ng.trainplan.sportplan.business.MasterListItem;
import com.ng.trainplan.sportplan.trainingsession.business.TrainingSession;

public interface TrainingSessionDataManager {

	long saveTrainingSession(TrainingSession trainingSession) throws Exception;
	
	List<TrainingSession> getTrainingSessionList();
	
	List<MasterListItem> getMasterListItems();
	
	MasterListItem getMasterListItem(Long id);
}
