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
 * File Name      : AdjustmentSubItemsDetailsAction.java
 * 
 * Date           : Nov 22, 2009
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

import com.squ.agri.store.bo.Adjustment;
import com.squ.agri.store.bo.Department;
import com.squ.agri.store.bo.Item;
import com.squ.agri.store.bo.Measurment;
import com.squ.agri.store.forms.AdjustItemsForm;

public class AdjustmentSubItemsDetailsAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		AdjustItemsForm adjustForm = (AdjustItemsForm) form;
		String adjustment_id = adjustForm.getAdjusmentType();
		String department_id = adjustForm.getDep_Source();

		Department department = new Department().getDeparment(department_id);
		request.setAttribute("source_Dept", department);

		Adjustment adjustment = new Adjustment()
				.getAdjustmentById(adjustment_id);
		request.setAttribute("adjustment", adjustment);

		List<Item> items = adjustForm.getItems();

		request.setAttribute("item", items.get(0));

		Measurment measurment = new Measurment().getMeasurment(items.get(0)
				.getMeasurment());

		request.setAttribute("measurment", measurment);

		return mapping.findForward("showAdjustmentSubItemsDetails");
	}

}
