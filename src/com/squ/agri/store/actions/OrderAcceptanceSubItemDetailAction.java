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
 * File Name      : OrderAcceptanceSubItemDetailAction.java
 * 
 * Date           : Oct 6, 2009
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
import com.squ.agri.store.bo.Grade;
import com.squ.agri.store.bo.Item;
import com.squ.agri.store.bo.Measurment;
import com.squ.agri.store.bo.SubItem;
import com.squ.agri.store.bo.Variation;
import com.squ.agri.store.dao.common.CommonDBFactory;
import com.squ.agri.store.forms.StoreItemsDetailForm;
import com.squ.agri.store.process.procure.ProcureFactory;
import com.squ.agri.store.users.User;

/**
 * @author Administrator
 * 
 */
public class OrderAcceptanceSubItemDetailAction extends Action
{
	@SuppressWarnings("unchecked")
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
System.out.println("test - subitem");
		HttpSession session = request.getSession();
		User user = null;

		StoreItemsDetailForm itemForm = (StoreItemsDetailForm) form;
		/**
		 * Due to session loss in IFrame .. again putting the user object into
		 * session
		 */
		if (session.getAttribute(StoreConstants.SESSION_USER) == null)
		{
			user = new User().getUser(itemForm.getUid());
			session.setAttribute(StoreConstants.SESSION_USER, user);
		}
		else
			user = (User) session.getAttribute(StoreConstants.SESSION_USER);

		Item item = itemForm.getItem();

		// check if the item is multiple or not
		if (itemForm.isMultipleSubItem())
			item.setMultipleSubItem(true);
		else
			item.setMultipleSubItem(false);

		ProcureFactory procureFactory = new ProcureFactory(item);
		List<SubItem> lst = (List) procureFactory
				.procurementOptions(StoreConstants.PROCURE_STORE_ITEMS_SUBITEMS);

		itemForm.setAllSubItems(lst);
		itemForm.setTotalSubItems(lst.size()); // used for validation of dates
												// using javascript

		Department department = new Department();

		department.setDeptId(user.getDeptId());// user department id from the
												// session
		department.setDeptName(department.getDeptName(user.getDeptId()));// using
																			// department
																			// id
																			// get
																			// department
																			// name

		request.setAttribute("department", department);

		String ms_id = itemForm.getMeasurment();
		Measurment measurment = new Measurment().getMeasurment(ms_id);

		if (measurment != null)
			itemForm.setMeasurment(measurment.getMeasurment_Unit());

		List<Variation> allVariations = new CommonDBFactory(
				StoreConstants.VARIATION).getAll();
		List<Grade> allGrades = new CommonDBFactory(StoreConstants.GRADE)
				.getAll();

		request.setAttribute("allVariations", allVariations);
		request.setAttribute("allGrades", allGrades);

		return mapping.findForward("showOrderAcceptanceSubItemDetail");
	}

}
