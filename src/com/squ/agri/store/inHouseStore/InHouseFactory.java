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
 * File Name      : InHouseFactory.java
 * 
 * Date           : Nov 4, 2009
 * 
 */
package com.squ.agri.store.inHouseStore;

import com.squ.agri.store.StoreConstants;

/**
 * @author Administrator
 * 
 */
public class InHouseFactory
{

	private InHouse inHouse = null;

	public InHouseFactory(String option)
	{
		if (option.equals(StoreConstants.INHOUSE_MATERIAL_REQUEST))
		{
			inHouse = new InHouseMaterialReceive(option);
		}
		if (option.equals(StoreConstants.INHOUSE_MATERIAL_REQUEST_ADD))
		{
			inHouse = new InHouseMaterialReceive(option);
		}
		if (option.equals(StoreConstants.CONSUME_SUBITEM_DEPARTMENT))
		{
			inHouse = new ConsumeSubItem(option);
		}
		if (option.equals(StoreConstants.INHOUSE_ALLOCATION_REQUEST_LIST))
		{
			inHouse = new InHouseMaterialApprove(
					StoreConstants.INHOUSE_ALLOCATION_REQUEST_LIST);
		}
		if (option.equals(StoreConstants.INHOUSE_ALLOCATION_AVIALABLE_LIST))
		{
			inHouse = new InHouseMaterialApprove(
					StoreConstants.INHOUSE_ALLOCATION_AVIALABLE_LIST);
		}
		if (option.equals(StoreConstants.INHOUSE_ALLOCATION_ISSUE_ITEMS))
		{
			inHouse = new InHouseMaterialApprove(
					StoreConstants.INHOUSE_ALLOCATION_ISSUE_ITEMS);
		}
		if (option.equals(StoreConstants.INHOUSE_ALLOCATION_ACCEPT_LIST))
		{
			inHouse = new InHouseMaterialAccept(
					StoreConstants.INHOUSE_ALLOCATION_ACCEPT_LIST);
		}
		if (option.equals(StoreConstants.INHOUSE_ALLOCATION_ACCEPTED_ITEMS))
		{
			inHouse = new InHouseMaterialAccept(
					StoreConstants.INHOUSE_ALLOCATION_ACCEPTED_ITEMS);
		}

	}

	public Object inHouseOperation(Object obj)
	{
		return inHouse.inHouseOperation(obj);
	}

}
