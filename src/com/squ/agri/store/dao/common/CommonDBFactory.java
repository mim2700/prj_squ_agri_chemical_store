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
 * File Name      : CommonDBFactory.java
 * 
 * Date           : Sep 5, 2009
 * 
 */
package com.squ.agri.store.dao.common;

import java.util.List;

import com.squ.agri.store.StoreConstants;
import com.squ.agri.store.bo.Department;
import com.squ.agri.store.dao.users.UserDB;

/**
 * @author Administrator
 * 
 */
public class CommonDBFactory
{
	CommonDao commondao = null;

	public CommonDBFactory(String options)
	{
		if (options.equals(StoreConstants.DEPARTMENT))
		{
			commondao = new DepartmentDB();
		}
		if (options.equals(StoreConstants.GRADE))
		{
			commondao = new GradeDB();
		}
		if (options.equals(StoreConstants.SAFETY))
		{
			commondao = new SafetyDB();
		}
		if (options.equals(StoreConstants.TYPE))
		{
			commondao = new TypeDB();
		}
		if (options.equals(StoreConstants.MEASURMEN))
		{
			commondao = new MeasurmentDB();
		}
		if (options.equals(StoreConstants.VARIATION))
		{
			commondao = new VariationDB();
		}

	}

	public List getAll()
	{
		return commondao.getAll();
	}

	public Object getObjectyById(Object id)
	{
		return commondao.getObjectyById(id);
	}

	public void saveUpdate(Object obj)
	{
		commondao.saveUpdate(obj);
	}

}
