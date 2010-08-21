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
 * File Name      : CheckItemDetailResultAction.java
 * 
 * Date           : Aug 16, 2009
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
import com.squ.agri.store.bo.Procurements;
import com.squ.agri.store.forms.ProcurementForm;
import com.squ.agri.store.process.procure.ProcureFactory;
import com.squ.agri.store.users.User;

/**
 * @author Administrator
 * 
 */
public class CheckItemDetailResultAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(StoreConstants.SESSION_USER);

		ProcurementForm procurementForm = (ProcurementForm) form;
		Procurements procurements = new Procurements();
		procurements.copyBean(procurementForm);

		procurements.setDeptSourceId(user.getDeptId());
		procurements.setGrnNo("testGrn");
		procurements.setProcureId("testPro");
		ProcureFactory procureFactory = new ProcureFactory(procurements);
		procureFactory.procurementOptions(StoreConstants.PROCURE_SEND_INFO);

		return mapping.findForward("showCheckItemDetailResult");
	}
}
