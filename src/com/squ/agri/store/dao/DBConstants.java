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
 * Package Name   : com.squ.agri.store.dao
 * File Name      : DBConstants.java
 * 
 * Date           : Aug 31, 2009
 * 
 */
package com.squ.agri.store.dao;

/**
 * @author Administrator
 * 
 */
public interface DBConstants
{
	/*********************************** HQL *******************************************/
	public static final String hql_PO_PRN = "from PurchaseOrder where prnNo=?";
	public static final String hql_DEPARTMENT = "from Department where collegeId = '7022'"; // This
	// id
	// (7022)
	// is
	// mentioned
	// in
	// vision
	public static final String hql_GRADE_ALL = "from Grade";
	public static final String hql_GET_GRADE = "from Grade where gradeId=:gradeID";
	public static final String hql_SAFETY_ALL = "from Safety";
	public static final String hql_GET_SAFETY = "from Safety where safetyId=:safetyID";
	public static final String hql_TYPE_ALL = "from Type";
	public static final String hql_GET_TYPE = "from Type where typeId=:typeID";
	public static final String hql_GET_MEASURMENT = "from Measurment where measurment_Id=:measurmentID";
	public static final String hql_MEASURMENT_ALL = "from Measurment";
	public static final String hql_GET_VARIATION = "from Variation where variation_Id=:variationID";
	public static final String hql_VARIATION_ALL = "from Variation";
	public static final String hql_ADJUSTMENT_ALL = "from Adjustment where sa_active='y' order by adjustment_id asc";
	public static final String hql_GET_ADJUSTMENT = "from Adjustment where ADJUSTMENT_ID=:adjustment_id";

	public static final String hql_GET_ITEM = "from MT_PRODUCT where vision_item_id=:item_id";

	// public static final String hql_USER="from users where user_id=?";

	/**************************** STORED PROCEDURE/FUNCTIONS **************************/

	public static final String hql_sp_FUNC_PROCURE_ITEMS = "sp_procureItems";
	public static final String hql_sp_FUN_PROC_RECEIVED_INVITATION = "sp_receiveProcureInvitation";
	public static final String hql_sp_FUNC_CREATE_USER = "sp_userCreate";
	public static final String hql_sp_FUNC_STORE_ITEM_SUBITEM = "sp_insert_Item_And_SubItem";
	public static final String hql_sp_FUNC_STORE_SUBITEM = "sp_update_SubItem";
	public static final String hql_sp_FUNC_PROCURE_ITEMS_STORE = "sp_procureStore";
	public static final String hql_sp_FUNC_IN_HOUSE_REQUEST_ITEMS = "sp_inHouseRequestItems";
	public static final String hql_sp_FUNC_CONSUME_DEPT_SUBITEMS = "sp_consume_dept_SubItem";
	public static final String hql_sp_FUNC_IN_HOUSE_ITEMS_LIST = "sp_inHouseItemsList";
	public static final String hql_sp_FUNC_IN_HOUSE_SUBITEM_LIST = "sp_inHouseSubItemsList";
	public static final String hql_sp_FUNC_LOT_ALLOCATION_ADD_LOT = "sp_lot_inHouse_request_add_lot";
	public static final String hql_sp_FUNC_LOT_ALLOCATION_ADD_ITEMS = "sp_lot_inHouse_request_add_items";
	public static final String hql_sp_FUNC_LOT_ALLOCATION_REQUESTED_ITEMS = "sp_lot_inHouse_requested_items";
	public static final String hql_sp_FUNC_LOT_ALLOCATION_AVILABLE = "sp_lot_inHouse_avialable_items";
	public static final String hql_sp_FUNC_LOT_ALLOCATION_ISSUE_ITEMS = "sp_lot_inHouse_issue_items";
	public static final String hql_sp_FUNC_LOT_ALLOCATION_ACCEPT_LIST = "sp_lot_inHouse_accept_items_list";
	public static final String hql_sp_FUNC_LOT_ALLOCATION_ACCEPTED = "sp_lot_inHouse_accepted_items";
	public static final String hql_sp_FUNC_ADJUSTMENT = "sp_adjustment";
	public static final String hql_sp_FUNC_ADJUST_SUBITEM = "sp_adjust_subitems";
	public static final String hql_sp_FUNC_PRODUCT_SINGLE_ITEM = "sp_product";
	public static final String hql_sp_FUNC_GET_ALL_AGRI_VISION_ITEMS = "sp_get_all_agri_vision_items";

	/**************************** LOADING QUERY *********************************/
	public static final String hql_namedQueryLoad_PROCUREINVITE = "procureInvite";
	public static final String hql_namedQueryLoad_PROCURE_INVITE_ACCEPT_VIEW = "procureInviteAccptView";
	public static final String hql_namedQueryLoad_USERS = "usersList";
	public static final String hql_namedQueryLoad_ROLES = "rolesList";
	public static final String hql_namedQueryLoad_GETUSER = "getUser";

}
