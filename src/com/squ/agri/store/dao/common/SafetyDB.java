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
 * File Name      : SafetyDB.java
 * 
 * Date           : Oct 17, 2009
 * 
 */
package com.squ.agri.store.dao.common;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.squ.agri.store.bo.Safety;
import com.squ.agri.store.dao.DBConstants;
import com.squ.agri.store.dbUtil.HibernateUtil;

/**
 * @author Administrator
 * 
 */
public class SafetyDB implements CommonDao
{
	public List getAll()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();

		List<Safety> safetyList = session.createQuery(
				DBConstants.hql_SAFETY_ALL).list();
		return safetyList;
	}

	public Object getObjectyById(Object id)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();

		List<Safety> safetyList = session.createQuery(
				DBConstants.hql_GET_SAFETY).setString("safetyID", (String) id)
				.list();

		return safetyList.get(0);

	}

	public void saveUpdate(Object safety)
	{

		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction tx = session.beginTransaction();

		session.saveOrUpdate((Safety) safety);
		tx.commit();

		session.flush();

		session.close();
	}

}
