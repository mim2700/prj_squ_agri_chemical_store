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
 * Package Name   : com.squ.agri.store.users
 * File Name      : UserRole.java
 * 
 * Date           : Oct 5, 2009
 * 
 */
package com.squ.agri.store.users;

import java.util.List;

import org.hibernate.Session;

import com.squ.agri.store.dao.DBConstants;
import com.squ.agri.store.dbUtil.HibernateUtil;

/**
 * @author Administrator
 * 
 */
public class UserRole
{
	private String role_id;
	private String role_name;

	public UserRole(String role_id, String role_name)
	{
		this.role_id = role_id;
		this.role_name = role_name;
	}

	public UserRole()
	{
		this.role_id = null;
		this.role_name = null;
	}

	public void setRole_id(String role_id)
	{
		this.role_id = role_id;
	}

	/**
	 * @return the role_id
	 */
	public String getRole_id()
	{
		return role_id;
	}

	/**
	 * @param role_name
	 *            the role_name to set
	 */
	public void setRole_name(String role_name)
	{
		this.role_name = role_name;
	}

	/**
	 * @return the role_name
	 */
	public String getRole_name()
	{
		return role_name;
	}

	public List<UserRole> getAllRoles()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();

		List<UserRole> lstResult = session.getNamedQuery(
				DBConstants.hql_namedQueryLoad_ROLES).list();
		session.close();

		return lstResult;
	}

}
