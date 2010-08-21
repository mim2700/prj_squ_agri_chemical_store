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
 * File Name      : AdminUserAddResultsAction.java
 * 
 * Date           : Oct 4, 2009
 * 
 */
package com.squ.agri.store.actions;

import java.security.GeneralSecurityException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.squ.agri.store.StoreConstants;
import com.squ.agri.store.bo.Department;
import com.squ.agri.store.encrypt.GenerateMsgDigest;
import com.squ.agri.store.forms.LoginForm;
import com.squ.agri.store.users.User;
import com.squ.agri.store.users.UserFactory;
import com.squ.agri.store.users.UserRole;

/**
 * @author Administrator
 * 
 */
public class AdminUserAddResultsAction extends Action
{

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		LoginForm addUser = (LoginForm) form;

		User user = new User();
		user.copyBean(addUser);

		GenerateMsgDigest msgDigest = new GenerateMsgDigest(addUser.getPwd());

		try
		{
			user.setPwd(msgDigest.getEncryptPassword());
		}
		catch (GeneralSecurityException e)
		{
			e.printStackTrace();
		}

		UserFactory usrFactry = new UserFactory(user);
		usrFactry.getOperation(user, StoreConstants.USER_ADD);

		List<Department> allDepartments = null;
		allDepartments = new Department().getAll();
		request.setAttribute("allDepartments", allDepartments);

		List<UserRole> allRoles = null;
		allRoles = new UserRole().getAllRoles();
		request.setAttribute("allRoles", allRoles);

		return mapping.findForward("addUser");
	}

}
