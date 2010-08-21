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
 * File Name      : InHouseMaterialReceive.java
 * 
 * Date           : Nov 4, 2009
 * 
 */
package com.squ.agri.store.inHouseStore;

import java.util.List;

import com.squ.agri.store.StoreConstants;
import com.squ.agri.store.bo.Item;
import com.squ.agri.store.bo.Procurements;
import com.squ.agri.store.bo.RequestItems;
import com.squ.agri.store.dao.DBFactory;

/**
 * @author Administrator
 * 
 */
public class InHouseMaterialReceive implements InHouse
{
	private String option = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.squ.agri.store.inHouseStore.InHouse#inHouseOperation(java.lang.Object
	 * )
	 */

	public InHouseMaterialReceive(String option)
	{

		this.option = option;
	}

	@Override
	public Object inHouseOperation(Object obj)
	{
		Object objInHouse = null;
		Procurements procurements = null;
		if (option.equals(StoreConstants.INHOUSE_MATERIAL_REQUEST))
		{
			String deptId = (String) obj;
			objInHouse = materialRequestFromCentralStore(deptId);

		}
		if (option.equals(StoreConstants.INHOUSE_MATERIAL_REQUEST_ADD))
		{
			RequestItems reqItems = (RequestItems) obj;
			objInHouse = materialRequestAdd(reqItems);

		}
		// TODO Auto-generated method stub
		return objInHouse;
	}

	private Item[] materialRequestFromCentralStore(String deptId)
	{
		return (Item[]) new DBFactory().inHouseOperation(deptId, option);
	}

	private List materialRequestAdd(RequestItems reqItems)
	{
		return (List) new DBFactory().inHouseOperation(reqItems, option);
	}

}
