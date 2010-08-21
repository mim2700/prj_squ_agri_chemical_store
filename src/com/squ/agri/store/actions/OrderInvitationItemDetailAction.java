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
 * File Name      : OrderInvitationItemDetailAction.java
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
import org.apache.struts.action.DynaActionForm;

import com.squ.agri.store.bo.PurchaseOrder;
import com.squ.agri.store.process.procure.ProcureFactory;

/**
 * @author Owner
 * 
 */
public class OrderInvitationItemDetailAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		String prnNo = null;
		String lpoNo = null;
		String grnNo = null;

		PurchaseOrder purchaseOrder = null;

		DynaActionForm dynaFormChkItemDetail = (DynaActionForm) form;
		prnNo = dynaFormChkItemDetail.get("prnNo").toString();
		lpoNo = dynaFormChkItemDetail.get("lpoNo").toString();
		grnNo = dynaFormChkItemDetail.get("grnNo").toString();

		ProcureFactory procureFactory = new ProcureFactory(prnNo, lpoNo, grnNo);
		purchaseOrder = procureFactory.getItems();

		request.setAttribute("purchaseOrder", purchaseOrder);

		return mapping.findForward("showOrderInvitationItemDetail");
	}

}
