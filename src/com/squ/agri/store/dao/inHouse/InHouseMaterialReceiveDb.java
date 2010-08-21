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
 * File Name      : InHouseMaterialReceiveDb.java
 * 
 * Date           : Nov 4, 2009
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
import com.squ.agri.store.bo.Procurements;
import com.squ.agri.store.bo.RequestItems;
import com.squ.agri.store.bo.SubItem;
import com.squ.agri.store.dao.DBConstants;
import com.squ.agri.store.dbUtil.HibernateUtil;

/**
 * @author Administrator
 * 
 */
public class InHouseMaterialReceiveDb implements InHouseDao
{
	private String option = null;

	public InHouseMaterialReceiveDb(String option)
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

	/*
	 * Select list of Materials available at Central Store
	 */

	/**
	 * 
	 * @param deptId
	 * @return
	 */
	// private Item[] materialRequestFromCentralStore(String deptId)
	// {
	// Item[] arrItem = null;
	// Session session = HibernateUtil.getSessionFactory().openSession();
	//		
	// List lst =
	// session.getNamedQuery(DBConstants.hql_sp_FUNC_IN_HOUSE_REQUEST_ITEMS)
	// .setParameter("deptId", deptId)
	// .list();
	//		
	// arrItem = new Item[lst.size()];
	// Iterator itr = lst.iterator();
	// int arrCount = 0;
	// while (itr.hasNext())
	// {
	// Object[] objItem = (Object[])itr.next();
	// Item item = new Item();
	// item.setItemCode((String)objItem[0]);
	// item.setItemName((String)objItem[1]);
	// BigDecimal itemQty = (BigDecimal)objItem[2];
	// item.setItemQuantity(itemQty.intValue());
	//			
	// arrItem[arrCount++]=item;
	// item = null;
	// }
	//		
	// return arrItem;
	//		
	// }

	private Item[] materialRequestFromCentralStore(String deptId)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		List lstLot = session.getNamedQuery(DBConstants.hql_sp_FUNC_LOT_ALLOCATION_AVILABLE)
									.setParameter("deptId", deptId)
									.list();
		
		Item[] arrItem = null;
		Iterator itr = lstLot.iterator();
		int counter = 0;
		boolean flag = false;
		String tmpItemCode = null;

		Map<String, Item> mapItem = new HashMap<String, Item>();
		Map<String, SubItem> mapSubItem = new HashMap<String, SubItem>();
		Map<String, String> mapItemSubItem = new HashMap<String, String>();
		arrItem = new Item[lstLot.size()];
		int arrCount = 0;
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
				if(objArray[3]==null)
				{
					subItem.setManuDate(Date.valueOf(StoreConstants.DUMMY_STRING_SQL_DATE));
				}
				else
				{
					subItem.setManuDate(Date.valueOf((String) objArray[3]));
				}
				if(objArray[4]== null)
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

			// Object[] objItem = (Object[]) itr.next();
			// Item item = new Item();
			// item.setItemCode((String) objItem[0]);
			// item.setItemName((String) objItem[1]);
			// BigDecimal itemQty = (BigDecimal) objItem[2];
			// item.setItemQuantity(itemQty.intValue());

			// arrItem[arrCount++] = item;
			// item = null;
		}
		arrItem = new Item[mapItem.size()];
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
			int qtyItemAvialable = 0;
			while (itrSubItems.hasNext())
			{
				SubItem subItem = itrSubItems.next();
				subItems[countSubItem++] = subItem;
				qtyItemAvialable = qtyItemAvialable + subItem.getQtyAvailable();
			}

			item.setSubItems(subItems);
			item.setItemQuantity(qtyItemAvialable);
			item.sortSubItems();

			arrItem[countKeyItems++] = item;
		}
		return arrItem;
	}

	private synchronized List materialRequestAdd(RequestItems reqItems)
	{
		String lotId = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		Item[] oldItems = reqItems.getOldItems();
		Item[] newItems = reqItems.getNewItems();
		session.beginTransaction();

		List lstLot = session.getNamedQuery(
				DBConstants.hql_sp_FUNC_LOT_ALLOCATION_ADD_LOT).setParameter(
				"reqDeptId", reqItems.getDeptReq()).setParameter(
				"approveDeptId", reqItems.getDeptApproved()).list();

		Iterator itr = lstLot.iterator();
		while (itr.hasNext())
		{

			lotId = (String) itr.next();
		}

		for (int i = 0; i < newItems.length; i++)
		{
			int qtyAvailable = 0;

			for (int j = 0; j < oldItems.length; j++)
			{
				if (oldItems[j].getItemCode().equals(newItems[i].getItemCode()))
				{
					qtyAvailable = oldItems[j].getItemQuantity();
				}

			}
			List lst = session.getNamedQuery(
					DBConstants.hql_sp_FUNC_LOT_ALLOCATION_ADD_ITEMS)
					.setParameter("lotId", lotId).setParameter("visionItemId",
							newItems[i].getItemCode()).setParameter(
							"qtyAvilable", qtyAvailable).setParameter("qtyReq",
							newItems[i].getItemQuantity())// reqDeptId,:approveDeptId,:visionItemId,:qtyAvilable,:qtyReq
					.list();
		}

		return null;
	}

}
