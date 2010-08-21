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
 * File Name      : WelcomeAction.java
 * 
 * Date           : Sep 10, 2009
 * 
 */
package com.squ.agri.store.actions;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


/**
 * @author Owner
 * 
 */
public class WelcomeAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{

		if (request.getParameter("logout") != null)
		{
			String pth = request.getContextPath();
			request.getSession().invalidate();

			try
			{
				response.sendRedirect(pth + "/welcome.do");
			}
			catch (IOException e)
			{

			}

			return null;
		}
			
		return mapping.findForward("welcomePage");
	}

}
