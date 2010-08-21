package com.squ.agri.store.dao.procure;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import com.squ.agri.store.bo.PurchaseOrder;
import com.squ.agri.store.dao.DBConstants;
import com.squ.agri.store.dbUtil.HibernateUtil;

public class ProcureDbPRN implements ProcureDao
{
	/**
	 * p = prn l = lpo g = grn
	 */

	private String procureNo = null;

	public ProcureDbPRN(String procureNo)
	{
		this.procureNo = procureNo;
	}

	public Object procurement(String option)
	{
		PurchaseOrder po = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		List<PurchaseOrder> poList = session
				.createQuery(DBConstants.hql_PO_PRN).setString(0, procureNo)
				.list();

		for (Iterator<PurchaseOrder> itrPoList = poList.iterator(); itrPoList
				.hasNext();)
		{
			po = itrPoList.next();
			break;

		}
		session.close();
		return po;
	}

}
