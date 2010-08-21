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
 * File Name      : AdjustSubItemsDetailsResultsAction.java
 * 
 * Date           : Nov 23, 2009
 * 
 */
package com.squ.agri.store.actions;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.squ.agri.store.bo.Adjustment;
import com.squ.agri.store.bo.Item;
import com.squ.agri.store.bo.SubItem;
import com.squ.agri.store.dao.inHouse.AdjustmentDb;
import com.squ.agri.store.forms.AdjustItemsForm;

/**
 * @author Administrator
 * 
 */
public class AdjustSubItemsDetailsResultsAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		AdjustItemsForm adjustForm = (AdjustItemsForm) form;

		String adjustment_id = adjustForm.getAdjusmentType();
		Adjustment adjustment = new Adjustment()
				.getAdjustmentById(adjustment_id);

		String department_id = adjustForm.getDep_Source();

		List<Item> items = null;
		items = adjustForm.getItems();
		Item item = items.get(0);

		List<SubItem> subItems = null;
		subItems = adjustForm.getSubItems();

		for (int i = 0; i < subItems.size(); i++)
		{
			SubItem temp = subItems.get(i);

			String subItemCode = temp.getSubItemId();

			int quantity = 0;
			if (item.isMultipleSubItem())
				quantity = item.getItemQuantity();
			else
				quantity = 1;

			Date manuDate = temp.getManuDate();
			Date expireDate = temp.getExpireDate();

			String grade = temp.getGrade();
			String size = temp.getSize();
			String variation = temp.getVariation();

			String addInto = "Department";
			if (adjustForm.getUserRole().equalsIgnoreCase("Central_Store")
					|| adjustForm.getUserRole().equalsIgnoreCase(
							"administrator"))
				addInto = "Central_Store";

			new AdjustmentDb().AdjustSubItem(subItemCode, department_id,
					quantity, adjustment.getAdjusment_Action(), adjustment_id,
					manuDate, expireDate, grade, size, variation, addInto);
		}

		return mapping.findForward("showAdjustmentSubItemsDetailsResults");
	}

}
