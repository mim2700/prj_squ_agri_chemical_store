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
 * File Name      : LoginAction.java
 * 
 * Date           : Sep 1, 2009
 * 
 */
package com.squ.agri.store.actions;

import java.security.GeneralSecurityException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.squ.agri.store.encrypt.GenerateMsgDigest;
import com.squ.agri.store.forms.LoginForm;

/**
 * @author Administrator
 * 
 */
public class LoginAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		LoginForm loginform = (LoginForm) form;
		GenerateMsgDigest msgDigest = new GenerateMsgDigest(loginform
				.getJ_password());

		try
		{

			String strPwd = msgDigest.getEncryptPassword();

			request.setAttribute("userName", loginform.getJ_username());
			request.setAttribute("userPwd", strPwd);
			loginform.setJ_password(strPwd);

		}
		catch (GeneralSecurityException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mapping.findForward("loginToEncrypt");
	}
}
