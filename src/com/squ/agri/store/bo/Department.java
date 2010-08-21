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
 * Package Name   : com.squ.agri.store.bo
 * File Name      : Department.java
 * 
 * Date           : Sep 5, 2009
 * 
 */
package com.squ.agri.store.bo;

import java.util.List;

import com.squ.agri.store.StoreConstants;
import com.squ.agri.store.dao.common.CommonDBFactory;

/**
 * @author Administrator
 * 
 */
public class Department
{
	private String deptId = null;
	private String deptName = null;
	private String collegeId = null;

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
	 * @return the deptName
	 */
	public String getDeptName()
	{
		return deptName;
	}

	public String getDeptName(String id)
	{
		List<Department> lst = getAll();
		for (int i = 0; i < lst.size() - 1; i++)
			if (lst.get(i).getDeptId().trim().equals(id.trim()))
				return lst.get(i).getDeptName();

		return null;
	}

	public Department getDeparment(String id)
	{
		List<Department> lst = getAll();

		for (int i = 0; i < lst.size(); i++)
			if (lst.get(i).getDeptId().trim().equalsIgnoreCase(id.trim()))
				return lst.get(i);

		return null;
	}

	/**
	 * @param deptName
	 *            the deptName to set
	 */
	public void setDeptName(String deptName)
	{
		this.deptName = deptName;
	}

	/**
	 * @return the collegeId
	 */
	public String getCollegeId()
	{
		return collegeId;
	}

	/**
	 * @param collegeId
	 *            the collegeId to set
	 */
	public void setCollegeId(String collegeId)
	{
		this.collegeId = collegeId;
	}

	public List<Department> getAll()
	{
		return new CommonDBFactory(StoreConstants.DEPARTMENT).getAll();
	}

}
