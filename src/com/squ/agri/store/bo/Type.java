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
 * File Name      : Type.java
 * 
 * Date           : Oct 18, 2009
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
public class Type
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

	public List<Type> getAllType()
	{

		return new CommonDBFactory(StoreConstants.TYPE).getAll();
	}

	public Type getType(String id)
	{

		return (Type) new CommonDBFactory(StoreConstants.TYPE)
				.getObjectyById(id);
	}

}
