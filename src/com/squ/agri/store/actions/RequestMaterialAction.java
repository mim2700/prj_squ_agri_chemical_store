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
 * File Name      : RequestMaterialAction.java
 * 
 * Date           : Nov 3, 2009
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
import com.squ.agri.store.forms.RequestItemsDetailForm;
import com.squ.agri.store.inHouseStore.InHouseFactory;
import com.squ.agri.store.users.User;

/**
 * @author Administrator
 * 
 */
public class RequestMaterialAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		saveToken(request);
		RequestItemsDetailForm itemForm = (RequestItemsDetailForm) form;
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(StoreConstants.SESSION_USER);
		
		InHouseFactory inHouseFactory = new InHouseFactory(StoreConstants.INHOUSE_MATERIAL_REQUEST);
		
		Item[] oldItems = (Item[]) inHouseFactory.inHouseOperation(user.getDeptId());
		
		if (itemForm.getOldItems() == null)
		{

			itemForm.setOldItems(oldItems);
			itemForm.setAdjustedItems(oldItems);

		}
		return mapping.findForward("showRequestMaterial");
	}
}
