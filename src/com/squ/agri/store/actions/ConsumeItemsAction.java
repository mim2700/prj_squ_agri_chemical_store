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
 * File Name      : ConsumeItemsAction.java
 * 
 * Date           : Nov 7, 2009
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
import com.squ.agri.store.bo.Department;
import com.squ.agri.store.users.User;

/**
 * @author Administrator
 * 
 */
public class ConsumeItemsAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(StoreConstants.SESSION_USER);

		Department department = new Department();

		department.setDeptId(user.getDeptId());
		department.setDeptName(department.getDeptName(user.getDeptId()));

		request.setAttribute("department", department);

		return mapping.findForward("ShowConsumption");
	}

}
