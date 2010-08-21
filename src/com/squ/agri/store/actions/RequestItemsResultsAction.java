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
 * File Name      : RequestItemsResultsAction.java
 * 
 * Date           : Aug 18, 2009
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
import org.apache.struts.util.MessageResources;

import com.squ.agri.store.StoreConstants;
import com.squ.agri.store.bo.RequestItems;
import com.squ.agri.store.forms.RequestItemsDetailForm;
import com.squ.agri.store.inHouseStore.InHouseFactory;
import com.squ.agri.store.users.User;

/**
 * @author Administrator
 * 
 */
public class RequestItemsResultsAction extends Action
{

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		RequestItemsDetailForm reqForm = (RequestItemsDetailForm) form;
		MessageResources messageResources = getResources(request);
		HttpSession session = request.getSession();
		RequestItems reqItems = new RequestItems();

		User user = (User) session.getAttribute(StoreConstants.SESSION_USER);

		reqForm.setDeptApproved(messageResources
				.getMessage(StoreConstants.MSG_CENTRAL_STORE_ID));
		reqForm.setDeptReq(user.getDeptId());

		reqItems.copyBean(reqForm);
		InHouseFactory inHouseFactory = new InHouseFactory(
				StoreConstants.INHOUSE_MATERIAL_REQUEST_ADD);
		Object objResult = inHouseFactory.inHouseOperation(reqItems);

		reqForm.setAdjustedItems(null);
		reqForm.setBttnAddToCart(null);
		reqForm.setDeptApproved("0");
		reqForm.setDeptReq("0");
		reqForm.setItemCode(null);
		reqForm.setItemName(null);
		reqForm.setItemQuantity(0);
		reqForm.setItemQuantityAvl(0);
		reqForm.setItems(null);
		reqForm.setMultipartRequestHandler(null);
		reqForm.setNewItems(null);
		reqForm.setOldItems(null);

		return mapping.findForward("showRequestItemsResults");
	}

}
