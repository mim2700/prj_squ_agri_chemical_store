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
 * Package Name   : com.squ.agri.store
 * File Name      : StoreConstants.java
 * 
 * Date           : Aug 31, 2009
 * 
 */
package com.squ.agri.store;

/**
 * @author Administrator
 * 
 */
public interface StoreConstants
{
	/****************** Different types of procurement number **************/
	public static final char ProcurePRN = 'p';
	public static final char ProcureLPO = 'l';
	public static final char ProcureGRN = 'g';

	/****************** Different types of procurement option **************/
	public static final String procureVISION_PURCHASE_ORDER = "vision_purchase_order";
	public static final String PROCURE_SEND_INFO = "send_invitation";
	public static final String PROCURE_VIEW_INFO = "view_invitation";
	public static final String PROCURE_RECEIVE_INFO = "receive_invitation";
	public static final String PROCURE_VIEW_ACCEPTED_INVITATION = "view_accpeted_invitation";
	public static final String PROCURE_STORE_ITEMS_SUBITEMS = "store_items_subitems";
	public static final String PROCURE_STORE_SUBITEMS = "store_subitems";
	public static final String PROCURE_STORE = "procure_store";

	/****************** Different ITEM properties ************/
	public static final String GRADE = "GRADE";
	public static final String SAFETY = "SAFETY";
	public static final String TYPE = "TYPE";

	/****************** Different type of user login operation ************/
	public static final String UserLogin = "login";
	public static final String USER_ADD = "userAdd";
	public static final String USER_MODIFY = "userUpdate";
	public static final String USER_ACTIVATE = "userActivate";
	public static final String USER_DEACTIVATE = "userDeactivate";

	/****************** Department ************/
	public static final String DEPARTMENT = "DEPARTMENT";

	/****************** Measurment ************/
	public static final String MEASURMEN = "MEASURMEN";

	/****************** Variation ************/
	public static final String VARIATION = "VARIATION";

	/****************** Adjustment ************/
	public static final String ADJUSTMENT = "ADJUSTMENT";
	public static final String ADJUSTMENT_List_All = "ADJUSTMENT_LIST_ALL";
	public static final String ADJUSTMENT_GET_OBJECT = "ADJUSTMENT_GET_OBJECT";

	/****************** In House Material Receiving ************/
	public static final String INHOUSE_MATERIAL_REQUEST = "inhouse_material_request";
	public static final String INHOUSE_MATERIAL_REQUEST_ADD = "inhouse_material_request_add";
	public static final String INHOUSE_ALLOCATION_REQUEST_LIST = "inhouse_allocation_request_list";

	/****************** In House Material Issuing ************/
	public static final String INHOUSE_ALLOCATION_AVIALABLE_LIST = "inhouse_allocation_avialable_list";
	public static final String INHOUSE_ALLOCATION_ISSUE_ITEMS = "inhouse_allocation_issue_items";

	/****************** In House Material Accept ************/
	public static final String INHOUSE_ALLOCATION_ACCEPT_LIST = "inhouse_allocation_accept_list";
	public static final String INHOUSE_ALLOCATION_ACCEPTED_ITEMS = "inhouse_allocation_accepted_items";

	/****************** Department Material Consuming ************/
	public static final String CONSUME_SUBITEM_DEPARTMENT = "consume_subItem_department";

	public static final String ALL_USERS = "ALL_USERS";

	/****************** Application.properties Constants ************/
	public static final String MSG_CENTRAL_STORE_ID = "centralStoreId";

	/****************** Different type of session object ************/
	public static final String SESSION_USER = "session_user";
	
	/****************** Different type of session object ************/
	public static final String DUMMY_STRING_SQL_DATE	=	"1900-01-01";
}
