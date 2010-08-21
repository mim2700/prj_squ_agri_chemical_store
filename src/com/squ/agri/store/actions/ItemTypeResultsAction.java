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
 * File Name      : ItemTypeResultsAction.java
 * 
 * Date           : Oct 18, 2009
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

import com.squ.agri.store.StoreConstants;
import com.squ.agri.store.bo.Type;
import com.squ.agri.store.dao.common.CommonDBFactory;
import com.squ.agri.store.forms.ItemTypeForm;

/**
 * @author Administrator
 * 
 */

public class ItemTypeResultsAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{

		ItemTypeForm typeF = (ItemTypeForm) form;

		Type type = new Type();
		type.copyBean(typeF);

		CommonDBFactory cdbf = new CommonDBFactory(StoreConstants.TYPE);
		cdbf.saveUpdate(type);

		return mapping.findForward("showItemTypeResults");
	}

}
