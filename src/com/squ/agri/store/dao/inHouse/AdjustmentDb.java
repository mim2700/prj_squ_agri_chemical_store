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
 * File Name      : AdjustmentDb.java
 * 
 * Date           : Nov 16, 2009
 * 
 */
package com.squ.agri.store.dao.inHouse;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;

import com.squ.agri.store.bo.Adjustment;
import com.squ.agri.store.dao.DBConstants;
import com.squ.agri.store.dbUtil.HibernateUtil;

/**
 * @author Administrator
 * 
 */
public class AdjustmentDb implements InHouseDao
{
	private String option = null;

	public void adjustmentOperation(String option)
	{
		this.option = option;
	}

	@Override
	public Object inHouseOperation(Object obj)
	{

		/*
		 * if(option.equals(StoreConstants.ADJUSTMENT_List_All)) { return
		 * getAll(); } else
		 * if(option.equals(StoreConstants.ADJUSTMENT_GET_OBJECT)) { return
		 * getAdjustmentById(obj); } else
		 * if(option.equals(StoreConstants.ADJUSTMENT)) { Adjustment adjustment
		 * = (Adjustment)obj;
		 * 
		 * return true; }
		 */
		return null;
	}

	public List getAll()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();

		List<Adjustment> typeList = session.createQuery(
				DBConstants.hql_ADJUSTMENT_ALL).list();
		return typeList;
	}

	public Object getAdjustmentById(Object id)
	{

		Session session = HibernateUtil.getSessionFactory().openSession();

		List<Adjustment> gradeList = session.createQuery(
				DBConstants.hql_GET_ADJUSTMENT).setString("adjustment_id",
				(String) id).list();

		return gradeList.get(0);

	}

	public String Adjust_Add_SubItem(String itemCode, String itemName,
			String itemType, String itemSafety, String itemGrade,
			String itemMeasurment, String itemIsMultiSubitems)
	{
		String resultSubItemCode = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		List temp = session.getNamedQuery(
				DBConstants.hql_sp_FUNC_ADJUST_SUBITEM).setParameter(
				"itemCode", itemCode).setParameter("itemName", itemName)
				.setParameter("itemType", itemType).setParameter("itemSafety",
						itemSafety).setParameter("itemMeasurment",
						itemMeasurment).setParameter("itemIsMultiSubitems",
						itemIsMultiSubitems).list();
		resultSubItemCode = temp.get(0).toString();

		session.close();

		return resultSubItemCode;
	}

	public void AdjustSubItem(String subitemCode, String deptId, int qty,
			String action, String adjustId, Date manuDate, Date expireDate,
			String grade, String size, String variation, String add_into)
	{

		Session session = HibernateUtil.getSessionFactory().openSession();

		session.getNamedQuery(DBConstants.hql_sp_FUNC_ADJUSTMENT).setParameter(
				"subitemCode", subitemCode).setParameter("deptId", deptId)
				.setParameter("qty", qty).setParameter("action", action)
				.setParameter("adjustId", adjustId).setParameter("manuDate",
						manuDate).setParameter("expireDate", expireDate)
				.setParameter("grade", grade).setParameter("size", size)
				.setParameter("variation", variation).setParameter("add_into",
						add_into).list();

		session.close();

	}
}
