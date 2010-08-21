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
 * File Name      : RequestedItemsListAction.java
 * 
 * Date           : Aug 14, 2009
 * 
 */
package com.squ.agri.store.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.squ.agri.store.StoreConstants;
import com.squ.agri.store.bo.RequestItems;
import com.squ.agri.store.forms.RequestItemsDetailForm;
import com.squ.agri.store.inHouseStore.InHouseFactory;

/**
 * @author Owner
 * 
 */
public class RequestedItemsListAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		RequestItemsDetailForm reqForm = (RequestItemsDetailForm) form;
		RequestItems requestItems = (RequestItems) new InHouseFactory(
				StoreConstants.INHOUSE_ALLOCATION_REQUEST_LIST)
				.inHouseOperation(null);

		reqForm.setOldItems(requestItems.getOldItems());
		return mapping.findForward("showRequestedItemsList");
	}

}
