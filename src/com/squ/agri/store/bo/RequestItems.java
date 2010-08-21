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
 * File Name      : RequestItems.java
 * 
 * Date           : Aug 18, 2009
 * 
 */
package com.squ.agri.store.bo;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

/**
 * @author Administrator
 * 
 */
public class RequestItems
{
	private String deptReq; // Department who make the request
	private String deptApproved; // Department who approve the request
	private String itemCode;
	private String itemName;
	private int itemQuantity;
	private int itemQuantityAvl; // Quantity available

	private Item[] oldItems;// = null;
	private Item[] newItems;// = null;
	private Item[] adjustedItems;// = null;

	private String bttnAddToCart = null;

	/**
	 * @return the deptReq
	 */
	public String getDeptReq()
	{
		return deptReq;
	}

	/**
	 * @param deptReq
	 *            the deptReq to set
	 */
	public void setDeptReq(String deptReq)
	{
		this.deptReq = deptReq;
	}

	/**
	 * @return the deptApproved
	 */
	public String getDeptApproved()
	{
		return deptApproved;
	}

	/**
	 * @param deptApproved
	 *            the deptApproved to set
	 */
	public void setDeptApproved(String deptApproved)
	{
		this.deptApproved = deptApproved;
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
	 * @return the oldItems
	 */
	public Item[] getOldItems()
	{
		return oldItems;
	}

	/**
	 * @param oldItems
	 *            the oldItems to set
	 */
	public void setOldItems(Item[] oldItems)
	{
		this.oldItems = oldItems;
	}

	/**
	 * @return the newItems
	 */
	public Item[] getNewItems()
	{
		return newItems;
	}

	/**
	 * @param newItems
	 *            the newItems to set
	 */
	public void setNewItems(Item[] newItems)
	{
		this.newItems = newItems;
	}

	/**
	 * @return the adjustedItems
	 */
	public Item[] getAdjustedItems()
	{
		return adjustedItems;
	}

	/**
	 * @param adjustedItems
	 *            the adjustedItems to set
	 */
	public void setAdjustedItems(Item[] adjustedItems)
	{
		this.adjustedItems = adjustedItems;
	}

	/**
	 * @return the itemQuantityAvl
	 */
	public int getItemQuantityAvl()
	{
		return itemQuantityAvl;
	}

	/**
	 * @param itemQuantityAvl
	 *            the itemQuantityAvl to set
	 */
	public void setItemQuantityAvl(int itemQuantityAvl)
	{
		this.itemQuantityAvl = itemQuantityAvl;
	}

	private Item[] items = null;

	/**
	 * @return the items
	 */
	public Item[] getItems()
	{
		return items;
	}

	/**
	 * @param items
	 *            the items to set
	 */
	public void setItems(Item[] items)
	{
		this.items = items;
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

	/**
	 * @return the bttnAddToCart
	 */
	public String getBttnAddToCart()
	{
		return bttnAddToCart;
	}

	/**
	 * @param bttnAddToCart
	 *            the bttnAddToCart to set
	 */
	public void setBttnAddToCart(String bttnAddToCart)
	{
		this.bttnAddToCart = bttnAddToCart;
	}

}
