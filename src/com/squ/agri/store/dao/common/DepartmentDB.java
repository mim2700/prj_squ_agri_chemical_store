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
 * File Name      : DepartmentDB.java
 * 
 * Date           : Sep 5, 2009
 * 
 */
package com.squ.agri.store.dao.common;

import java.util.List;

import org.hibernate.Session;

import com.squ.agri.store.bo.Department;
import com.squ.agri.store.dao.DBConstants;
import com.squ.agri.store.dbUtil.HibernateUtil;

/**
 * @author Administrator
 * 
 */
public class DepartmentDB implements CommonDao
{
	public List getAll()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();

		List<Department> deptList = session.createQuery(
				DBConstants.hql_DEPARTMENT).list();
		deptList.get(0).setDeptName("Central Store");
		return deptList;
	}

	@Override
	public Object getObjectyById(Object id)
	{

		return null;
	}

	public void saveUpdate(Object obj)
	{

	}
}
