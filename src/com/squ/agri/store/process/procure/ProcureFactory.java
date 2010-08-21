package com.squ.agri.store.process.procure;

import java.util.List;

import com.squ.agri.store.StoreConstants;
import com.squ.agri.store.bo.Item;
import com.squ.agri.store.bo.Procurements;
import com.squ.agri.store.bo.PurchaseOrder;
import com.squ.agri.store.bo.SubItem;

public class ProcureFactory
{
	private String procureNo = null;
	private char procureNoType = StoreConstants.ProcurePRN;
	private Procure procure = null;
	private Object procureObjects = null;

	public ProcureFactory(Procurements procurement)
	{
		procure = new ProcureInfo(procurement);
	}

	public ProcureFactory(Item item)
	{
		procure = new ProcureInfo(item);
	}

	public ProcureFactory(List<SubItem> lstSubItem)
	{
		procure = new ProcureInfo(lstSubItem);
	}

	public ProcureFactory(String procureNo, char procureNoType)
	{
		this.procureNo = procureNo;
		this.procureNoType = procureNoType;
	}

	public ProcureFactory(String prnNo, String lpoNo, String grnNo)
	{
		if (prnNo == null)
		{
			if (lpoNo == null)
			{
				if (grnNo == null)
				{
					// TODO throw exception
				}
				else
				{
					procureNo = grnNo.trim();
					procureNoType = StoreConstants.ProcurePRN;
				}
			}
			else
			{
				procureNo = lpoNo.trim();
				procureNoType = StoreConstants.ProcureLPO;
			}
		}
		else
		{
			procureNo = prnNo.trim();
			procureNoType = StoreConstants.ProcurePRN;
		}
	}

	/**
	 * procureNoType = 'p' => prn no procureNoType = 'l' => lpo no procureNoType
	 * = 'g' => grn no
	 * 
	 * @param procureNo
	 * @param procureNoType
	 * @param procureType
	 * @return
	 */

	public PurchaseOrder getItems()
	{
		Procure procure = null;

		if (procureNoType == StoreConstants.ProcurePRN)
		{
			procure = new ProcurePRN(procureNo);
		}

		return (PurchaseOrder) procure.procurement(null);
	}

	public Object procurementOptions(String option)
	{

		procureObjects = procure.procurement(option);
		return procureObjects;
	}

}