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
 * File Name      : InHouseMaterialApprove.java
 * 
 * Date           : Nov 19, 2009
 * 
 */
package com.squ.agri.store.inHouseStore;

import com.squ.agri.store.StoreConstants;
import com.squ.agri.store.bo.RequestItems;
import com.squ.agri.store.dao.DBFactory;

/**
 * @author Administrator
 * 
 */
public class InHouseMaterialApprove implements InHouse
{

	private String option;

	public InHouseMaterialApprove(String option)
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
		if (option.equals(StoreConstants.INHOUSE_ALLOCATION_REQUEST_LIST))
		{
			objResult = (Object) allocationRequested();
		}
		if (option.equals(StoreConstants.INHOUSE_ALLOCATION_AVIALABLE_LIST))
		{
			objResult = (Object) deptStoreItemDetailAvialable((String) obj);
		}
		if (option.equals(StoreConstants.INHOUSE_ALLOCATION_ISSUE_ITEMS))
		{
			issuingItems((RequestItems) obj);
		}

		return objResult;
	}

	private RequestItems allocationRequested()
	{
		return (RequestItems) new DBFactory().inHouseOperation(null, option);
	}

	private RequestItems deptStoreItemDetailAvialable(String deptId)
	{
		return (RequestItems) new DBFactory().inHouseOperation(deptId, option);
	}

	private void issuingItems(RequestItems reqItems)
	{
		new DBFactory().inHouseOperation(reqItems, option);
	}
}
