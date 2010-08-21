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
 * Package Name   : com.squ.agri.store.dao.users
 * File Name      : UserDao.java
 * 
 * Date           : Sep 13, 2009
 * 
 */
package com.squ.agri.store.dao.users;

import java.util.List;

import com.squ.agri.store.users.User;

/**
 * @author Administrator
 * 
 */
public interface UserDao
{
	public List<User> getAllUser();

	public User getUser(String uid);

	public Object createUser();

	public Object updateUser();

}
