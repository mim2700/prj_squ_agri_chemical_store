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
 * File Name      : AdjustItemsResultsAction.java
 * 
 * Date           : Aug 18, 2009
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

import com.squ.agri.store.StoreConstants;
import com.squ.agri.store.bo.Adjustment;
import com.squ.agri.store.bo.Grade;
import com.squ.agri.store.bo.Item;
import com.squ.agri.store.bo.SubItem;
import com.squ.agri.store.bo.Variation;
import com.squ.agri.store.dao.common.CommonDBFactory;
import com.squ.agri.store.dao.inHouse.AdjustmentDb;
import com.squ.agri.store.forms.AdjustItemsForm;

/**
 * @author Administrator
 * 
 */
public class AdjustItemsResultsAction extends Action
{
	// @SuppressWarnings("unused")
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{

		AdjustItemsForm adjustForm = (AdjustItemsForm) form;

		String adjustment_id = adjustForm.getAdjusmentType();
		Adjustment adjustment = new Adjustment()
				.getAdjustmentById(adjustment_id);

		String department_id = adjustForm.getDep_Source();

		List<SubItem> subItems = null;
		List<Item> items = null;

		items = adjustForm.getItems();
		subItems = adjustForm.getSubItems();

		if (adjustment.getAdjusment_Action().equals("R"))
		{

			Item item = items.get(0);

			String itemCode = item.getItemCode();
			int quantity = item.getItemQuantity();

			subItems.clear();

			Item itemtemp = new Item().getItemById(itemCode);

			String tempMulti = null;

			// check if multiple subitems from adjustment form
			if (item.isMultipleSubItem())
				tempMulti = "y";
			// check if multiple subitems from MT_Prodct; because if check box
			// disabled will give false very time
			if (itemtemp.isMultipleSubItem())
				tempMulti = "y";
			if (tempMulti != null)
				if (tempMulti.equalsIgnoreCase("y"))
					items.get(0).setMultipleSubItem(true);

			items.get(0).setItemName(itemtemp.getItemName());

			if (items.get(0).getMeasurment() == null)
				items.get(0).setMeasurment(itemtemp.getMeasurment());

			adjustForm.setItems(items);

			for (int a = 0; a < quantity; a++)
			{
				SubItem temp = new SubItem();

				String subItemId = new AdjustmentDb().Adjust_Add_SubItem(
						itemCode, itemtemp.getItemName(), item.getType(), item
								.getSafety(), item.getGrade(), item
								.getMeasurment(), tempMulti);

				temp.setSubItemId(subItemId);
				temp.setACTIVE(false);

				subItems.add(temp);

				if (item.isMultipleSubItem())
					break;
			}

			adjustForm.setSubItems(subItems);
			adjustForm.setTotalSubItems(subItems.size());

			List<Variation> allVariations = new CommonDBFactory(
					StoreConstants.VARIATION).getAll();
			List<Grade> allGrades = new CommonDBFactory(StoreConstants.GRADE)
					.getAll();

			request.setAttribute("allVariations", allVariations);
			request.setAttribute("allGrades", allGrades);

			return mapping.findForward("adjustmentsSubItemsDetails");
		}
		else
		{
			String itemCode = items.get(0).getItemCode();
			int quantity = items.get(0).getItemQuantity();
			String subItemCode = subItems.get(0).getSubItemId();

			String addInto = "Department";
			if (adjustForm.getUserRole().equalsIgnoreCase("Central_Store")
					|| adjustForm.getUserRole().equalsIgnoreCase(
							"administrator"))
				addInto = "Central_Store";

			new AdjustmentDb().AdjustSubItem(subItemCode, department_id,
					quantity, adjustment.getAdjusment_Action(), adjustment_id,
					new Date(0), new Date(0), "", "", "", addInto);
		}

		return mapping.findForward("showAdjustItemsResults");
	}
}
