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
 * Package Name   : com.squ.agri.store.bo
 * File Name      : Procurements.java
 * 
 * Date           : Sep 6, 2009
 * 
 */
package com.squ.agri.store.bo;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.util.HashMap;

import org.apache.commons.beanutils.BeanUtils;

import com.squ.agri.store.forms.ProcurementForm;

/**
 * @author Owner
 * 
 */
public class Procurements
{
	private String procureId = null;
	private String prnNo = null;
	private String lpoNo = null;
	private String grnNo = null;
	private String supplierId = null;
	private String deptId = null; // This deptId is maintained for association
	// with Department only
	private String deptSourceId = null; // Source Department
	private String deptDestId = null; // Destination Department
	private Date prnDate = null;
	private Date dtInfoReceived = null;
	private Department department = null;
	private HashMap<String, String> paramProcure = new HashMap<String, String>();
	private Item[] items = null;

	private String userRole = null;

	/**
	 * @return the procureId
	 */
	public String getProcureId()
	{
		return procureId;
	}

	/**
	 * @param procureId
	 *            the procureId to set
	 */
	public void setProcureId(String procureId)
	{
		this.procureId = procureId;
		paramProcure.put("procureId", procureId);
	}

	/**
	 * @return the prnNo
	 */
	public String getPrnNo()
	{
		return prnNo;
	}

	/**
	 * @param prnNo
	 *            the prnNo to set
	 */
	public void setPrnNo(String prnNo)
	{
		this.prnNo = prnNo;
		paramProcure.put("prnNo", prnNo);
	}

	/**
	 * @return the lpoNo
	 */
	public String getLpoNo()
	{
		return lpoNo;
	}

	/**
	 * @param lpoNo
	 *            the lpoNo to set
	 */
	public void setLpoNo(String lpoNo)
	{
		this.lpoNo = lpoNo;
	}

	/**
	 * @return the grnNo
	 */
	public String getGrnNo()
	{
		return grnNo;
	}

	/**
	 * @param grnNo
	 *            the grnNo to set
	 */
	public void setGrnNo(String grnNo)
	{
		this.grnNo = grnNo;
	}

	/**
	 * @return the supplierId
	 */
	public String getSupplierId()
	{
		return supplierId;
	}

	/**
	 * @param supplierId
	 *            the supplierId to set
	 */
	public void setSupplierId(String supplierId)
	{
		this.supplierId = supplierId;
	}

	/**
	 * @return the deptId
	 */
	public String getDeptId()
	{
		return deptId;
	}

	/**
	 * @param deptId
	 *            the deptId to set
	 */
	public void setDeptId(String deptId)
	{
		this.deptId = deptId;
	}

	/**
	 * @return the deptSourceId
	 */
	public String getDeptSourceId()
	{
		return deptSourceId;
	}

	/**
	 * @param deptSourceId
	 *            the deptSourceId to set
	 */
	public void setDeptSourceId(String deptId)
	{
		this.deptSourceId = deptId;
	}

	/**
	 * @return the deptDestId
	 */
	public String getDeptDestId()
	{
		return deptDestId;
	}

	/**
	 * @param deptDestId
	 *            the deptDestId to set
	 */
	public void setDeptDestId(String deptDestId)
	{
		this.deptDestId = deptDestId;
	}

	/**
	 * @return the prnDate
	 */
	public Date getPrnDate()
	{
		return prnDate;
	}

	/**
	 * @param prnDate
	 *            the prnDate to set
	 */
	public void setPrnDate(Date prnDate)
	{
		this.prnDate = prnDate;
	}

	/**
	 * @return the dtInfoReceived
	 */
	public Date getDtInfoReceived()
	{
		return dtInfoReceived;
	}

	/**
	 * @param dtInfoReceived
	 *            the dtInfoReceived to set
	 */
	public void setDtInfoReceived(Date dtInfoReceived)
	{
		this.dtInfoReceived = dtInfoReceived;
	}

	/**
	 * @return the department
	 */
	public Department getDepartment()
	{
		return department;
	}

	/**
	 * @param department
	 *            the department to set
	 */
	public void setDepartment(Department department)
	{
		this.department = department;
	}

	public void copyBean(Object obj)
	{
		try
		{
			BeanUtils.copyProperties(this, obj);
		}
		catch (IllegalAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (InvocationTargetException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @return the paramProcure
	 */
	public HashMap<String, String> getParamProcure()
	{
		return paramProcure;
	}

	/**
	 * @return the items
	 */
	public Item[] getItems()
	{
		return items;
	}

	/**
	 * @param items
	 *            the items to set
	 */
	public void setItems(Item[] items)
	{
		this.items = items;
	}

	/**
	 * @return the userRole
	 */
	public String getUserRole()
	{
		return userRole;
	}

	/**
	 * @param userRole
	 *            the userRole to set
	 */
	public void setUserRole(String userRole)
	{
		this.userRole = userRole;
	}

	public void copyFormBean(ProcurementForm form)
	{
		this.procureId = form.getProcureId();
		this.prnNo = form.getPrnNo();
		this.lpoNo = form.getLpoNo();
		this.grnNo = form.getGrnNo();
		this.supplierId = form.getSupplierId();
		this.deptSourceId = form.getDeptSourceId();
		this.deptDestId = form.getDeptDestId();
		this.items = form.getArrItems();
	}

}
