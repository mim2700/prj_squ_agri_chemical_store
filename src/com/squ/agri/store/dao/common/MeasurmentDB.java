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
 * Package Name   : com.squ.agri.store.dao.common
 * File Name      : MeasurmentDB.java
 * 
 * Date           : Jan 4, 2010
 * 
 */
package com.squ.agri.store.dao.common;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.squ.agri.store.bo.Measurment;
import com.squ.agri.store.bo.Type;
import com.squ.agri.store.dao.DBConstants;
import com.squ.agri.store.dbUtil.HibernateUtil;

/**
 * @author Administrator
 * 
 */
public class MeasurmentDB implements CommonDao
{

	public List getAll()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();

		List<Measurment> measurmentList = session.createQuery(
				DBConstants.hql_MEASURMENT_ALL).list();
		return measurmentList;
	}

	public Object getObjectyById(Object id)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();

		List<Measurment> measurmentList = session.createQuery(
				DBConstants.hql_GET_MEASURMENT).setString("measurmentID",
				id.toString().trim()).list();
		System.out.println("=============================="
				+ id.toString().trim() + "======================");
		System.out.println("=============================="
				+ measurmentList.size() + "======================");
		if (measurmentList.size() == 0)
		{
			Measurment m = new Measurment();
			m.setMeasurment_Id(id.toString().trim());
			return m;
		}
		else
		{
			return measurmentList.get(0);
		}

	}

	public void saveUpdate(Object measurment)
	{

		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction tx = session.beginTransaction();

		session.saveOrUpdate((Measurment) measurment);
		tx.commit();

		session.flush();

		session.close();
	}

}
