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
 * Package Name   : com.squ.agri.store.actions
 * File Name      : RequestedItemDetailAction.java
 * 
 * Date           : Aug 14, 2009
 * 
 */
package com.squ.agri.store.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.squ.agri.store.StoreConstants;
import com.squ.agri.store.bo.Item;
import com.squ.agri.store.bo.RequestItems;
import com.squ.agri.store.bo.SubItem;
import com.squ.agri.store.forms.RequestItemsDetailForm;
import com.squ.agri.store.inHouseStore.InHouseFactory;

/**
 * @author Owner
 * 
 */
public class RequestedItemDetailAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		RequestItemsDetailForm reqForm = (RequestItemsDetailForm) form;
		String deptId = request.getParameter("deptId");
		@SuppressWarnings("unused")
		RequestItems reqItems = (RequestItems) new InHouseFactory(
				StoreConstants.INHOUSE_ALLOCATION_AVIALABLE_LIST)
				.inHouseOperation((String) deptId);

		Item[] totalItems = reqForm.getOldItems();
		Item[] newItems = reqItems.getNewItems();

		Item[] adjustedItems = getItemsAdjusted(totalItems, newItems,deptId);

		reqForm.setAdjustedItems(adjustedItems);

		return mapping.findForward("showrequestedItemDetail");
	}

	/**
	 * 
	 * @param oldItems
	 * @param newItems
	 * @return
	 */
	private Item[] getItemsAdjusted(Item[] totalItems, Item[] newItems,String deptId)
	{
		int lenItemsResult	=	0;
		
/* Fill array with only department specific Items only -- start of the code*/		
		for (int len=0; len< totalItems.length; len++)
		{
			if (totalItems[len].getDeptDestId().equals(deptId))
			{
				lenItemsResult = lenItemsResult + 1;
			}
		}
		
		Item[] itemsResult = new Item[lenItemsResult];
		Item[] oldItems		=	new Item[lenItemsResult];
		int arrcount = 0;
		for (int x=0; x<totalItems.length; x++)
		{
			if (totalItems[x].getDeptDestId().equals(deptId))
			{
				oldItems[arrcount++]=totalItems[x];
			}
		}
		
/*Fill array with only department specific Items only -- end of the code*/
		
		
		if (oldItems != null)
		{
			if (oldItems.length != 0)
			{
				itemsResult = new Item[oldItems.length];
			}
		}

		for (int i = 0; i < oldItems.length; i++)
		{
			Item oldItem = new Item();
			oldItem.copyBean(oldItems[i]);
			if(oldItem.getDeptDestId().equals(deptId))
			{
				itemsResult[i] = new Item();
				itemsResult[i].copyBean(oldItem);
					for (int j = 0; j < newItems.length; j++)
					{
						Item newItem = newItems[j];
						if (oldItem.getItemCode().equals(newItem.getItemCode()))
						{
							int requestedQuantity 	= oldItem.getItemQuantity();
							SubItem[] subItemsNew = newItem.getSubItems();
							List<SubItem> lstSubItemsTemp = new ArrayList<SubItem>();
							int qtyRemaining = requestedQuantity;
		
							for (int x = 0; x < subItemsNew.length; x++)
							{
								SubItem subItemNew = subItemsNew[x];
								SubItem subItemAdjusted = new SubItem();
		
								int qtyAvialable = subItemNew.getQtyAvailable();
								
								if (qtyRemaining > qtyAvialable)
								{
									if (qtyRemaining <= requestedQuantity)
									{
										subItemAdjusted.copyBean(subItemNew);
										subItemAdjusted.setQtyAdded(0);
										subItemAdjusted.setQtyConsumed(0);
										lstSubItemsTemp.add(subItemAdjusted);
										qtyRemaining = qtyRemaining - qtyAvialable;
										qtyAvialable = 0;
									}
									else
									{
										if (qtyRemaining >= 0)
										{
											subItemAdjusted.copyBean(subItemNew);
											subItemAdjusted
													.setQtyAvailable(qtyAvialable);
											lstSubItemsTemp.add(subItemAdjusted);
											qtyRemaining = qtyRemaining - qtyAvialable;
											qtyAvialable = 0;
										}
									}
								}
								else
								{
									if (qtyRemaining > 0)
									{
										subItemAdjusted.copyBean(subItemNew);
										subItemAdjusted.setQtyAvailable(qtyRemaining);
										subItemAdjusted.setQtyAdded(0);
										subItemAdjusted.setQtyConsumed(0);
										lstSubItemsTemp.add(subItemAdjusted);
										
										qtyAvialable	=	qtyAvialable - requestedQuantity;
										subItemNew.setQtyAvailable(qtyAvialable);
										qtyRemaining = 0;
									}
									break;
								}
							}
							SubItem[] subItemsTemp = new SubItem[lstSubItemsTemp.size()];
							Iterator<SubItem> itrSubItem = lstSubItemsTemp.iterator();
							int countSubItems = 0;
							while (itrSubItem.hasNext())
							{
								SubItem subItem = itrSubItem.next();
								subItemsTemp[countSubItems++] = subItem;
							}
							itemsResult[i].setSubItems(subItemsTemp);
						}
					}
		} //end of If (comparing deptId)
		}
		return itemsResult;
	}

}
