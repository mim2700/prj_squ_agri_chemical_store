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
 * File Name      : ConsumeItemsResultsAction.java
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

import com.squ.agri.store.StoreConstants;
import com.squ.agri.store.bo.Item;
import com.squ.agri.store.bo.SubItem;
import com.squ.agri.store.dao.inHouse.ConsumeSubItemsDb;
import com.squ.agri.store.forms.ConsumeItemForm;
import com.squ.agri.store.users.User;
import com.squ.agri.store.bo.Procurements;

/**
 * @author Administrator
 * 
 */
public class ConsumeItemsResultsAction extends Action
{

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(StoreConstants.SESSION_USER);

		ConsumeItemForm itemForm = (ConsumeItemForm) form;
		SubItem[] arrItem = itemForm.getSubItems();

		Procurements procurements = new Procurements();
		Item[] items = new Item[1];

		items[0] = new Item();

		items[0].setSubItems(arrItem);
		items[0].setDeptDestId(user.getDeptId());

		procurements.setItems(items);

		procurements.setUserRole(user.getRole());

		new ConsumeSubItemsDb().inHouseOperation(procurements);

		return mapping.findForward("showConsumeItemsResults");
	}
}
