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
 * File Name      : RequestItemsDetailForm.java
 * 
 * Date           : Aug 18, 2009
 * 
 */
package com.squ.agri.store.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

import com.squ.agri.store.bo.Item;

/**
 * @author Administrator
 * 
 */
public class RequestItemsDetailForm extends ValidatorForm
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9175915064392864752L;
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

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request)
	{
		ActionErrors actionErrors = new ActionErrors();
		if (bttnAddToCart != null
				&& (bttnAddToCart.equals("Add to cart") || bttnAddToCart
						.equals("Submit the Request")))
		{
			if (itemCode != null)
			{
				if (itemCode.equals("0"))
				{
					actionErrors
							.add(
									"itemCode",
									new ActionMessage(
											"error.inhouse.department.requestForm.itemCode.notNull"));
				}
			}

			if (oldItems != null)
			{
				if (oldItems.length != 0)
				{
					for (int x = 0; x < oldItems.length; x++)
					{
						if (oldItems[x].getItemCode().equals(itemCode))
						{
							if (oldItems[x].getItemQuantity() < itemQuantity)
							{
								actionErrors
										.add(
												"oldItems",
												new ActionMessage(
														"error.inhouse.department.requestForm.itemQuantityAvl.notLessThanRequestedItems"));
							}
						}
					}
				}
			}

			if (oldItems != null && newItems != null)
			{
				if (oldItems.length != 0)
				{
					for (int i = 0; i < oldItems.length; i++)
					{
						if (oldItems[i].getItemCode().equals(itemCode))
						{
							if (oldItems[i].getItemQuantity() < itemQuantity)
							{
								actionErrors
										.add(
												"oldItems",
												new ActionMessage(
														"error.inhouse.department.requestForm.itemQuantityAvl.notLessThanRequestedItems"));
							}
							for (int j = 0; j < newItems.length; j++)
							{
								if (oldItems[i].getItemCode().equals(
										newItems[j].getItemCode()))
								{
									if (oldItems[i].getItemQuantity() < newItems[j]
											.getItemQuantity())
									{
										actionErrors
												.add(
														"oldItems",
														new ActionMessage(
																"error.inhouse.department.requestForm.itemQuantityAvl.notLessThanRequestedItems"));
									}
									
									if(bttnAddToCart.equals("Add to cart"))
										if (oldItems[i].getItemQuantity() < newItems[j]
												.getItemQuantity()
												+ itemQuantity)
										{
											actionErrors
													.add(
															"oldItems",
															new ActionMessage(
																	"error.inhouse.department.requestForm.itemQuantityAvl.notLessThanRequestedItems"));
										}
								}
							}
						}
					}
				}
			}

			if ((itemQuantity < 0))
			{
				actionErrors
						.add(
								"itemQuantity",
								new ActionMessage(
										"error.inhouse.department.requestForm.qtyRequested.aboveZero"));
			}

		}
		return actionErrors;
	}

	// public void reset(ActionMapping mapping, HttpServletRequest request) {
	// // reset properties
	//
	// }

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
