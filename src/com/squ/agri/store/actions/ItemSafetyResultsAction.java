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
 * File Name      : ItemSafetyResultsAction.java
 * 
 * Date           : Oct 14, 2009
 * 
 */
package com.squ.agri.store.actions;

import java.security.GeneralSecurityException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.squ.agri.store.StoreConstants;
import com.squ.agri.store.bo.Department;
import com.squ.agri.store.bo.Grade;
import com.squ.agri.store.bo.Safety;
import com.squ.agri.store.dao.common.CommonDBFactory;
import com.squ.agri.store.encrypt.GenerateMsgDigest;
import com.squ.agri.store.forms.ItemGradeForm;
import com.squ.agri.store.forms.ItemSafetyForm;
import com.squ.agri.store.forms.LoginForm;
import com.squ.agri.store.users.User;
import com.squ.agri.store.users.UserFactory;
import com.squ.agri.store.users.UserRole;

/**
 * @author Administrator
 * 
 */
public class ItemSafetyResultsAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{

		ItemSafetyForm safetyF = (ItemSafetyForm) form;

		Safety safety = new Safety();
		safety.copyBean(safetyF);

		CommonDBFactory cdbf = new CommonDBFactory(StoreConstants.SAFETY);
		cdbf.saveUpdate(safety);

		return mapping.findForward("showItemSafetyResults");
	}

}
