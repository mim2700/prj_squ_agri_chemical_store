package com.squ.agri.store.bo;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;

import com.squ.agri.store.dao.DBConstants;
import com.squ.agri.store.dao.inHouse.ConsumeSubItemsDb;
import com.squ.agri.store.dbUtil.HibernateUtil;

public class Item implements Serializable
{
	private String procureId;
	private String itemCode;
	private String itemName;
	private int itemQuantity = 0; // Total Item Quantity
	private int itemDeptQty = 0; // Quantity assigned to Department
	private int itemCentralStoreQty = 0; // Quantity assigned to Central Store
	private String grade;
	private String type;
	private String safety;
	private String measurment;
	private String deptDestId;
	private SubItem[] subItems;
	private PurchaseOrder purchaseOrder;
	private boolean multipleSubItem;

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
	 * @return the measurment
	 */
	public String getMeasurment()
	{
		return measurment;
	}

	/**
	 * @param measurment
	 *            the measurment to set
	 */
	public void setMeasurment(String measurment)
	{
		this.measurment = measurment;
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
	 * @return the purchaseOrder
	 */
	public PurchaseOrder getPurchaseOrder()
	{
		return purchaseOrder;
	}

	/**
	 * @param purchaseOrder
	 *            the purchaseOrder to set
	 */
	public void setPurchaseOrder(PurchaseOrder purchaseOrder)
	{
		this.purchaseOrder = purchaseOrder;
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

	public boolean isMultipleSubItem(String itemCode)
	{
		Item item = getItemById(itemCode);

		return item.isMultipleSubItem();
	}

	public Item getItemById(String itemCode)
	{

		return (Item) new ConsumeSubItemsDb().getItemById(itemCode);
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

	public void sortSubItems()
	{
		Arrays.sort(subItems);
	}

	public void reverseSortSubItem()
	{
		Arrays.sort(subItems, Collections.reverseOrder());
	}

}
