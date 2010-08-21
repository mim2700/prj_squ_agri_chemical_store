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
 * File Name      : ConsumeSubitemsAction.java
 * 
 * Date           : Nov 8, 2009
 * 
 */
package com.squ.agri.store.actions;

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
import com.squ.agri.store.bo.SubItem;
import com.squ.agri.store.dao.inHouse.ConsumeSubItemsDb;
import com.squ.agri.store.forms.ConsumeItemForm;
import com.squ.agri.store.users.User;

/**
 * @author Administrator
 * 
 */
public class ConsumeSubitemsAction extends Action
{

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		ConsumeItemForm itemForm = (ConsumeItemForm) form;

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(StoreConstants.SESSION_USER);

		Department department = new Department();

		department.setDeptId(user.getDeptId());
		department.setDeptName(department.getDeptName(user.getDeptId()));

		request.setAttribute("department", department);

		Item item = new Item();
		item.copyBean(itemForm);

		String searchFrom = "Department";

		if (user.getRole().equalsIgnoreCase("Central_Store")
				|| user.getRole().equalsIgnoreCase("administrator"))
			searchFrom = "Central_Store";

		SubItem[] arrItem = new ConsumeSubItemsDb().subItemsList(item
				.getItemCode(), department.getDeptId(), item.getItemQuantity(),
				searchFrom, "");

		arrItem = clacluate_Consuption_List(arrItem, item.getItemQuantity());

		item.setSubItems(arrItem);
		itemForm.setSubItems(arrItem);
		request.setAttribute("Item", item);

		return mapping.findForward("showConsumeSubItems");
	}

	private SubItem[] clacluate_Consuption_List(SubItem[] arr, int qty)
	{
		int temp = 0;
		int indx = 0;
		SubItem tem_arr[] = null;

		for (int i = 0; i < arr.length; i++)
		{
			temp += arr[i].getQtyAvailable();
			if (temp >= qty)
			{
				indx = i;
				break;
			}
		}

		if (indx >= 0)
		{

			tem_arr = new SubItem[indx + 1];

			for (int i = 0; i <= indx; i++)
			{
				tem_arr[i] = arr[i];

				if (i == (indx))
					tem_arr[i].setQtyAvailable(arr[i].getQtyAvailable()
							- (temp - qty));
			}
		}

		return tem_arr;
	}

}
