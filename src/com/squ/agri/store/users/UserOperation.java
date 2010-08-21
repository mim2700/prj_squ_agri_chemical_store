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
 * File Name      : UserOperation.java
 * 
 * Date           : Sep 1, 2009
 * 
 */
package com.squ.agri.store.users;

import com.squ.agri.store.dao.DBFactory;

/**
 * @author Administrator
 * 
 */
public class UserOperation implements UserActivity
{
	private User user = null;

	public UserOperation(User user)
	{
		this.user = user;
	}

	public Object operation(String opName)
	{
		return new DBFactory(user).getUserOption(opName);
	}

}
