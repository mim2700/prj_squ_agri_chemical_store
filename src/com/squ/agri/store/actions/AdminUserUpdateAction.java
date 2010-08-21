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
 * File Name      : AdminUserUpdateAction.java
 * 
 * Date           : Sep 2, 2009
 * 
 */
package com.squ.agri.store.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.hibernate.dialect.Sybase11Dialect;

import com.squ.agri.store.StoreConstants;
import com.squ.agri.store.bo.Department;
import com.squ.agri.store.bo.PurchaseOrder;
import com.squ.agri.store.forms.LoginForm;
import com.squ.agri.store.process.procure.ProcureFactory;
import com.squ.agri.store.users.User;
import com.squ.agri.store.users.UserFactory;
import com.squ.agri.store.users.UserRole;

/**
 * @author Administrator
 * 
 */
public class AdminUserUpdateAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{

		List<Department> allDepartments = null;
		allDepartments = new Department().getAll();
		request.setAttribute("allDepartments", allDepartments);

		List<User> allUsers = null;
		allUsers = new User().getAll();
		request.setAttribute("allUsers", allUsers);

		List<UserRole> allRoles = null;
		allRoles = new UserRole().getAllRoles();

		request.setAttribute("allRoles", allRoles);

		LoginForm addUser = (LoginForm) form;

		addUser.setUid("0");
		addUser.setName("");
		addUser.setPwd("");
		addUser.setRole("0");
		addUser.setDeptId("0");
		addUser.setActive(false);

		return mapping.findForward("adminUserUpdate");
	}
}
