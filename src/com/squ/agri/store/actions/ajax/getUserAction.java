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
 * Package Name   : com.squ.agri.store.actions.ajax
 * File Name      : getUserAction.java
 * 
 * Date           : Nov 6, 2009
 * 
 */
package com.squ.agri.store.actions.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.squ.agri.store.users.User;

/**
 * @author Administrator
 * 
 */
public class getUserAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm inForm,
			HttpServletRequest request, HttpServletResponse response)
	{

		String id = (String) request.getParameter("id");

		if (id != null)
		{

			User usr = new User().getUser(id);

			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");

			PrintWriter out;

			try
			{
				out = response.getWriter();

				// XML formatted response:
				out.println("<user>");

				out.println("<uid>" + usr.getUid() + "</uid> ");
				out.println(" <name>" + usr.getName() + "</name>");
				out.println("<role>" + usr.getRole() + "</role>");
				out.println("<deptId>" + usr.getDeptId() + "</deptId>");

				if (usr.isActive())
					out.println("<active>1</active>");
				else
					out.println("<active>0</active>");

				out.println("</user>");

				out.flush();

			}
			catch (IOException e)
			{
				e.printStackTrace();
			}

		}
		else
		{
			// nothing to show
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		}

		return null;
	}

}
