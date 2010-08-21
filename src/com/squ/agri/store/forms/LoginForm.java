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
 * File Name      : Login_1_Form.java
 * 
 * Date           : Sep 1, 2009
 * 
 */
package com.squ.agri.store.forms;

import org.apache.struts.action.ActionForm;

/**
 * @author Administrator
 * 
 */

public class LoginForm extends ActionForm
{

	private String uid = null;
	private String name = null;
	private String pwd = null;
	private String role = null;
	private String deptId = null;
	private boolean active = false;

	private String newPwd = null;
	private String confirmPwd = null;

	private boolean logedOn = false;

	/**
	 * @return the newPwd
	 */
	public String getNewPwd()
	{
		return newPwd;
	}

	/**
	 * @param newPwd
	 *            the newPwd to set
	 */
	public void setNewPwd(String newPwd)
	{
		this.newPwd = newPwd;
	}

	/**
	 * @return the confirmPwd
	 */
	public String getConfirmPwd()
	{
		return confirmPwd;
	}

	/**
	 * @param confirmPwd
	 *            the confirmPwd to set
	 */
	public void setConfirmPwd(String confirmPwd)
	{
		this.confirmPwd = confirmPwd;
	}

	/**
	 * @return the active
	 */
	public boolean isActive()
	{
		return active;
	}

	/**
	 * @param active
	 *            the active to set
	 */
	public void setActive(boolean active)
	{
		this.active = active;
	}

	private String j_password = null;
	private String j_username = null;

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

	public String getJ_password()
	{
		return j_password;
	}

	public void setJ_password(String j_password)
	{
		this.j_password = j_password;
	}

	public String getJ_username()
	{
		return j_username;
	}

	public void setJ_username(String j_username)
	{
		this.j_username = j_username;
	}

	/**
	 * @return the logedOn
	 */
	public boolean isLogedOn()
	{
		return logedOn;
	}

	/**
	 * @param logedOn
	 *            the logedOn to set
	 */
	public void setLogedOn(boolean logedOn)
	{
		this.logedOn = logedOn;
	}

}
