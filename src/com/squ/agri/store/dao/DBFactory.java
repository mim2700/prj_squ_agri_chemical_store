package com.squ.agri.store.dao;

import java.util.List;

import com.squ.agri.store.StoreConstants;
import com.squ.agri.store.bo.Item;
import com.squ.agri.store.bo.Procurements;
import com.squ.agri.store.bo.SubItem;
import com.squ.agri.store.dao.inHouse.ConsumeSubItemsDb;
import com.squ.agri.store.dao.inHouse.InHouseDao;
import com.squ.agri.store.dao.inHouse.InHouseMaterialAcceptDb;
import com.squ.agri.store.dao.inHouse.InHouseMaterialApproveDb;
import com.squ.agri.store.dao.inHouse.InHouseMaterialReceiveDb;
import com.squ.agri.store.dao.procure.ProcureDao;
import com.squ.agri.store.dao.procure.ProcureDbPRN;
import com.squ.agri.store.dao.procure.ProcureInfoDb;
import com.squ.agri.store.dao.users.UserDB;
import com.squ.agri.store.dao.users.UserDao;
import com.squ.agri.store.users.User;

public class DBFactory
{

	private Procurements procurements = null;
	private UserDao userdao = null;
	private Item item = null;
	private ProcureDao procuredao = null;

	public DBFactory()
	{
	};

	public DBFactory(Procurements procurements)
	{
		procuredao = new ProcureInfoDb(procurements);
	}

	public DBFactory(User user)
	{
		this.userdao = new UserDB(user);
	}

	public DBFactory(Item item)
	{
		procuredao = new ProcureInfoDb(item);

	}

	public DBFactory(List<SubItem> lstSubItem)
	{
		procuredao = new ProcureInfoDb(lstSubItem);

	}

	public ProcureDao findProcureItems(String procureNo, char procureNoType)
	{
		ProcureDao procuredao = null;
		if (procureNoType == StoreConstants.ProcurePRN)
		{
			procuredao = new ProcureDbPRN(procureNo);
		}
		return procuredao;
	}

	public Object ProcureOption(String option)
	{

		return procuredao.procurement(option);
	}

	public Object storeItemOption(String option)
	{
		// ProcureDao procuredao = new ProcureInfoDb(item);
		return procuredao.procurement(option);
	}

	public Object getUserOption(String option)
	{
		if (option.equals(StoreConstants.USER_ADD))
		{
			return userdao.createUser();
		}
		if (option.equals(StoreConstants.USER_MODIFY))
		{
			return userdao.updateUser();
		}
		if (option.equals(StoreConstants.ALL_USERS))
		{
			return userdao.getAllUser();
		}

		return null;
	}

	/******************** In House Operations ****************/
	public Object inHouseOperation(Object obj, String option)
	{
		InHouseDao inHouseDao = null;
		if (option.equals(StoreConstants.INHOUSE_MATERIAL_REQUEST))
		{
			inHouseDao = new InHouseMaterialReceiveDb(option);
		}
		if (option.equals(StoreConstants.INHOUSE_MATERIAL_REQUEST_ADD))
		{
			inHouseDao = new InHouseMaterialReceiveDb(option);
		}
		if (option.equals(StoreConstants.CONSUME_SUBITEM_DEPARTMENT))
		{
			inHouseDao = new ConsumeSubItemsDb();
		}
		if (option.equals(StoreConstants.INHOUSE_ALLOCATION_REQUEST_LIST))
		{
			inHouseDao = new InHouseMaterialApproveDb(option);
		}
		if (option.equals(StoreConstants.INHOUSE_ALLOCATION_AVIALABLE_LIST))
		{
			inHouseDao = new InHouseMaterialApproveDb(option);
		}
		if (option.equals(StoreConstants.INHOUSE_ALLOCATION_ISSUE_ITEMS))
		{
			inHouseDao = new InHouseMaterialApproveDb(option);
		}
		if (option.equals(StoreConstants.INHOUSE_ALLOCATION_ACCEPT_LIST))
		{
			inHouseDao = new InHouseMaterialAcceptDb(option);
		}
		if (option.equals(StoreConstants.INHOUSE_ALLOCATION_ACCEPTED_ITEMS))
		{
			inHouseDao = new InHouseMaterialAcceptDb(option);
		}

		return inHouseDao.inHouseOperation(obj);
	}

}
