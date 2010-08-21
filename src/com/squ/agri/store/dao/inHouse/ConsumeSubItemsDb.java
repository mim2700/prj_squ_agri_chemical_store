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
 * File Name      : ConsumeSubItemsDb.java
 * 
 * Date           : Nov 6, 2009
 * 
 */
package com.squ.agri.store.dao.inHouse;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.sql.Date;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.squ.agri.store.StoreConstants;
import com.squ.agri.store.bo.Adjustment;
import com.squ.agri.store.bo.Item;
import com.squ.agri.store.bo.Procurements;
import com.squ.agri.store.bo.SubItem;
import com.squ.agri.store.dao.DBConstants;
import com.squ.agri.store.dbUtil.HibernateUtil;
import com.squ.agri.store.users.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.net.*;

/**
 * @author Administrator
 * 
 */
public class ConsumeSubItemsDb implements InHouseDao
{

	private synchronized Boolean consumeSubItemsDept(Procurements procurements)
	{
		Boolean booResult = false;

		String consumeFrom = "Department";

		if (procurements.getUserRole().equalsIgnoreCase("Central_Store")
				|| procurements.getUserRole().equalsIgnoreCase("Administrator"))
			consumeFrom = "Central_Store";

		Session session = HibernateUtil.getSessionFactory().openSession();

		Item[] items = procurements.getItems();
		List lstResult = null;
		for (int i = 0; i < procurements.getItems().length; i++)
		{
			Item item = items[i];
			SubItem[] subItems = item.getSubItems();
			for (int j = 0; j < subItems.length; j++)
			{
				SubItem subItem = subItems[j];

				lstResult = session.getNamedQuery(
						DBConstants.hql_sp_FUNC_CONSUME_DEPT_SUBITEMS)
						.setParameter("subItemId", subItem.getSubItemId())
						.setParameter("deptId", item.getDeptDestId())
						.setParameter("qty", subItem.getQtyAvailable())
						.setParameter("consumeFrom", consumeFrom).list();

			}

			if (lstResult != null)
			{
				if (lstResult.size() != 0)
				{
					booResult = true;
				}
			}
		}
		return booResult;
	}

	public Item[] itemsListFrom_DS(String deptId, String value,
			String searchBy, String searchFrom)
	{
		Item[] arrItem = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		List lst = session.getNamedQuery(
				DBConstants.hql_sp_FUNC_IN_HOUSE_ITEMS_LIST)
				.setParameter("deptId", deptId)
				.setParameter("value", value)
				.setParameter("searchBy", searchBy)
				.setParameter("searchFrom", searchFrom)
				.list();

		arrItem = new Item[lst.size()];
		Iterator itr = lst.iterator();
		int arrCount = 0;
		while (itr.hasNext())
		{
			Object[] objItem = (Object[]) itr.next();
			Item item = new Item();
			item.setItemCode((String) objItem[0]);
			item.setItemName((String) objItem[1]);
			BigDecimal itemQty = (BigDecimal) objItem[2];
			item.setItemQuantity(itemQty.intValue());
			String mutipleItems = (String) objItem[1];

			if (mutipleItems != null)
				if ((char) mutipleItems.charAt(0) == 'y')
					item.setMultipleSubItem(true);
				else
					item.setMultipleSubItem(false);

			arrItem[arrCount++] = item;
			item = null;
		}

		return arrItem;

	}

	public SubItem[] subItemsList(String itemId, String deptId, int quantity,
			String searchFrom, String adjustId)
	{
		SubItem[] arrItem = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		List lst = session.getNamedQuery(
				DBConstants.hql_sp_FUNC_IN_HOUSE_SUBITEM_LIST).setParameter(
				"subItemId", itemId).setParameter("deptId", deptId)
				.setParameter("quantity", quantity).setParameter("adjustId",
						adjustId).setParameter("searchFrom", searchFrom).list();

		arrItem = new SubItem[lst.size()];
		Iterator itr = lst.iterator();
		int arrCount = 0;
		while (itr.hasNext())
		{
			Object[] objItem = (Object[]) itr.next();
			SubItem subItem = new SubItem();

			subItem.setSubItemId((String) objItem[0]);
			subItem.setManuDate((Date) objItem[1]);
			subItem.setExpireDate((Date) objItem[2]);

			BigDecimal temp = (BigDecimal) objItem[3];

			subItem.setQtyAvailable(temp.intValue());

			arrItem[arrCount++] = subItem;
			subItem = null;
		}

		return arrItem;

	}

	public Object getItemById(String itemCode)
	{
		Item item = new Item();

		Session session = HibernateUtil.getSessionFactory().openSession();

		List lst = session.getNamedQuery(
				DBConstants.hql_sp_FUNC_PRODUCT_SINGLE_ITEM).setParameter(
				"itemCode", itemCode).list();

		Iterator itr = lst.iterator();

		while (itr.hasNext())
		{
			Object[] objItem = (Object[]) itr.next();

			item.setItemCode((String) objItem[0]);
			item.setType((String) objItem[1]);
			item.setItemName((String) objItem[2]);
			String isMuti = (String) objItem[3];

			if (isMuti != null)
				if ((char) isMuti.charAt(0) == 'y')
					item.setMultipleSubItem(true);
				else
					item.setMultipleSubItem(false);

			item.setSafety((String) objItem[4]);
			item.setMeasurment((String) objItem[5]);

		}

		return item;

	}

	public Item[] getAllAgriVisionItems()
	{
		Item[] arrItem = null;

		Session session = HibernateUtil.getSessionFactory().openSession();

		List lst = session.getNamedQuery(
				DBConstants.hql_sp_FUNC_GET_ALL_AGRI_VISION_ITEMS).list();

		arrItem = new Item[lst.size()];
		int arrCount = 0;

		Iterator itr = lst.iterator();

		while (itr.hasNext())
		{
			Object[] objItem = (Object[]) itr.next();

			Item tem_item = new Item();

			tem_item.setItemCode((String) objItem[0]);
			tem_item.setItemName((String) objItem[1]);

			arrItem[arrCount++] = tem_item;
			tem_item = null;

		}

		return arrItem;

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
		if (obj instanceof Procurements)
		// TODO Auto-generated method stub
		{
			Procurements procurements = (Procurements) obj;
			objResult = consumeSubItemsDept(procurements);
		}

		return objResult;
	}
}
