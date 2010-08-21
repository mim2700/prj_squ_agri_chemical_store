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
 * Package Name   : com.squ.agri.store.forms
 * File Name      : AdminUserAddForm.java
 * 
 * Date           : Sep 2, 2009
 * 
 */
package com.squ.agri.store.forms;

import org.apache.struts.action.ActionForm;

/**
 * @author Administrator
 * 
 */
public class AdminUserAddForm extends ActionForm
{

	private String uid = null;
	private String name = null;
	private String pwd = null;
	private String role = null;
	private String deptId = null;

	private String j_password = null;
	private String j_username = null;
	private String j_department = null;
	private String j_role = null;
	private String j_name = null;

	/**
	 * @return the j_name
	 */
	public String getJ_name()
	{
		return j_name;
	}

	/**
	 * @param j_name
	 *            the j_name to set
	 */
	public void setJ_name(String j_name)
	{
		this.j_name = j_name;
	}

	/**
	 * @return the j_department
	 */
	public String getJ_department()
	{
		return j_department;
	}

	/**
	 * @param j_department
	 *            the j_department to set
	 */
	public void setJ_department(String j_department)
	{
		this.j_department = j_department;
	}

	/**
	 * @return the j_role
	 */
	public String getJ_role()
	{
		return j_role;
	}

	/**
	 * @param j_role
	 *            the j_role to set
	 */
	public void setJ_role(String j_role)
	{
		this.j_role = j_role;
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

	/**
	 * @return the j_password
	 */
	public String getJ_password()
	{
		return j_password;
	}

	/**
	 * @param j_password
	 *            the j_password to set
	 */
	public void setJ_password(String j_password)
	{
		this.j_password = j_password;
	}

	/**
	 * @return the j_username
	 */
	public String getJ_username()
	{
		return j_username;
	}

	/**
	 * @param j_username
	 *            the j_username to set
	 */
	public void setJ_username(String j_username)
	{
		this.j_username = j_username;
	}

}
