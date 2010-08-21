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
 * File Name      : OrderAcceptanceSubItemDetailResultAction.java
 * 
 * Date           : Oct 18, 2009
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
import com.squ.agri.store.forms.StoreItemsDetailForm;
import com.squ.agri.store.process.procure.ProcureFactory;

/**
 * @author Administrator
 * 
 */
public class OrderAcceptanceSubItemDetailResultAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		@SuppressWarnings("unused")
		StoreItemsDetailForm storeItemsDetailForm = (StoreItemsDetailForm) form;

		ProcureFactory procureFactory = new ProcureFactory(storeItemsDetailForm
				.getAllSubItems());
		procureFactory
				.procurementOptions(StoreConstants.PROCURE_STORE_SUBITEMS);

		return mapping.findForward("showStoreSubItemsDetailResults");
	}
}
