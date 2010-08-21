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
 * File Name      : User.java
 * 
 * Date           : Sep 1, 2009
 * 
 */
package com.squ.agri.store.users;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;

import com.squ.agri.store.StoreConstants;
import com.squ.agri.store.dao.DBConstants;
import com.squ.agri.store.dbUtil.HibernateUtil;

/**
 * @author Administrator
 * 
 */
public class User
{
	private String uid = null;
	private String name = null;
	private String pwd = null;
	private String role = null;
	private String deptId = null;
	private int active = 0;

	/**
	 * @return the active
	 */
	public boolean isActive()
	{
		if (active == 1)
			return true;
		else
			return false;
	}

	/**
	 * @param active
	 *            the active to set
	 */
	public void setActive(boolean active)
	{
		if (active)
			this.active = 1;
		else
			this.active = 0;
	}

	public User(String uid, String pwd, String role)
	{
		this.uid = uid;
		this.pwd = pwd;
		this.role = role;
	}

	public User(String uid, String pwd)
	{
		this.uid = uid;
		this.pwd = pwd;
	}

	public User(String uid)
	{
		this.uid = uid;
	}

	public User()
	{
		this.uid = null;
	}

	/**
	 * @return the uid
	 */
	public String getUid()
	{
		return uid;
	}

	/**
	 * @param uid
	 *            the uid to set
	 */
	public void setUid(String uid)
	{
		this.uid = uid;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @return the pwd
	 */
	public String getPwd()
	{
		return pwd;
	}

	/**
	 * @param pwd
	 *            the pwd to set
	 */
	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}

	/**
	 * @return the role
	 */
	public String getRole()
	{
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(String role)
	{
		this.role = role;
	}

	/**
	 * @return the deptId
	 */
	public String getDeptId()
	{
		return deptId;
	}

	/**
	 * @param deptId
	 *            the deptId to set
	 */
	public void setDeptId(String deptId)
	{
		this.deptId = deptId;
	}

	public List<User> getAll()
	{
		UserFactory usrFactry = new UserFactory(new User());

		return (List<User>) usrFactry.getOperation(new User(),
				StoreConstants.ALL_USERS);
	}

	public void copyBean(Object obj)
	{
		try
		{
			BeanUtils.copyProperties(this, obj);
		}
		catch (IllegalAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (InvocationTargetException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public User getUser(String id)
	{

		Session session = HibernateUtil.getSessionFactory().openSession();

		List<User> lstResult = session.getNamedQuery(
				DBConstants.hql_namedQueryLoad_GETUSER)
				.setString("userId2", id).list();
		User usr = lstResult.get(0);

		session.close();

		return usr;
	}

}
