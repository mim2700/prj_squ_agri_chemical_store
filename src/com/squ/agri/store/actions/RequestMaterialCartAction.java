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
 * File Name      : RequestMaterialCartAction.java
 * 
 * Date           : Nov 6, 2009
 * 
 */
package com.squ.agri.store.actions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.MessageResources;

import com.squ.agri.store.StoreConstants;
import com.squ.agri.store.bo.Item;
import com.squ.agri.store.bo.RequestItems;
import com.squ.agri.store.forms.RequestItemsDetailForm;
import com.squ.agri.store.inHouseStore.InHouseFactory;
import com.squ.agri.store.users.User;

/**
 * @author Administrator
 * 
 */
public class RequestMaterialCartAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		ActionErrors actionErrors = new ActionErrors();
		if (isTokenValid(request))
		{
			RequestItemsDetailForm reqForm = (RequestItemsDetailForm) form;
			if (reqForm.getBttnAddToCart() == null)
			{
				return mapping.findForward("showRequestMaterialCart");
			}
			reqForm.setBttnAddToCart(null);

			String itemCode = reqForm.getItemCode();
			int itemQty = reqForm.getItemQuantity();

			Item[] oldItems = reqForm.getOldItems();
			Item[] adjustedItem = reqForm.getAdjustedItems();
			Item[] newItems = reqForm.getNewItems();
			//		
			Map<String, Item> mapOldItems = convertMap(oldItems);
			Map<String, Item> mapNewItems = convertMap(newItems);
			// Map<String,Item> mapAdjustedItems =
			// convertMap(reqForm.getAdjustedItems());

			newItems = getNewItems(itemCode, itemQty, mapNewItems, mapOldItems,
					request);
			mapNewItems = convertMap(newItems);
			reqForm.setNewItems(newItems);
			adjustedItem = getAdjustedItems(mapNewItems, mapOldItems);
			reqForm.setAdjustedItems(adjustedItem);
		}
		resetToken(request);
		// saveErrors(request, actionErrors);
		return mapping.findForward("showRequestMaterialCart");

	}

	private Map<String, Item> convertMap(Item[] items)
	{

		Map<String, Item> map = null;
		if (items != null)
		{
			if (items.length != 0)
			{
				map = new HashMap<String, Item>();
			}

			for (int i = 0; i < items.length; i++)
			{
				map.put(items[i].getItemCode(), items[i]);
			}
		}
		return map;
	}

	public Item[] getNewItems(String itemCode, int itemQty,
			Map<String, Item> mapNewItems, Map<String, Item> mapOldItems,
			HttpServletRequest request)
	{
		ActionErrors actionErrors = new ActionErrors();
		Item[] arrResultItems = null;
		Map<String, Item> resultMap = new HashMap<String, Item>();
		Item itemTemp = mapOldItems.get(itemCode);
		Item tmpItem = new Item();
		tmpItem.setItemCode(itemTemp.getItemCode());
		tmpItem.setItemName(itemTemp.getItemName());
		tmpItem.setItemQuantity(itemQty);

		if (mapNewItems == null)
		{
			resultMap.put(itemCode, tmpItem);
		}
		else
		{

			if (mapNewItems.get(itemCode) == null)
			{
				resultMap = mapNewItems;
				resultMap.put(itemCode, tmpItem);
			}
			else
			{
				resultMap = mapNewItems;
				Item tempNewItem = mapNewItems.get(itemCode);
				int qty = tempNewItem.getItemQuantity() + itemQty;
				tempNewItem.setItemQuantity(qty);
				resultMap.remove(itemCode);
				resultMap.put(itemCode, tempNewItem);
				if (tempNewItem.getItemQuantity() > itemTemp.getItemQuantity())
				{
					actionErrors
							.add(
									"oldItems",
									new ActionMessage(
											"error.inhouse.department.requestForm.itemQuantityAvl.notLessThanRequestedItems"));
				}
				saveErrors(request, actionErrors);
			}
		}
		Set<Map.Entry<String, Item>> setItems = resultMap.entrySet();
		arrResultItems = new Item[setItems.size()];
		int count = 0;
		Iterator<Map.Entry<String, Item>> itr = setItems.iterator();
		while (itr.hasNext())
		{
			Map.Entry<String, Item> me = itr.next();
			arrResultItems[count++] = me.getValue();
		}

		return arrResultItems;
	}

	public Item[] getAdjustedItems(Map<String, Item> mapNewItems,
			Map<String, Item> mapOldItems)
	{
		Item[] arrAdjustedItems = null;
		Map<String, Item> mapAdjusted = new HashMap<String, Item>();
		if (mapNewItems == null)
		{
			mapAdjusted = mapOldItems;
		}
		else
		{
			Set<String> keyOld = mapOldItems.keySet();
			Iterator<String> itrOld = keyOld.iterator();
			while (itrOld.hasNext())
			{
				Item tmpItemOld = mapOldItems.get(itrOld.next());
				Item tmpItemNew = mapNewItems.get(tmpItemOld.getItemCode());
				if (tmpItemNew == null)
				{
					mapAdjusted.put(tmpItemOld.getItemCode(), tmpItemOld);
				}
				else
				{
					int tmpNewItemQty = tmpItemNew.getItemQuantity();
					int tmpOldItemQty = tmpItemOld.getItemQuantity();

					if (tmpOldItemQty > tmpNewItemQty)
					{
						Item tmpItemAdjusted = new Item();
						tmpItemAdjusted.copyBean(tmpItemNew);
						tmpItemAdjusted.setItemQuantity(tmpOldItemQty
								- tmpNewItemQty);
						mapAdjusted.put(tmpItemAdjusted.getItemCode(),
								tmpItemAdjusted);
					}

					// if(tmpNewItemQty > tmpOldItemQty)
					// {
					//						
					// }

				}
			}
		}

		int count = 0;
		Set<Map.Entry<String, Item>> setAdjustedME = mapAdjusted.entrySet();
		arrAdjustedItems = new Item[setAdjustedME.size()];
		Iterator<Map.Entry<String, Item>> itrAdjustME = setAdjustedME
				.iterator();
		while (itrAdjustME.hasNext())
		{
			Map.Entry<String, Item> me = itrAdjustME.next();
			arrAdjustedItems[count++] = me.getValue();

		}

		return arrAdjustedItems;
	}

	/*
	 * public Item[] getNewItems(String itemCode, int itemQty, Item[] newItems)
	 * { Item[] resultItems = null; if(newItems == null) { resultItems = new
	 * Item[1]; Item item = new Item(); item.setItemCode(itemCode);
	 * item.setItemQuantity(itemQty); resultItems[0]=item; } else { boolean find
	 * = false; for(int i=0; i<newItems.length; i++) { Item item = newItems[i];
	 * if(item.getItemCode().equals(itemCode)) { int tmpItmQty =
	 * item.getItemQuantity()+itemQty; item.setItemQuantity(tmpItmQty);
	 * newItems[i] = item; find = true; break; } }
	 * 
	 * if (find) //Item already available { resultItems = newItems; } else { int
	 * count = 0; resultItems = new Item[newItems.length + 1];
	 * while(count<newItems.length) { resultItems[count] = newItems[count];
	 * count++; } Item item = new Item(); item.setItemCode(itemCode);
	 * item.setItemQuantity(itemQty); resultItems[count]=item; }
	 * 
	 * } return resultItems;
	 * 
	 * }
	 * 
	 * 
	 * public Item[] getAdjustedItems(Item[] newItems, Item[] oldItems) { Item[]
	 * resultItems = null; if(newItems == null) { resultItems = oldItems; } else
	 * { if((oldItems.length - newItems.length)== 0) { resultItems = null; }
	 * else { int count = 0; boolean found = false; for(int i=0;
	 * i<oldItems.length; i++) { for(int j=0; j< newItems.length; j++) {
	 * if(newItems[j].getItemCode().equals(oldItems[i].getItemCode())) { found =
	 * true; if(oldItems[i].getItemQuantity()>newItems[j].getItemQuantity()) {
	 * count++; } } else { found = false; } } if (found == false) { count ++; }
	 * 
	 * } resultItems = new Item[count]; }
	 * 
	 * int count2 = 0; boolean found2 = false; for(int i=0; i<oldItems.length;
	 * i++) { for(int j=0; j< newItems.length; j++) {
	 * if(newItems[j].getItemCode().equals(oldItems[i].getItemCode())) { found2
	 * = true; if(oldItems[i].getItemQuantity()>newItems[j].getItemQuantity()) {
	 * resultItems[count2]=oldItems[i];
	 * resultItems[count2].setItemQuantity(oldItems[i].getItemQuantity() -
	 * newItems[j].getItemQuantity()); count2++; } } else { found2 = false; }
	 * }//end of for if (found2 == false) { resultItems[count2]=oldItems[i];
	 * count2 ++; } }//end of for
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * return resultItems; }
	 */

}
