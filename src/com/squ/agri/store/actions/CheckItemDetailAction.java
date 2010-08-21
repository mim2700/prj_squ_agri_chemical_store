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
 * File Name      : CheckItemDetailAction.java
 * 
 * Date           : Aug 14, 2009
 * 
 */
package com.squ.agri.store.actions;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.squ.agri.store.StoreConstants;
import com.squ.agri.store.bo.Department;

import com.squ.agri.store.bo.PurchaseOrder;
import com.squ.agri.store.process.procure.ProcureFactory;
import com.squ.agri.store.users.User;

/**
 * @author Owner
 * 
 */
public class CheckItemDetailAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		String prnNo = null;
		String lpoNo = null;
		String grnNo = null;
		List<Department> allDepartments = null;

		PurchaseOrder purchaseOrder = null;

		DynaActionForm dynaFormChkItemDetail = (DynaActionForm) form;
		prnNo = dynaFormChkItemDetail.get("prnNo").toString();
		lpoNo = dynaFormChkItemDetail.get("lpoNo").toString();
		grnNo = dynaFormChkItemDetail.get("grnNo").toString();

		ProcureFactory procureFactory = new ProcureFactory(prnNo, lpoNo, grnNo);
		purchaseOrder = procureFactory.getItems();

		allDepartments = new Department().getAll();
		request.setAttribute("purchaseOrder", purchaseOrder);
		request.setAttribute("allDepartments", allDepartments);

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(StoreConstants.SESSION_USER);

		dynaFormChkItemDetail.set("userRole", user.getRole());
		dynaFormChkItemDetail.set("deptDestId", user.getDeptId());

		if (purchaseOrder == null)
			return mapping.findForward("showCheckItem");
		else
			return mapping.findForward("showCheckItemDetail");
	}
}