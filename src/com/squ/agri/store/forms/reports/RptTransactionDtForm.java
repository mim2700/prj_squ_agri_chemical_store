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
 * Package Name   : com.squ.agri.store.forms.reports
 * File Name      : RptTransactionDtForm.java
 * 
 * Date           : Aug 18, 2009
 * 
 */
package com.squ.agri.store.forms.reports;

import org.apache.struts.action.ActionForm;

/**
 * @author Administrator
 * 
 */
public class RptTransactionDtForm extends ActionForm
{
	private String orderFromDate = null;
	private String orderToDate = null;

	/**
	 * @return the orderToDate
	 */
	public String getOrderToDate()
	{
		return orderToDate;
	}

	/**
	 * @param orderToDate
	 *            the orderToDate to set
	 */
	public void setOrderToDate(String orderToDate)
	{
		this.orderToDate = orderToDate;
	}

	/**
	 * @return the orderFromDate
	 */
	public String getOrderFromDate()
	{
		return orderFromDate;
	}

	/**
	 * @param orderFromDate
	 *            the orderFromDate to set
	 */
	public void setOrderFromDate(String orderFromDate)
	{
		this.orderFromDate = orderFromDate;
	}
}
