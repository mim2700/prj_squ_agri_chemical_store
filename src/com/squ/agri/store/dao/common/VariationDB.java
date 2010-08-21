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
 * File Name      : GradeDB.java
 * 
 * Date           : Oct 7, 2009
 * 
 */
package com.squ.agri.store.dao.common;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.squ.agri.store.bo.Variation;
import com.squ.agri.store.dao.DBConstants;
import com.squ.agri.store.dbUtil.HibernateUtil;

/**
 * @author Administrator
 * 
 */
public class VariationDB implements CommonDao
{
	public List getAll()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();

		List<Variation> variationList = session.createQuery(
				DBConstants.hql_VARIATION_ALL).list();
		return variationList;
	}

	public Object getObjectyById(Object id)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();

		List<Variation> variationList = session.createQuery(
				DBConstants.hql_GET_VARIATION).setString("variationID",
				(String) id).list();

		return variationList.get(0);

	}

	public void saveUpdate(Object variation)
	{

		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction tx = session.beginTransaction();

		session.saveOrUpdate((Variation) variation);
		tx.commit();

		session.flush();

		session.close();
	}

}
