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
 * Package Name   : com.squ.agri.store.actions.reports
 * File Name      : RptTransactionDtAction.java
 * 
 * Date           : Aug 18, 2009
 * 
 */
package com.squ.agri.store.actions.reports;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author Administrator
 * 
 */
public class RptTransactionDtAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		return mapping.findForward("showInvitationItemsResults");
	}
}
