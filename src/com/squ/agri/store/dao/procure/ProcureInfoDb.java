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
 * Package Name   : com.squ.agri.store.dao.procure
 * File Name      : ProcureInfoDb.java
 * 
 * Date           : Sep 6, 2009
 * 
 */
package com.squ.agri.store.dao.procure;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import com.squ.agri.store.StoreConstants;
import com.squ.agri.store.bo.Item;
import com.squ.agri.store.bo.Procurements;
import com.squ.agri.store.bo.SubItem;
import com.squ.agri.store.dao.DBConstants;
import com.squ.agri.store.dbUtil.HibernateUtil;

/**
 * @author Owner
 * 
 */
public class ProcureInfoDb implements ProcureDao
{
	private Procurements procurements = null;
	private Item item = null;
	private Object procureObj = null;
	private List<SubItem> lstSubItem = null;

	public ProcureInfoDb(Procurements procurements)
	{
		this.procurements = procurements;
	}

	public ProcureInfoDb(Item item)
	{
		this.item = item;
	}

	public ProcureInfoDb(List<SubItem> lstSubItem)
	{
		this.lstSubItem = lstSubItem;
	}

	public Object procurement(String option)
	{

		if (option.equals(StoreConstants.PROCURE_SEND_INFO))
		{
			sendInfo();
		}
		if (option.equals(StoreConstants.PROCURE_VIEW_INFO))
		{
			procureObj = viewInfo();
		}

		if (option.equals(StoreConstants.PROCURE_RECEIVE_INFO))
		{
			procureObj = receivedInfo();
		}

		if (option.equals(StoreConstants.PROCURE_VIEW_ACCEPTED_INVITATION))
		{
			procureObj = viewInvitationReceivedInfo();
		}

		if (option.equals(StoreConstants.PROCURE_STORE_ITEMS_SUBITEMS))
		{
			procureObj = getSubItems();
		}

		if (option.equals(StoreConstants.PROCURE_STORE_SUBITEMS))
		{
			procureObj = setSubItems(lstSubItem);
		}
		if (option.equals(StoreConstants.PROCURE_STORE))
		{
			procureObj = setStoreProcureItems(procurements);
		}

		return procureObj;
	}

	@SuppressWarnings("unchecked")
	private synchronized void sendInfo()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();

		@SuppressWarnings("unused")
		List lstProc = session.getNamedQuery(DBConstants.hql_sp_FUNC_PROCURE_ITEMS)
		.setParameter("prnNo",procurements.getPrnNo())
		.setParameter("lpoNo",procurements.getLpoNo())
		.setParameter("grnNo",procurements.getGrnNo())
		.setParameter("supplierId",procurements.getSupplierId())
		.setParameter("deptSourceId",procurements.getDeptSourceId())
		.setParameter("deptDestId",procurements.getDeptDestId())
		.list();

		session.close();
	}

	private List<Procurements> viewInfo()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();

		List<Procurements> lstResult = session.getNamedQuery(
				DBConstants.hql_namedQueryLoad_PROCUREINVITE).setString(0,
				procurements.getDeptDestId()).list();

		session.close();

		return lstResult;
	}

	private List<Procurements> receivedInfo()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("===========" + procurements.getProcureId()
				+ "==========================");
		List<Procurements> lstResult = session.getNamedQuery(
				DBConstants.hql_sp_FUN_PROC_RECEIVED_INVITATION).setParameter(
				"procureNo", procurements.getProcureId()).list();

		session.close();

		return lstResult;
	}

	@SuppressWarnings("unchecked")
	private List<Procurements> viewInvitationReceivedInfo()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();

		List<Procurements> lstResult = session.getNamedQuery(
				DBConstants.hql_namedQueryLoad_PROCURE_INVITE_ACCEPT_VIEW)
				.setParameter("sourceDept", procurements.getDeptSourceId())
				.list();

		session.close();

		return lstResult;
	}

	@SuppressWarnings("unchecked")
	private List<SubItem> getSubItems()
	{
		List<SubItem> lstSubItem = new ArrayList<SubItem>();
		Session session = HibernateUtil.getSessionFactory().openSession();

		int isMutiple = 0;

		if (item.isMultipleSubItem())
			isMutiple = 1;

		List<SubItem> lstResult = session.getNamedQuery(
				DBConstants.hql_sp_FUNC_STORE_ITEM_SUBITEM).setParameter(
				"procureId", item.getProcureId()).setParameter("visionItemId",
				item.getItemCode()).setParameter("visionItemName",
				item.getItemName()).setParameter("visionItemQty",
				item.getItemQuantity()).setParameter("mutipleSubItems",
				isMutiple).list();

		session.close();

		Iterator itrSubItem = lstResult.iterator();

		while (itrSubItem.hasNext())
		{
			SubItem subItem = new SubItem();
			Object[] objSubItemProperty = (Object[]) itrSubItem.next();
			subItem.setSubItemId((String) objSubItemProperty[1]);
			subItem.setManuDate((Date) objSubItemProperty[2]);
			subItem.setExpireDate((Date) objSubItemProperty[3]);
			subItem.setSize((String) objSubItemProperty[4]);
			subItem.setVariation((String) objSubItemProperty[5]);
			subItem.setGrade((String) objSubItemProperty[6]);
			lstSubItem.add(subItem);
			subItem = null;
			objSubItemProperty = null;
		}

		return lstSubItem;
	}

	@SuppressWarnings("unchecked")
	private Boolean setSubItems(List<SubItem> lstSubItem)
	{
		Boolean booResult = false;
		Iterator<SubItem> itrSubItem = lstSubItem.iterator();
		Session session = HibernateUtil.getSessionFactory().openSession();

		while (itrSubItem.hasNext())
		{
			SubItem subItem = (SubItem) itrSubItem.next();
			List<SubItem> lstResult = session.getNamedQuery(
					DBConstants.hql_sp_FUNC_STORE_SUBITEM).setParameter(
					"subItemId", subItem.getSubItemId()).setParameter(
					"manuDate", subItem.getManuDate()).setParameter(
					"expiryDate", subItem.getExpireDate()).setParameter(
					"itemSize", subItem.getSize()).setParameter(
					"itemVariation", subItem.getVariation()).setParameter(
					"itemGrade", subItem.getGrade()).list();

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

	private synchronized Boolean setStoreProcureItems(Procurements procurements)
	{
		Boolean booResult = false;

		Session session = HibernateUtil.getSessionFactory().openSession();

		Item[] items = procurements.getItems();

		for (int i = 0; i < procurements.getItems().length; i++)
		{
			Item item = items[i];

			int isMutipleSubitems = 0;

			if (item.isMultipleSubItem())
				isMutipleSubitems = 1;

			List<Procurements> lstResult = session.getNamedQuery(
					DBConstants.hql_sp_FUNC_PROCURE_ITEMS_STORE)
					.setParameter("procureId", procurements.getProcureId())
					.setParameter("deptId", item.getDeptDestId())
					.setParameter("visionItemId", item.getItemCode())
					.setParameter("csItemQty", item.getItemCentralStoreQty())
					.setParameter("dsItemQty", item.getItemQuantity())
					.setParameter("mutipleSubItems", isMutipleSubitems)
					.setParameter("measurment", item.getMeasurment())
					.setParameter("safety",item.getSafety())
					.setParameter("type", item.getType())
					.list();

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

}
