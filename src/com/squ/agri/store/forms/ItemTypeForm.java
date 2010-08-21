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
 * File Name      : ItemTypeForm.java
 * 
 * Date           : Oct 18, 2009
 * 
 */
package com.squ.agri.store.forms;

import org.apache.struts.action.ActionForm;

/**
 * @author Administrator
 * 
 */
public class ItemTypeForm extends ActionForm
{
	private String typeId = null;
	private String typeName = null;
	private int typeActive = 0;

	/**
	 * @return the typeId
	 */
	public String getTypeId()
	{
		return typeId;
	}

	/**
	 * @param typeId
	 *            the typeId to set
	 */
	public void setTypeId(String typeId)
	{
		this.typeId = typeId;
	}

	/**
	 * @return the typeName
	 */
	public String getTypeName()
	{
		return typeName;
	}

	/**
	 * @param typeName
	 *            the typeName to set
	 */
	public void setTypeName(String typeName)
	{
		this.typeName = typeName;
	}

	/**
	 * @return the typeActive
	 */
	public boolean isTypeActive()
	{
		if (this.typeActive == 1)
			return true;
		else
			return false;
	}

	/**
	 * @param typeActive
	 *            the typeActive to set
	 */
	public void setTypeActive(boolean typeActive)
	{
		if (typeActive)
			this.typeActive = 1;
		else
			this.typeActive = 0;

	}

}
