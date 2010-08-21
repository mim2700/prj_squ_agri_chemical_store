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
import com.squ.agri.store.dao.inHouse.AdjustmentDb;

/**
 * @author Administrator
 * 
 */
public class Adjustment
{

	private String adjusment_ID = null;
	private String adjusment_Name = null;
	private String adjusment_Action = null;

	/**
	 * @return the adjusment_ID
	 */
	public String getAdjusment_ID()
	{
		return adjusment_ID;
	}

	/**
	 * @param adjusment_ID
	 *            the adjusment_ID to set
	 */
	public void setAdjusment_ID(String adjusment_ID)
	{
		this.adjusment_ID = adjusment_ID;
	}

	/**
	 * @return the adjusment_Name
	 */
	public String getAdjusment_Name()
	{
		return adjusment_Name;
	}

	/**
	 * @param adjusment_Name
	 *            the adjusment_Name to set
	 */
	public void setAdjusment_Name(String adjusment_Name)
	{
		this.adjusment_Name = adjusment_Name;
	}

	/**
	 * @return the adjusment_Action
	 */
	public String getAdjusment_Action()
	{
		return adjusment_Action;
	}

	/**
	 * @param adjusment_Action
	 *            the adjusment_Action to set
	 */
	public void setAdjusment_Action(String adjusment_Action)
	{
		this.adjusment_Action = adjusment_Action;
	}

	public List<Adjustment> getAll()
	{
		return new AdjustmentDb().getAll();
	}

	public Adjustment getAdjustmentById(String id)
	{
		return (Adjustment) new AdjustmentDb().getAdjustmentById(id);
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

}
