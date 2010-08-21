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
 * File Name      : StoreItemsDetailResultsAction.java
 * 
 * Date           : Aug 17, 2009
 * 
 */
package com.squ.agri.store.actions;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.squ.agri.store.StoreConstants;
import com.squ.agri.store.bo.Item;
import com.squ.agri.store.bo.Procurements;
import com.squ.agri.store.bo.SubItem;
import com.squ.agri.store.forms.ProcurementForm;
import com.squ.agri.store.process.procure.ProcureFactory;

/**
 * @author Administrator
 * 
 */
public class StoreItemsDetailResultsAction extends Action
{

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{

		ProcurementForm procurementForm = (ProcurementForm) form;

		Procurements procurements = new Procurements();
		procurements.copyFormBean(procurementForm);

		for (int i = 0; i < procurements.getItems().length; i++)
		{
			if (procurements.getItems()[i].getDeptDestId().trim()
					.equalsIgnoreCase("2201"))
			{
				int total = procurements.getItems()[i].getItemCentralStoreQty()
						+ procurements.getItems()[i].getItemQuantity();
				procurements.getItems()[i].setItemCentralStoreQty(total);
				procurements.getItems()[i].setItemQuantity(0);
			}

		}

		Boolean booResult = (Boolean) new ProcureFactory(procurements)
				.procurementOptions(StoreConstants.PROCURE_STORE);

		return mapping.findForward("showStoreItemsDetailResults");
	}

}
