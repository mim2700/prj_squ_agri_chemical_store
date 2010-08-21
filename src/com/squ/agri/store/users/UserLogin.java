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
 * File Name      : UserLogin.java
 * 
 * Date           : Sep 1, 2009
 * 
 */
package com.squ.agri.store.users;

/**
 * @author Administrator
 * 
 */
public class UserLogin implements UserActivity
{
	User user = null;

	public UserLogin(User user)
	{
		this.user = user;
	}

	public Object operation(String opName)
	{
		// TODO check whether the user is authenticated or not

		return false;
	}

}
