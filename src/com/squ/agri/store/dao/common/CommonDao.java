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
 * File Name      : CommonDao.java
 * 
 * Date           : Sep 5, 2009
 * 
 */
package com.squ.agri.store.dao.common;

import java.util.List;

import com.squ.agri.store.users.User;

/**
 * @author Administrator
 * 
 */
public interface CommonDao
{
	@SuppressWarnings("unchecked")
	public List getAll();

	public Object getObjectyById(Object id);

	public void saveUpdate(Object obj);
	// public Object dbOperation(User user);
}
