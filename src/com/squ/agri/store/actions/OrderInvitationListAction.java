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
 * File Name      : OrderInvitationListAction.java
 * 
 * Date           : Aug 14, 2009
 * 
 */
package com.squ.agri.store.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.squ.agri.store.StoreConstants;
import com.squ.agri.store.bo.Procurements;
import com.squ.agri.store.process.procure.ProcureFactory;
import com.squ.agri.store.users.User;

/**
 * @author Owner
 * 
 */
public class OrderInvitationListAction extends Action
{
	@SuppressWarnings("unchecked")
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		Procurements procurements = new Procurements();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(StoreConstants.SESSION_USER);
		procurements.setDeptDestId(user.getDeptId());

		Object objList = new ProcureFactory(procurements)
				.procurementOptions(StoreConstants.PROCURE_VIEW_INFO);
		List<Procurements> lstProcurementInfo = (List<Procurements>) objList;

		request.setAttribute("lstProcurementInfo", lstProcurementInfo);
		return mapping.findForward("showOrderInvitationList");
	}

}
