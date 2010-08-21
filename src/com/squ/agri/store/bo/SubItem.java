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
 * File Name      : SubItem.java
 * 
 * Date           : Oct 6, 2009
 * 
 */
package com.squ.agri.store.bo;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;

import org.apache.commons.beanutils.BeanUtils;

/**
 * @author Administrator
 * 
 */
public class SubItem implements Comparable<SubItem>
{

	private String subItemId = null;
	private Date manuDate = null;
	private Date expireDate = null;
	private int qtyAdded = 0;
	private int qtyConsumed = 0;
	private int qtyAvailable = 0;
	private boolean ACTIVE = true;
	private String size = null;
	private String variation = null;
	private String grade;

	public String getSubItemId()
	{
		return subItemId;
	}

	/**
	 * @param subItemId
	 *            the subItemId to set
	 */
	public void setSubItemId(String subItemId)
	{
		this.subItemId = subItemId;
	}

	/**
	 * @return the manuDate
	 */
	public Date getManuDate()
	{
		return manuDate;
	}

	/**
	 * @param manuDate
	 *            the manuDate to set
	 */
	public void setManuDate(Date manuDate)
	{
		this.manuDate = manuDate;
	}

	/**
	 * @return the expireDate
	 */
	public Date getExpireDate()
	{
		return expireDate;
	}

	/**
	 * @param expireDate
	 *            the expireDate to set
	 */
	public void setExpireDate(Date expireDate)
	{
		this.expireDate = expireDate;
	}

	/**
	 * @return the qtyAdded
	 */
	public int getQtyAdded()
	{
		return qtyAdded;
	}

	/**
	 * @param qtyAdded
	 *            the qtyAdded to set
	 */
	public void setQtyAdded(int qtyAdded)
	{
		this.qtyAdded = qtyAdded;
	}

	/**
	 * @return the qtyConsumed
	 */
	public int getQtyConsumed()
	{
		return qtyConsumed;
	}

	/**
	 * @param qtyConsumed
	 *            the qtyConsumed to set
	 */
	public void setQtyConsumed(int qtyConsumed)
	{
		this.qtyConsumed = qtyConsumed;
	}

	/**
	 * @return the qtyAvailable
	 */
	public int getQtyAvailable()
	{
		return qtyAvailable;
	}

	/**
	 * @param qtyAvailable
	 *            the qtyAvailable to set
	 */
	public void setQtyAvailable(int qtyAvailable)
	{
		this.qtyAvailable = qtyAvailable;
	}

	/**
	 * @return the aCTIVE
	 */
	public boolean isACTIVE()
	{
		return ACTIVE;
	}

	/**
	 * @param active
	 *            the aCTIVE to set
	 */
	public void setACTIVE(boolean active)
	{
		ACTIVE = active;
	}

	/**
	 * @return the size
	 */
	public String getSize()
	{
		return size;
	}

	/**
	 * @param size
	 *            the size to set
	 */
	public void setSize(String size)
	{
		this.size = size;
	}

	/**
	 * @return the variation
	 */
	public String getVariation()
	{
		return variation;
	}

	/**
	 * @param variation
	 *            the variation to set
	 */
	public void setVariation(String variation)
	{
		this.variation = variation;
	}

	/**
	 * @return the grade
	 */
	public String getGrade()
	{
		return grade;
	}

	/**
	 * @param grade
	 *            the grade to set
	 */
	public void setGrade(String grade)
	{
		this.grade = grade;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(SubItem o)
	{

		// TODO Auto-generated method stub
		int result = 0;
		if (this.expireDate != null)
		{
			result = this.expireDate.compareTo(o.getExpireDate());
		}
		return result;
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
