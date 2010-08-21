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
 * File Name      : ProcurementForm.java
 * 
 * Date           : Sep 7, 2009
 * 
 */
package com.squ.agri.store.forms;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.struts.action.ActionForm;

import com.squ.agri.store.bo.Item;

/**
 * @author Owner
 * 
 */
public class ProcurementForm extends ActionForm
{
	private String procureId = null;
	private String prnNo = null;
	private String lpoNo = null;
	private String grnNo = null;
	private String supplierId = null;
	private String deptSourceId = null; // Source Department
	private String deptDestId = null;
	private Set<Item> items = null;// new HashSet<Item>();
	private Item[] arrItems = null;
	private String[] status = null;
	private int totalItems = 0;

	/**
	 * @return the procureId
	 */
	public String getProcureId()
	{
		return procureId;
	}

	/**
	 * @param procureId
	 *            the procureId to set
	 */
	public void setProcureId(String procureId)
	{
		this.procureId = procureId;
	}

	/**
	 * @return the prnNo
	 */
	public String getPrnNo()
	{
		return prnNo;
	}

	/**
	 * @param prnNo
	 *            the prnNo to set
	 */
	public void setPrnNo(String prnNo)
	{
		this.prnNo = prnNo;
	}

	/**
	 * @return the lpoNo
	 */
	public String getLpoNo()
	{
		return lpoNo;
	}

	/**
	 * @param lpoNo
	 *            the lpoNo to set
	 */
	public void setLpoNo(String lpoNo)
	{
		this.lpoNo = lpoNo;
	}

	/**
	 * @return the grnNo
	 */
	public String getGrnNo()
	{
		return grnNo;
	}

	/**
	 * @param grnNo
	 *            the grnNo to set
	 */
	public void setGrnNo(String grnNo)
	{
		this.grnNo = grnNo;
	}

	/**
	 * @return the supplierId
	 */
	public String getSupplierId()
	{
		return supplierId;
	}

	/**
	 * @param supplierId
	 *            the supplierId to set
	 */
	public void setSupplierId(String supplierId)
	{
		this.supplierId = supplierId;
	}

	/**
	 * @return the deptSourceId
	 */
	public String getDeptSourceId()
	{
		return deptSourceId;
	}

	/**
	 * @param deptSourceId
	 *            the deptSourceId to set
	 */
	public void setDeptSourceId(String deptSourceId)
	{
		this.deptSourceId = deptSourceId;
	}

	/**
	 * @return the deptDestId
	 */
	public String getDeptDestId()
	{
		return deptDestId;
	}

	/**
	 * @param deptDestId
	 *            the deptDestId to set
	 */
	public void setDeptDestId(String deptId)
	{
		this.deptDestId = deptId;
	}

	/**
	 * @return the items
	 */
	public Set<Item> getItems()
	{
		return items;
	}

	/**
	 * @param items
	 *            the items to set
	 */
	public void setItems(Set<Item> items)
	{
		this.items = items;
		int itemSize = items.size();
		arrItems = new Item[itemSize];
		int counter = 0;
		Iterator<Item> itr = items.iterator();
		while (itr.hasNext())
		{
			Item item = itr.next();
			arrItems[counter++] = item;
		}

	}

	/**
	 * @return the arrItems
	 */
	public Item[] getArrItems()
	{
		return arrItems;
	}

	/**
	 * @param arrItems
	 *            the arrItems to set
	 */
	public void setArrItems(Item[] arrItems)
	{
		this.arrItems = arrItems;
	}

	/**
	 * @return the status
	 */
	public String[] getStatus()
	{
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String[] status)
	{
		this.status = status;
	}

	/**
	 * @return the totalItems
	 */
	public int getTotalItems()
	{
		return totalItems;
	}

	/**
	 * @param totalItems
	 *            the totalItems to set
	 */
	public void setTotalItems(int totalItems)
	{
		this.totalItems = totalItems;
	}

}
