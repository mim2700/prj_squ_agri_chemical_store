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
 * File Name      : ConsumeItemForm.java
 * 
 * Date           : Nov 7, 2009
 * 
 */
package com.squ.agri.store.forms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.squ.agri.store.bo.Department;
import com.squ.agri.store.bo.SubItem;

/**
 * @author Administrator
 * 
 */
public class ConsumeItemForm extends ActionForm
{

	private Department department = null;
	private String itemCode = null;
	private String itemName = null;
	private int itemQuantity = 0;
	private SubItem[] subItems;

	/**
	 * @return the department
	 */
	public Department getDepartment()
	{
		return department;
	}

	/**
	 * @param department
	 *            the department to set
	 */
	public void setDepartment(Department department)
	{
		this.department = department;
	}

	/**
	 * @return the itemCode
	 */
	public String getItemCode()
	{
		return itemCode;
	}

	/**
	 * @param itemCode
	 *            the itemCode to set
	 */
	public void setItemCode(String itemCode)
	{
		this.itemCode = itemCode;
	}

	/**
	 * @return the itemName
	 */
	public String getItemName()
	{
		return itemName;
	}

	/**
	 * @param itemName
	 *            the itemName to set
	 */
	public void setItemName(String itemName)
	{
		this.itemName = itemName;
	}

	/**
	 * @return the itemQuantity
	 */
	public int getItemQuantity()
	{
		return itemQuantity;
	}

	/**
	 * @param itemQuantity
	 *            the itemQuantity to set
	 */
	public void setItemQuantity(int itemQuantity)
	{
		this.itemQuantity = itemQuantity;
	}

	/**
	 * @return the subItems
	 */
	public SubItem[] getSubItems()
	{
		return subItems;
	}

	/**
	 * @param subItems
	 *            the subItems to set
	 */
	public void setSubItems(SubItem[] subItems)
	{
		this.subItems = subItems;
	}

	public void setAllSubItems(List<SubItem> lst)
	{
		this.subItems = new SubItem[lst.size()];
		int count = 0;
		Iterator<SubItem> itr = lst.iterator();
		while (itr.hasNext())
		{
			SubItem subItem = (SubItem) itr.next();
			subItems[count++] = subItem;
			subItem = null;
		}

	}

	public List<SubItem> getAllSubItems()
	{
		List<SubItem> lstSubItems = new ArrayList<SubItem>();
		for (int i = 0; i < subItems.length; i++)
		{
			lstSubItems.add(subItems[i]);
		}

		return lstSubItems;
	}

}
