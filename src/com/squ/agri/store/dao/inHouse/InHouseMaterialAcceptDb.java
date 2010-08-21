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
 * File Name      : InHouseMaterialAcceptDb.java
 * 
 * Date           : Dec 3, 2009
 * 
 */
package com.squ.agri.store.dao.inHouse;

import java.math.BigDecimal;
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
public class InHouseMaterialAcceptDb implements InHouseDao
{
	private String option = null;

	public InHouseMaterialAcceptDb(String option)
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
		if (option.equals(StoreConstants.INHOUSE_ALLOCATION_ACCEPT_LIST))
		{
			objResult = (Object) acceptMaterialList((String) obj);
		}
		if (option.equals(StoreConstants.INHOUSE_ALLOCATION_ACCEPTED_ITEMS))
		{
			acceptedItems((Item[]) obj);
		}

		return objResult;
	}

	private RequestItems acceptMaterialList(String deptId)
	{
		RequestItems reqItems = new RequestItems();

		Session session = HibernateUtil.getSessionFactory().openSession();
		List lstLot = session.getNamedQuery(
				DBConstants.hql_sp_FUNC_LOT_ALLOCATION_ACCEPT_LIST)
				.setParameter("deptId", deptId).list();
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
			Item tmpItem = new Item();
			SubItem subItem = new SubItem();

			tmpItem.setProcureId((String) objArray[0]);
			tmpItem.setItemCode((String) objArray[1]);
			tmpItem.setItemName((String) objArray[2]);

			subItem.setSubItemId((String) objArray[3]);
			subItem.setQtyAvailable(((BigDecimal) objArray[4]).intValue());

			mapItem.put(tmpItem.getItemCode(), tmpItem);
			mapSubItem.put(subItem.getSubItemId(), subItem);
			mapItemSubItem.put(subItem.getSubItemId(), tmpItem.getItemCode());

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

	private synchronized void acceptedItems(Item[] items)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		for (int i = 0; i < items.length; i++)
		{
			Item item = items[i];
			SubItem[] subItems = item.getSubItems();

			for (int j = 0; j < subItems.length; j++)
			{
				SubItem subItem = subItems[j];
				List lstLot = session.getNamedQuery(
						DBConstants.hql_sp_FUNC_LOT_ALLOCATION_ACCEPTED)
						.setParameter("deptId", item.getDeptDestId())
						.setParameter("lotId", item.getProcureId())
						.setParameter("subItemId", subItem.getSubItemId())
						.setParameter("subItemQty", subItem.getQtyAvailable())
						.list();

			}

		}

	}

}
