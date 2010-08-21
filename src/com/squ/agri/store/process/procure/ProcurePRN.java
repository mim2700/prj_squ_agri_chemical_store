package com.squ.agri.store.process.procure;

import com.squ.agri.store.StoreConstants;
import com.squ.agri.store.bo.PurchaseOrder;
import com.squ.agri.store.dao.DBFactory;
import com.squ.agri.store.dao.procure.ProcureDao;

public class ProcurePRN implements Procure
{
	private String procureNo = null;

	public ProcurePRN(String procureNo)
	{
		this.procureNo = procureNo;

	}

	public Object procurement(String option)
	{
		return findItems();
	}

	private PurchaseOrder findItems()
	{
		ProcureDao procuredao = new DBFactory().findProcureItems(procureNo,
				StoreConstants.ProcurePRN);
		return (PurchaseOrder) procuredao
				.procurement(StoreConstants.procureVISION_PURCHASE_ORDER);
	}

}
