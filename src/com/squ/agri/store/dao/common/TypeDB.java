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
 * File Name      : TypeDB.java
 * 
 * Date           : Oct 18, 2009
 * 
 */
package com.squ.agri.store.dao.common;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.squ.agri.store.bo.Type;
import com.squ.agri.store.dao.DBConstants;
import com.squ.agri.store.dbUtil.HibernateUtil;

/**
 * @author Administrator
 * 
 */
public class TypeDB implements CommonDao
{
	public List getAll()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();

		List<Type> typeList = session.createQuery(DBConstants.hql_TYPE_ALL)
				.list();
		return typeList;
	}

	public Object getObjectyById(Object id)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();

		List<Type> typeList = session.createQuery(DBConstants.hql_GET_TYPE)
				.setString("typeID", (String) id).list();

		return typeList.get(0);

	}

	public void saveUpdate(Object type)
	{

		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction tx = session.beginTransaction();

		session.saveOrUpdate((Type) type);
		tx.commit();

		session.flush();

		session.close();
	}

}
