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
 * File Name      : StoreItemsDetailForm.java
 * 
 * Date           : Aug 17, 2009
 * 
 */
package com.squ.agri.store.forms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.squ.agri.store.bo.Item;
import com.squ.agri.store.bo.Measurment;
import com.squ.agri.store.bo.SubItem;

/**
 * @author Administrator
 * 
 */
public class StoreItemsDetailForm extends ActionForm
{
	private String uid;// = null; //user id -- keeping user id to avoid session
	// problem in iframe
	private String procId = null;
	private String prnNo = null;
	private String itemCode;
	private String itemName;
	private int itemQuantity; // Total Item Quantity
	private int itemDeptQty; // Quantity assigned to Department
	private int itemCentralStoreQty; // Quantity assigned to Central Store
	private String type;
	private String grade;
	private String safety;
	private String deptDestId;
	private SubItem[] subItems;
	private boolean multipleSubItem = false;
	private int totalSubItems = 0;

	private String measurment = null;
	private String indexNo = null;

	/**
	 * @return the uid
	 */
	public String getUid()
	{
		return uid;
	}

	/**
	 * @param uid
	 *            the uid to set
	 */
	public void setUid(String uid)
	{
		this.uid = uid;
	}

	/**
	 * @return the procId
	 */
	public String getProcId()
	{
		return procId;
	}

	/**
	 * @param procId
	 *            the procId to set
	 */
	public void setProcId(String procId)
	{
		this.procId = procId;
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
	 * @return the itemDeptQty
	 */
	public int getItemDeptQty()
	{
		return itemDeptQty;
	}

	/**
	 * @param itemDeptQty
	 *            the itemDeptQty to set
	 */
	public void setItemDeptQty(int itemDeptQty)
	{
		this.itemDeptQty = itemDeptQty;
	}

	/**
	 * @return the itemCentralStoreQty
	 */
	public int getItemCentralStoreQty()
	{
		return itemCentralStoreQty;
	}

	/**
	 * @param itemCentralStoreQty
	 *            the itemCentralStoreQty to set
	 */
	public void setItemCentralStoreQty(int itemCentralStoreQty)
	{
		this.itemCentralStoreQty = itemCentralStoreQty;
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

	/**
	 * @return the safety
	 */
	public String getSafety()
	{
		return safety;
	}

	/**
	 * @param safety
	 *            the safety to set
	 */
	public void setSafety(String safety)
	{
		this.safety = safety;
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
	public void setDeptDestId(String deptDestId)
	{
		this.deptDestId = deptDestId;
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

	/**
	 * @return the type
	 */
	public String getType()
	{
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type)
	{
		this.type = type;
	}

	/**
	 * @return the totalSubItems
	 */
	public int getTotalSubItems()
	{
		return totalSubItems;
	}

	/**
	 * @param totalSubItems
	 *            the totalSubItems to set
	 */
	public void setTotalSubItems(int totalSubItems)
	{
		this.totalSubItems = totalSubItems;
	}

	public Item getItem()
	{
		Item item = new Item();
		item.setProcureId(procId);
		item.setItemCode(itemCode);
		item.setItemName(itemName);
		item.setItemQuantity(itemQuantity);
		return item;
	}

	/**
	 * @return the multipleSubItem
	 */
	public boolean isMultipleSubItem()
	{
		return multipleSubItem;
	}

	/**
	 * @param multipleSubItem
	 *            the multipleSubItem to set
	 */
	public void setMultipleSubItem(boolean multipleSubItem)
	{
		this.multipleSubItem = multipleSubItem;
	}

	/**
	 * @return the measurmentId
	 */
	public String getMeasurment()
	{
		return measurment;
	}

	/**
	 * @param measurmentId
	 *            the measurmentId to set
	 */
	public void setMeasurment(String measurment)
	{
		this.measurment = measurment;
	}

	/**
	 * @return the indexNo
	 */
	public String getIndexNo()
	{
		return indexNo;
	}

	/**
	 * @param indexNo
	 *            the indexNo to set
	 */
	public void setIndexNo(String indexNo)
	{
		this.indexNo = indexNo;
	}

	public void setAllSubItems(List<SubItem> lst)
	{
		if (isMultipleSubItem())
			this.subItems = new SubItem[1];
		else
			this.subItems = new SubItem[lst.size()];
		int count = 0;
		Iterator<SubItem> itr = lst.iterator();
		while (itr.hasNext())
		{
			SubItem subItem = (SubItem) itr.next();
			subItems[count++] = subItem;
			subItem = null;

			if (isMultipleSubItem())
				break;
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
