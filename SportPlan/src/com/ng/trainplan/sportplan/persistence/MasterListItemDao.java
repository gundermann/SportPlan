package com.ng.trainplan.sportplan.persistence;

import org.droidpersistence.dao.DroidDao;

import com.ng.trainplan.sportplan.business.MasterListItem;

import android.database.sqlite.SQLiteDatabase;


public class MasterListItemDao extends DroidDao<MasterListItem, Long> {

	public MasterListItemDao(MasterListItemTableDefinition tableDefinition,
			SQLiteDatabase database) {
		super(MasterListItem.class, tableDefinition, database);
	}
}
