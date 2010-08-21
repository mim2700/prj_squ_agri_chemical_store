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
 * Package Name   : com.squ.agri.store.dao.inHouse
 * File Name      : InHouseMaterialApproveDb.java
 * 
 * Date           : Nov 18, 2009
 * 
 */
package com.squ.agri.store.dao.inHouse;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;

import com.squ.agri.store.StoreConstants;
import com.squ.agri.store.bo.Item;
import com.squ.agri.store.bo.RequestItems;
import com.squ.agri.store.bo.SubItem;
import com.squ.agri.store.dao.DBConstants;
import com.squ.agri.store.dbUtil.HibernateUtil;

/**
 * @author Administrator
 * 
 */
public class InHouseMaterialApproveDb implements InHouseDao
{
	private String option = null;

	public InHouseMaterialApproveDb(String option)
	{
		this.option = option;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.squ.agri.store.dao.inHouse.InHouseDao#inHouseOperation(java.lang.
	 * Object)
	 */
	@Override
	public Object inHouseOperation(Object obj)
	{
		Object objResult = null;
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

		// TODO Auto-generated method stub
		return objResult;
	}

	private synchronized RequestItems allocationRequested()
	{
		RequestItems reqItems = new RequestItems();

		Session session = HibernateUtil.getSessionFactory().openSession();
		List lstLot = session.getNamedQuery(
				DBConstants.hql_sp_FUNC_LOT_ALLOCATION_REQUESTED_ITEMS).list();

		Item[] arrItems = new Item[lstLot.size()];
		Iterator itr = lstLot.iterator();
		int counter = 0;
		while (itr.hasNext())
		{
			Object[] objArray = (Object[]) itr.next();
			Item item = new Item();
			item.setProcureId((String) objArray[0]);
			item.setItemCode((String) objArray[1]);
			item.setItemName((String) objArray[2]);
			item.setItemQuantity(((BigDecimal) objArray[3]).intValue());
			item.setDeptDestId((String) objArray[4]);
			arrItems[counter++] = item;
		}

		reqItems.setOldItems(arrItems);
		return reqItems;
	}

	private synchronized RequestItems deptStoreItemDetailAvialable(String deptId)
	{
		RequestItems reqItems = new RequestItems();

		Session session = HibernateUtil.getSessionFactory().openSession();
		List lstLot = session.getNamedQuery(DBConstants.hql_sp_FUNC_LOT_ALLOCATION_AVILABLE)
											.setParameter("deptId", deptId)
											.list();
		
		Item[] arrItems = null;
		Iterator itr = lstLot.iterator();
		int counter = 0;
		boolean flag = false;
		String tmpItemCode = null;

		Map<String, Item> mapItem = new HashMap<String, Item>();
		Map<String, SubItem> mapSubItem = new HashMap<String, SubItem>();
		Map<String, String> mapItemSubItem = new HashMap<String, String>();
		while (itr.hasNext())
		{
			Object[] objArray = (Object[]) itr.next();
			if (((BigDecimal) objArray[7]).intValue() != 0) // Available
			// Quantity should
			// not be zero
			{
				Item tmpItem = new Item();
				SubItem subItem = new SubItem();

				tmpItem.setItemCode((String) objArray[0]);
				tmpItem.setItemName((String) objArray[1]);

				subItem.setSubItemId((String) objArray[2]);
				if (objArray[3] == null)
				{
					subItem.setManuDate(Date.valueOf(StoreConstants.DUMMY_STRING_SQL_DATE));
				}
				else
				{
					subItem.setManuDate(Date.valueOf((String) objArray[3]));
				}
				if(objArray[4] == null)
				{
					subItem.setExpireDate(Date.valueOf(StoreConstants.DUMMY_STRING_SQL_DATE));
				}
				else
				{
					subItem.setExpireDate(Date.valueOf((String) objArray[4]));
				}
				
				subItem.setQtyAdded(((BigDecimal) objArray[5]).intValue());
				subItem.setQtyConsumed(((BigDecimal) objArray[6]).intValue());
				subItem.setQtyAvailable(((BigDecimal) objArray[7]).intValue());

				mapItem.put(tmpItem.getItemCode(), tmpItem);
				mapSubItem.put(subItem.getSubItemId(), subItem);
				mapItemSubItem.put(subItem.getSubItemId(), tmpItem
						.getItemCode());
			}
		}

		arrItems = new Item[mapItem.size()];
		Set<String> setKeyItems = mapItem.keySet();
		Iterator<String> itrKeyItems = setKeyItems.iterator();
		int countKeyItems = 0;

		// Iterate through Items
		while (itrKeyItems.hasNext())
		{
			String itemCode = (String) itrKeyItems.next();
			Item item = mapItem.get(itemCode);
			Set setSubItems = new HashSet<SubItem>();
			SubItem[] subItems = null;
			Set<String> setSubItemCode = mapItemSubItem.keySet();
			Iterator itrSubItemCode = setSubItemCode.iterator();
			// Iterate through SubItem-Item
			while (itrSubItemCode.hasNext())
			{
				String subItemCode = (String) itrSubItemCode.next();
				String tempItemCode = (String) mapItemSubItem.get(subItemCode);
				if (tempItemCode.equals(itemCode))
				{
					SubItem subItem = mapSubItem.get(subItemCode);
					setSubItems.add(subItem);

				}
			}
			subItems = new SubItem[setSubItems.size()];
			Iterator<SubItem> itrSubItems = setSubItems.iterator();
			int countSubItem = 0;
			// Get the array of SubItems of a particual items
			while (itrSubItems.hasNext())
			{
				SubItem subItem = itrSubItems.next();
				subItems[countSubItem++] = subItem;
			}

			item.setSubItems(subItems);
			item.sortSubItems();

			arrItems[countKeyItems++] = item;
		}

		reqItems.setNewItems(arrItems);

		return reqItems;

	}

	/**
	 * 
	 * @param reqItems
	 * 
	 * 
	 */
	private synchronized void issuingItems(RequestItems reqItems)
	{
		Item[] items = reqItems.getAdjustedItems();
		for (int i = 0; i < items.length; i++)
		{
			SubItem[] subItems = items[i].getSubItems();
			for (int j = 0; j < subItems.length; j++)
			{
				SubItem subItem = subItems[j];
				Session session = HibernateUtil.getSessionFactory()
						.openSession();
				List lstLot = session.getNamedQuery(
						DBConstants.hql_sp_FUNC_LOT_ALLOCATION_ISSUE_ITEMS)
						.setParameter("lotId", items[i].getProcureId())
						.setParameter("subItemId", subItem.getSubItemId())
						.setParameter("subItemQty", subItem.getQtyAvailable())
						.setParameter("deptId", items[i].getDeptDestId())
						.list();

			}

		}

	}
}
