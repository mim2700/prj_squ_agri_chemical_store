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
 * File Name      : ItemGradeAction.java
 * 
 * Date           : Oct 7, 2009
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

import com.squ.agri.store.bo.*;
import com.squ.agri.store.StoreConstants;
import com.squ.agri.store.dao.common.CommonDBFactory;
import com.squ.agri.store.forms.ItemGradeForm;

/**
 * @author Administrator
 * 
 */
public class ItemGradeAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		List<Grade> allGrades = new CommonDBFactory(StoreConstants.GRADE)
				.getAll();
		request.setAttribute("allGrades", allGrades);

		ItemGradeForm gradeF = (ItemGradeForm) form;
		gradeF.setGradeId("");

		return mapping.findForward("showItemGrade");
	}
}
