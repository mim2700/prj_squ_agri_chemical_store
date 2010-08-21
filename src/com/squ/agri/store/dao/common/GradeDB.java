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

import com.squ.agri.store.bo.Grade;
import com.squ.agri.store.dao.DBConstants;
import com.squ.agri.store.dbUtil.HibernateUtil;

/**
 * @author Administrator
 * 
 */
public class GradeDB implements CommonDao
{
	public List getAll()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();

		List<Grade> gradeList = session.createQuery(DBConstants.hql_GRADE_ALL)
				.list();
		return gradeList;
	}

	public Object getObjectyById(Object id)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();

		List<Grade> gradeList = session.createQuery(DBConstants.hql_GET_GRADE)
				.setString("gradeID", (String) id).list();

		return gradeList.get(0);

	}

	public void saveUpdate(Object grade)
	{

		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction tx = session.beginTransaction();

		session.saveOrUpdate((Grade) grade);
		tx.commit();

		session.flush();

		session.close();
	}

}
