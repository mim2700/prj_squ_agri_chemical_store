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
 * File Name      : RequestedItemsIssueAction.java
 * 
 * Date           : Dec 2, 2009
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
 * @author Administrator
 * 
 */
public class RequestedItemsIssueAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		RequestItemsDetailForm reqForm = (RequestItemsDetailForm) form;
		RequestItems reqItems = new RequestItems();
		reqItems.copyBean(reqForm);
		InHouseFactory factory = new InHouseFactory(
				StoreConstants.INHOUSE_ALLOCATION_ISSUE_ITEMS);
		factory.inHouseOperation(reqItems);
		return mapping.findForward("showrequestedItemIssueSuccess");
	}
}
