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
 * File Name      : Measurment.java
 * 
 * Date           : Jan 4, 2010
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
public class Measurment
{
	private String measurment_Id = null;
	private String measurment_Unit = null;
	private int measurment_Active = 1;

	/**
	 * @return the measurment_Id
	 */
	public String getMeasurment_Id()
	{
		return measurment_Id;
	}

	/**
	 * @param measurment_Id
	 *            the measurment_Id to set
	 */
	public void setMeasurment_Id(String measurment_Id)
	{
		this.measurment_Id = measurment_Id;
	}

	/**
	 * @return the measurment_Unit
	 */
	public String getMeasurment_Unit()
	{
		return measurment_Unit;
	}

	/**
	 * @param measurment_Unit
	 *            the measurment_Unit to set
	 */
	public void setMeasurment_Unit(String measurment_Unit)
	{
		this.measurment_Unit = measurment_Unit;
	}

	/**
	 * @return the measurment_Active
	 */
	public boolean isMeasurment_Active()
	{
		if (measurment_Active == 1)
			return true;
		else
			return true;
	}

	/**
	 * @param measurment_Active
	 *            the measurment_Active to set
	 */
	public void setMeasurment_Active(boolean measurment_Active)
	{
		if (measurment_Active)
			this.measurment_Active = 1;
		else
			this.measurment_Active = 0;
	}

	public String getMeasurment_Unit(String id)
	{
		Measurment ms = (Measurment) new CommonDBFactory(
				StoreConstants.MEASURMEN).getObjectyById(id);
		return ms.getMeasurment_Unit();
	}

	public Measurment getMeasurment(String id)
	{
		Measurment ms = (Measurment) new CommonDBFactory(
				StoreConstants.MEASURMEN).getObjectyById(id);
		return ms;
	}

}
