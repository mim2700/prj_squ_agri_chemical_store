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
 * File Name      : UserDB.java
 * 
 * Date           : Sep 9, 2009
 * 
 */
package com.squ.agri.store.dao.users;

import java.util.List;

import org.hibernate.Session;

import com.squ.agri.store.bo.Department;
import com.squ.agri.store.bo.Procurements;
import com.squ.agri.store.dao.DBConstants;
import com.squ.agri.store.dbUtil.HibernateUtil;
import com.squ.agri.store.users.User;

/**
 * @author Administrator
 * 
 */
public class UserDB implements UserDao
{

	private User user = null;

	public UserDB(User user)
	{
		this.user = user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.squ.agri.store.dao.users.UserDao#createUser(com.squ.agri.store.users
	 * .User)
	 */
	@Override
	public Object createUser()
	{

		Session session = HibernateUtil.getSessionFactory().openSession();

		int active_val = 0;

		if (user.isActive())
			active_val = 1;

		session.getNamedQuery(DBConstants.hql_sp_FUNC_CREATE_USER)
				.setParameter("uid", user.getUid()).setParameter("name",
						user.getName()).setParameter("pwd", user.getPwd())
				.setParameter("role", user.getRole()).setParameter("deptId",
						user.getDeptId()).setParameter("active", active_val)
				.setParameter("operation", "Add").list();
		session.close();

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.squ.agri.store.dao.users.UserDao#getAllUser()
	 */
	@Override
	public List<User> getAllUser()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();

		List<User> lstResult = session.getNamedQuery(
				DBConstants.hql_namedQueryLoad_USERS).list();

		session.close();

		return lstResult;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.squ.agri.store.dao.users.UserDao#getUser(java.lang.String)
	 */
	@Override
	public User getUser(String uid)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.squ.agri.store.dao.users.UserDao#updateUser(com.squ.agri.store.users
	 * .User)
	 */
	@Override
	public Object updateUser()
	{

		Session session = HibernateUtil.getSessionFactory().openSession();

		int active_val = 0;

		if (user.isActive())
			active_val = 1;

		session.getNamedQuery(DBConstants.hql_sp_FUNC_CREATE_USER)
				.setParameter("uid", user.getUid()).setParameter("name",
						user.getName()).setParameter("pwd", user.getPwd())
				.setParameter("role", user.getRole()).setParameter("deptId",
						user.getDeptId()).setParameter("active", active_val)
				.setParameter("operation", "Modify").list();
		session.close();

		return null;
	}

}
