/**
 * Organisation   : Sultan Qaboos University
 * Client         : College of Agriculture & Marine Sciences
 * Project        : Chemical Store Management
 * Client Contact : Mr. Jamal Al-Sabahi (jamal@squ.edu.om)
 *
 * Developed by   : CIS Department
 *                  SQU, Muscat, Oman.
 *
 *------- Technical Details ---------------
 * Project Name   : prj_squ_agri_chemical_store
 * Package Name   : com.squ.agri.store.inHouseStore
 * File Name      : ConsumeSubItem.java
 * 
 * Date           : Nov 6, 2009
 * 
 */
package com.squ.agri.store.inHouseStore;

import com.squ.agri.store.dao.DBFactory;

/**
 * @author Administrator
 * 
 */
public class ConsumeSubItem implements InHouse
{
	private String option;

	public ConsumeSubItem(String option)
	{
		this.option = option;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.squ.agri.store.inHouseStore.InHouse#inHouseOperation(java.lang.Object
	 * )
	 */
	@Override
	public Object inHouseOperation(Object obj)
	{
		// TODO Auto-generated method stub
		return consumeSubItemsDept(obj);
	}

	private Object consumeSubItemsDept(Object obj)
	{
		return new DBFactory().inHouseOperation(obj, option);
	}

}
