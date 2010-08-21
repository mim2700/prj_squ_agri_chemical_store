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
 * File Name      : AdjustItemsAction.java
 * 
 * Date           : Nov 14, 2009
 * 
 */
package com.squ.agri.store.actions;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.squ.agri.store.StoreConstants;
import com.squ.agri.store.bo.Adjustment;
import com.squ.agri.store.bo.Department;
import com.squ.agri.store.bo.Item;
import com.squ.agri.store.dao.inHouse.ConsumeSubItemsDb;
import com.squ.agri.store.forms.AdjustItemsForm;
import com.squ.agri.store.users.User;

/**
 * @author Administrator
 * 
 */
public class AdjustItemsAction extends Action
{

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		AdjustItemsForm adjustForm = (AdjustItemsForm) form;

		List<Department> allDepartments = null;
		allDepartments = new Department().getAll();

		List<Adjustment> allAdjustments = new Adjustment().getAll();

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(StoreConstants.SESSION_USER);

		Item[] arrItem = new ConsumeSubItemsDb().itemsListFrom_DS(user
				.getDeptId(), "", "all_available", "");
		List<Item> allItems = Arrays.asList(arrItem);

		adjustForm.setUserRole(user.getRole().trim());

		if (user.getRole().trim().equalsIgnoreCase("Department_Store"))
		{

			adjustForm.setDep_Source(user.getDeptId());

		}

		request.setAttribute("allAdjustments", allAdjustments);
		request.setAttribute("allDepartments", allDepartments);
		request.setAttribute("allItems", allItems);

		return mapping.findForward("ShowAdjustments");
	}

}
