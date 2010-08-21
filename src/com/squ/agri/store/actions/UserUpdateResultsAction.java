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
 * File Name      : UserUpdateResultsAction.java
 * 
 * Date           : Oct 6, 2009
 * 
 */
package com.squ.agri.store.actions;

import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.squ.agri.store.StoreConstants;
import com.squ.agri.store.encrypt.GenerateMsgDigest;
import com.squ.agri.store.forms.LoginForm;
import com.squ.agri.store.forms.RequestItemsDetailForm;
import com.squ.agri.store.users.User;
import com.squ.agri.store.users.UserFactory;

/**
 * @author Administrator
 * 
 */
public class UserUpdateResultsAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{

		String newPassword = null;
		String oldPassword = null;

		LoginForm usrF = (LoginForm) form;

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(StoreConstants.SESSION_USER);

		try
		{
			GenerateMsgDigest msgDigest_newPassword = new GenerateMsgDigest(
					usrF.getNewPwd());
			newPassword = msgDigest_newPassword.getEncryptPassword();

			GenerateMsgDigest msgDigest_OldPassword = new GenerateMsgDigest(
					usrF.getPwd());
			oldPassword = msgDigest_OldPassword.getEncryptPassword();
		}
		catch (GeneralSecurityException e)
		{
			e.printStackTrace();
		}

		if (oldPassword.trim().equalsIgnoreCase(user.getPwd().trim())
				&& usrF.getNewPwd().trim().equalsIgnoreCase(
						usrF.getConfirmPwd().trim()))
		{
			user.setPwd(newPassword);
			UserFactory usrFactry = new UserFactory(user);
			usrFactry.getOperation(user, StoreConstants.USER_MODIFY);

			session.setAttribute(StoreConstants.SESSION_USER, user);
			return mapping.findForward("userUpdateSuccess");

		}
		else
		{
			usrF.setConfirmPwd("");
			usrF.setNewPwd("");
			usrF.setPwd("");
			return mapping.findForward("userUpdateFail");
		}

	}
}
