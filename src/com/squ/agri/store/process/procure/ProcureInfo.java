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
 * Package Name   : com.squ.agri.store.process.procure
 * File Name      : ProcureInfo.java
 * 
 * Date           : Sep 7, 2009
 * 
 */
package com.squ.agri.store.process.procure;

import java.util.List;

import com.squ.agri.store.bo.Item;
import com.squ.agri.store.bo.Procurements;
import com.squ.agri.store.bo.SubItem;
import com.squ.agri.store.dao.DBFactory;

/**
 * @author Owner
 * 
 */
public class ProcureInfo implements Procure
{
	Object procureObj = null;
	DBFactory dbFactory = null;

	public ProcureInfo(Procurements procurements)
	{
		dbFactory = new DBFactory(procurements);
	}

	public ProcureInfo(Item item)
	{
		dbFactory = new DBFactory(item);
	}

	public ProcureInfo(List<SubItem> lstSubItem)
	{
		dbFactory = new DBFactory(lstSubItem);
	}

	public Object procurement(String option)
	{
		return dbFactory.ProcureOption(option);
	}

}
