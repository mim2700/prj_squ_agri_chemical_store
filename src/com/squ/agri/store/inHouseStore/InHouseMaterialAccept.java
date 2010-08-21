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
 * File Name      : InHouseMaterialAccept.java
 * 
 * Date           : Dec 3, 2009
 * 
 */
package com.squ.agri.store.inHouseStore;

import com.squ.agri.store.StoreConstants;
import com.squ.agri.store.bo.Item;
import com.squ.agri.store.bo.RequestItems;
import com.squ.agri.store.dao.DBFactory;

/**
 * @author Administrator
 * 
 */
public class InHouseMaterialAccept implements InHouse
{

	private String option = null;

	public InHouseMaterialAccept(String option)
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
		Object objResult = null;
		// TODO Auto-generated method stub
		if (option.equals(StoreConstants.INHOUSE_ALLOCATION_ACCEPT_LIST))
		{
			objResult = (Object) acceptMaterialList((String) obj);
		}
		if (option.equals(StoreConstants.INHOUSE_ALLOCATION_ACCEPTED_ITEMS))
		{
			acceptedItems((Item[]) obj);
		}

		// TODO Auto-generated method stub
		return objResult;
	}

	private RequestItems acceptMaterialList(String deptId)
	{
		return (RequestItems) new DBFactory().inHouseOperation(deptId, option);
	}

	private void acceptedItems(Item[] items)
	{
		new DBFactory().inHouseOperation(items, option);
	}

}
