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
 * File Name      : Variation.java
 * 
 * Date           : Jan 9, 2010
 * 
 */
package com.squ.agri.store.bo;

/**
 * @author Administrator
 * 
 */
public class Variation
{
	private String variation_Id = null;
	private String variation_Value = null;
	private int variation_Active = 1;

	/**
	 * @return the variation_Id
	 */
	public String getVariation_Id()
	{
		return variation_Id;
	}

	/**
	 * @param variation_Id
	 *            the variation_Id to set
	 */
	public void setVariation_Id(String variation_Id)
	{
		this.variation_Id = variation_Id;
	}

	/**
	 * @return the variation_Value
	 */
	public String getVariation_Value()
	{
		return variation_Value;
	}

	/**
	 * @param variation_Value
	 *            the variation_Value to set
	 */
	public void setVariation_Value(String variation_Value)
	{
		this.variation_Value = variation_Value;
	}

	/**
	 * @return the variation_Active
	 */
	public boolean isVariation_Active()
	{
		if (this.variation_Active == 1)
			return true;
		else
			return false;
	}

	/**
	 * @param variation_Active
	 *            the variation_Active to set
	 */
	public void setVariation_Active(boolean variation_Active)
	{
		if (variation_Active)
			this.variation_Active = 1;
		else
			this.variation_Active = 0;
	}

}
