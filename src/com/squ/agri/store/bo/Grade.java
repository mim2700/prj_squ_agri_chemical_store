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
 * File Name      : Grade.java
 * 
 * Date           : Oct 7, 2009
 * 
 */
package com.squ.agri.store.bo;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.squ.agri.store.StoreConstants;
import com.squ.agri.store.dao.common.CommonDBFactory;

/**
 * @author Administrator
 * 
 */
public class Grade
{
	private String gradeId = null;
	private String gradeNumber = null;
	private String gradeName = null;
	private String gradeDescription = null;
	private int gradeActive = 0;

	/**
	 * @return the gradeActive
	 */
	public boolean isGradeActive()
	{
		if (gradeActive == 1)
			return true;
		else
			return false;
	}

	/**
	 * @param gradeActive
	 *            the gradeActive to set
	 */
	public void setGradeActive(boolean gradeActive)
	{
		if (gradeActive)
			this.gradeActive = 1;
		else
			this.gradeActive = 0;
	}

	/**
	 * @return the gradeId
	 */
	public String getGradeId()
	{
		return gradeId;
	}

	/**
	 * @param gradeId
	 *            the gradeId to set
	 */
	public void setGradeId(String gradeId)
	{
		this.gradeId = gradeId;
	}

	/**
	 * @return the gradeNumber
	 */
	public String getGradeNumber()
	{
		return gradeNumber;
	}

	/**
	 * @param gradeNumber
	 *            the gradeNumber to set
	 */
	public void setGradeNumber(String gradeNumber)
	{
		this.gradeNumber = gradeNumber;
	}

	/**
	 * @return the gradeName
	 */
	public String getGradeName()
	{
		return gradeName;
	}

	/**
	 * @param gradeName
	 *            the gradeName to set
	 */
	public void setGradeName(String gradeName)
	{
		this.gradeName = gradeName;
	}

	/**
	 * @return the gradeDescription
	 */
	public String getGradeDescription()
	{
		return gradeDescription;
	}

	/**
	 * @param gradeDescription
	 *            the gradeDescription to set
	 */
	public void setGradeDescription(String gradeDescription)
	{
		this.gradeDescription = gradeDescription;
	}

	public void copyBean(Object obj)
	{
		try
		{
			BeanUtils.copyProperties(this, obj);
		}
		catch (IllegalAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (InvocationTargetException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Grade> getAllGrade()
	{

		return new CommonDBFactory(StoreConstants.GRADE).getAll();
	}

	public Grade getGrade(String id)
	{

		return (Grade) new CommonDBFactory(StoreConstants.GRADE)
				.getObjectyById(id);
	}

}
