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
 * File Name      : safety.java
 * 
 * Date           : Oct 13, 2009
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
public class Safety
{
	private String safetyId = null;
	private String un_Number = null;
	private String other_number = null;
	private String safetyDescription = null;
	private int safetyActive = 0;

	/**
	 * @return the safetyId
	 */
	public String getSafetyId()
	{
		return safetyId;
	}

	/**
	 * @param safetyId
	 *            the safetyId to set
	 */
	public void setSafetyId(String safetyId)
	{
		this.safetyId = safetyId;
	}

	/**
	 * @return the un_Number
	 */
	public String getUn_Number()
	{
		return un_Number;
	}

	/**
	 * @param un_Number
	 *            the un_Number to set
	 */
	public void setUn_Number(String un_Number)
	{
		this.un_Number = un_Number;
	}

	/**
	 * @return the other_number
	 */
	public String getOther_number()
	{
		return other_number;
	}

	/**
	 * @param other_number
	 *            the other_number to set
	 */
	public void setOther_number(String other_number)
	{
		this.other_number = other_number;
	}

	/**
	 * @return the safetyDescription
	 */
	public String getSafetyDescription()
	{
		return safetyDescription;
	}

	/**
	 * @param safetyDescription
	 *            the safetyDescription to set
	 */
	public void setSafetyDescription(String safetyDescription)
	{
		this.safetyDescription = safetyDescription;
	}

	/**
	 * @return the safetyActive
	 */
	public boolean isSafetyActive()
	{
		if (this.safetyActive == 1)
			return true;
		else
			return false;
	}

	/**
	 * @param safetyActive
	 *            the safetyActive to set
	 */
	public void setSafetyActive(boolean safetyActive)
	{
		if (safetyActive)
			this.safetyActive = 1;
		else
			this.safetyActive = 0;
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

	public List<Safety> getAllSafety()
	{

		return new CommonDBFactory(StoreConstants.SAFETY).getAll();
	}

	public Safety getSafety(String id)
	{

		return (Safety) new CommonDBFactory(StoreConstants.SAFETY)
				.getObjectyById(id);
	}

}
