package com.squ.agri.store.bo;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class PurchaseOrder
{
	private String procureItemId = null;
	private String productGroup = null;
	private String supplierId = null;
	private String supplierName = null;

	private String prnNo = null;
	private String lpoNo = null;
	private String grnNo = null;

	private Date datePrn = null;
	private Date dateLpo = null;

	private int id = 0;

	private Set<Item> items = new HashSet<Item>();

	/**
	 * @return the procureItemId
	 */
	public String getProcureItemId()
	{
		return procureItemId;
	}

	/**
	 * @param procureItemId
	 *            the procureItemId to set
	 */
	public void setProcureItemId(String procureItemId)
	{
		this.procureItemId = procureItemId;
	}

	/**
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id)
	{
		this.id = id;
	}

	/**
	 * @return the productGroup
	 */
	public String getProductGroup()
	{
		return productGroup;
	}

	/**
	 * @param productGroup
	 *            the productGroup to set
	 */
	public void setProductGroup(String productGroup)
	{
		this.productGroup = productGroup;
	}

	/**
	 * @return the supplierId
	 */
	public String getSupplierId()
	{
		return this.supplierId;
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
	 * @return the supplierName
	 */
	public String getSupplierName()
	{
		return this.supplierName;
	}

	/**
	 * @param supplierName
	 *            the supplierName to set
	 */
	public void setSupplierName(String supplierName)
	{
		this.supplierName = supplierName;
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
	 * @return the datePrn
	 */
	public Date getDatePrn()
	{
		return datePrn;
	}

	/**
	 * @param datePrn
	 *            the datePrn to set
	 */
	public void setDatePrn(Date datePrn)
	{
		this.datePrn = datePrn;
	}

	/**
	 * @return the dateLpo
	 */
	public Date getDateLpo()
	{
		return dateLpo;
	}

	/**
	 * @param dateLpo
	 *            the dateLpo to set
	 */
	public void setDateLpo(Date dateLpo)
	{
		this.dateLpo = dateLpo;
	}

	/**
	 * @return the items
	 */
	public Set<Item> getItems()
	{
		return items;
	}

	/**
	 * @param items
	 *            the items to set
	 */
	public void setItems(Set<Item> items)
	{
		this.items = items;
	}
}
