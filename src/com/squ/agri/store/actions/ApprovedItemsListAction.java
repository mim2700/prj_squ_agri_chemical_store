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
 * File Name      : ApprovedItemsListAction.java
 * 
 * Date           : Aug 14, 2009
 * 
 */
package com.squ.agri.store.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.squ.agri.store.StoreConstants;
import com.squ.agri.store.bo.Item;
import com.squ.agri.store.bo.RequestItems;
import com.squ.agri.store.forms.RequestItemsDetailForm;
import com.squ.agri.store.inHouseStore.InHouseFactory;
import com.squ.agri.store.users.User;

/**
 * @author Owner
 * 
 */
public class ApprovedItemsListAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(StoreConstants.SESSION_USER);

		RequestItemsDetailForm reqForm = (RequestItemsDetailForm) form;
		@SuppressWarnings("unused")
		RequestItems reqItems = (RequestItems) new InHouseFactory(
				StoreConstants.INHOUSE_ALLOCATION_ACCEPT_LIST)
				.inHouseOperation(user.getDeptId());
		Item[] newItems = reqItems.getNewItems();
		for (int i = 0; i < newItems.length; i++)
		{
			newItems[i].setDeptDestId(user.getDeptId());
		}
		reqForm.setNewItems(newItems);
		return mapping.findForward("showApprovedItemsList");
	}
}
