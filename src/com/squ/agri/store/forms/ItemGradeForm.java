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
 * File Name      : ItemGradeForm.java
 * 
 * Date           : Oct 7, 2009
 * 
 */
package com.squ.agri.store.forms;

import org.apache.struts.action.ActionForm;

/**
 * @author Administrator
 * 
 */
public class ItemGradeForm extends ActionForm
{
	private String gradeId = null;
	private String gradeNumber = null;
	private String gradeName = null;
	private String gradeDescription = null;
	private boolean gradeActive = false;

	public boolean isGradeActive()
	{
		return this.gradeActive;
	}

	/**
	 * @param gradeActive
	 *            the gradeActive to set
	 */
	public void setGradeActive(boolean gradeActive)
	{
		this.gradeActive = gradeActive;
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

}
