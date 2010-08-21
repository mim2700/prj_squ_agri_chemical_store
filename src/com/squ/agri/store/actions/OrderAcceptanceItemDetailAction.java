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
 * File Name      : OrderAcceptanceItemDetailAction.java
 * 
 * Date           : Aug 14, 2009
 * 
 */
package com.squ.agri.store.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.squ.agri.store.StoreConstants;
import com.squ.agri.store.bo.Department;
import com.squ.agri.store.bo.Item;
import com.squ.agri.store.bo.Measurment;
import com.squ.agri.store.bo.PurchaseOrder;
import com.squ.agri.store.bo.Safety;
import com.squ.agri.store.bo.Type;
import com.squ.agri.store.dao.common.CommonDBFactory;
import com.squ.agri.store.forms.ProcurementForm;
import com.squ.agri.store.process.procure.ProcureFactory;
import com.squ.agri.store.users.User;

/**
 * @author Owner
 * 
 */
public class OrderAcceptanceItemDetailAction extends Action
{
	@SuppressWarnings("unchecked")
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		String prnNo = null;
		String lpoNo = null;
		String grnNo = null;
		List<Department> allDepartments = null;

		PurchaseOrder purchaseOrder = null;

		ProcurementForm procurementForm = (ProcurementForm) form;

		prnNo = procurementForm.getPrnNo();

		ProcureFactory procureFactory = new ProcureFactory(prnNo, lpoNo, grnNo);
		purchaseOrder = procureFactory.getItems();
		procurementForm.setItems(purchaseOrder.getItems());

		Item arrItems[] = procurementForm.getArrItems();

		procurementForm.setTotalItems(arrItems.length);

		for (int i = 0; i < arrItems.length; i++)
		{
			Item item = new Item().getItemById(arrItems[i].getItemCode());

			if (item.isMultipleSubItem())
				arrItems[i].setMultipleSubItem(true);
			else
				arrItems[i].setMultipleSubItem(false);

			arrItems[i].setType(item.getType());
			arrItems[i].setSafety(item.getSafety());
			arrItems[i].setMeasurment(item.getMeasurment());
			arrItems[i].setGrade(item.getGrade());
		}

		procurementForm.setArrItems(arrItems);

		allDepartments = new Department().getAll();

		List<Safety> allSafetys = new CommonDBFactory(StoreConstants.SAFETY)
				.getAll();
		List<Type> allTypes = new CommonDBFactory(StoreConstants.TYPE).getAll();

		List<Measurment> allMeasurments = new CommonDBFactory(
				StoreConstants.MEASURMEN).getAll();

		HttpSession session = request.getSession();
		@SuppressWarnings("unused")
		User user = (User) session.getAttribute(StoreConstants.SESSION_USER);
		session.setAttribute("procurementForm", procurementForm);

		request.setAttribute("user", user);
		request.setAttribute("purchaseOrder", purchaseOrder);
		request.setAttribute("allDepartments", allDepartments);
		request.setAttribute("allSafetys", allSafetys);
		request.setAttribute("allTypes", allTypes);
		request.setAttribute("allMeasurments", allMeasurments);

		return mapping.findForward("showOrderAcceptanceItemDetail");
	}

}
