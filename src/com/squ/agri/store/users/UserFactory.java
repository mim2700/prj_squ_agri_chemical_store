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
 * File Name      : UserFactory.java
 * 
 * Date           : Sep 1, 2009
 * 
 */
package com.squ.agri.store.users;

import com.squ.agri.store.StoreConstants;

/**
 * @author Administrator
 * 
 */
public class UserFactory
{
	private User user = null;

	public UserFactory(User user)
	{
		this.user = user;
	}

	public Object getOperation(User user, String opType)
	{
		UserActivity userActivity = null;

		if (opType.equals(StoreConstants.UserLogin))
		{
			userActivity = new UserLogin(user);
			return userActivity.operation(StoreConstants.UserLogin);
		}
		else
		{
			userActivity = new UserOperation(user);
			return userActivity.operation(opType);
		}

	}

}
