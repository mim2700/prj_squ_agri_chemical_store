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
 * File Name      : AdjustmentDetailsAction.java
 * 
 * Date           : Nov 18, 2009
 * 
 */
package com.squ.agri.store.actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.squ.agri.store.StoreConstants;
import com.squ.agri.store.bo.Adjustment;
import com.squ.agri.store.bo.Department;
import com.squ.agri.store.bo.Grade;
import com.squ.agri.store.bo.Item;
import com.squ.agri.store.bo.Measurment;
import com.squ.agri.store.bo.Safety;
import com.squ.agri.store.bo.SubItem;
import com.squ.agri.store.bo.Type;
import com.squ.agri.store.dao.common.CommonDBFactory;
import com.squ.agri.store.dao.inHouse.ConsumeSubItemsDb;
import com.squ.agri.store.forms.AdjustItemsForm;

/**
 * @author Administrator
 * 
 */
public class AdjustmentDetailsAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		AdjustItemsForm adjForm = (AdjustItemsForm) form;

		request.setAttribute("source_Dept", new Department()
				.getDeparment(adjForm.getDep_Source()));

		Adjustment adjustment = new Adjustment().getAdjustmentById(adjForm
				.getAdjusmentType());

		request.setAttribute("adjustment", adjustment);
		adjForm.setAdjustment(adjustment);

		Item[] arrItem = null;

		String searchFrom = "Department";

		if (adjForm.getUserRole().equalsIgnoreCase("central_Store"))
		{
			searchFrom = "Central_Store";
		}

		if (adjustment.getAdjusment_Action().equalsIgnoreCase("R"))
		{
			// adjustment types:
			// ADJ001 = petty cash
			// ADJ003 = Stock Addition Due to Lost Stock Found

			if (adjustment.getAdjusment_ID().equalsIgnoreCase("ADJ001"))
				arrItem = new ConsumeSubItemsDb().getAllAgriVisionItems(); // all
																			// items
																			// from
																			// vision
			else
				if (adjustment.getAdjusment_ID().equalsIgnoreCase("ADJ003")) // all
																				// items
																				// bought
					arrItem = new ConsumeSubItemsDb().itemsListFrom_DS(adjForm
							.getDep_Source(), "", "all_product_bought",
							searchFrom);

			List<Safety> allSafetys = new CommonDBFactory(StoreConstants.SAFETY)
					.getAll();
			List<Type> allTypes = new CommonDBFactory(StoreConstants.TYPE)
					.getAll();
			List<Measurment> allMeasurments = new CommonDBFactory(
					StoreConstants.MEASURMEN).getAll();

			request.setAttribute("allSafetys", allSafetys);
			request.setAttribute("allTypes", allTypes);
			request.setAttribute("allMeasurments", allMeasurments);

		}
		else
			if (adjustment.getAdjusment_Action().equalsIgnoreCase("C"))
			{
				// adjustment types:
				// ADJ002 = Stock Reduction Due To Damages
				// ADJ011 = exipry date end

				if (adjustment.getAdjusment_ID().equalsIgnoreCase("ADJ002")) // all
																				// items
																				// available
																				// for
																				// department
					arrItem = new ConsumeSubItemsDb().itemsListFrom_DS(adjForm
							.getDep_Source(), "", "all_available", searchFrom);
				else
					if (adjustment.getAdjusment_ID().equalsIgnoreCase("ADJ011")) // all
																					// expired
																					// items
						arrItem = new ConsumeSubItemsDb().itemsListFrom_DS(
								adjForm.getDep_Source(), "",
								"all_available_expired", searchFrom);
			}

		List<Item> allItems = null;

		if (arrItem != null)
			allItems = Arrays.asList(arrItem);
		else
			allItems = new ArrayList<Item>();

		request.setAttribute("allItems", allItems);

		List<SubItem> subItems = new ArrayList<SubItem>();
		subItems.add(new SubItem());
		adjForm.setSubItems(subItems);

		List<Item> items = new ArrayList<Item>();
		items.add(new Item());
		adjForm.setItems(items);

		return mapping.findForward("showAdjustmentDetails");
	}

}
