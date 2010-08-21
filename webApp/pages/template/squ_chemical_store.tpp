cssMenuVerticalDropDown
<$[---COLORS---]$>
<?xml version="1.0" encoding="iso-8859-1"?>
<settings>
	<channel>
		<item>
			<var>_BDYBGR_</var>
			<title>Page (body) Background</title>
			<default>#ffffff</default>
		</item>
		<item>
			<var>_ML_BGR_</var>
			<title>Menu Background</title>
			<default>#000080</default>
		</item>
		<item>
			<var>_ML_TXT_CLR_</var>
			<title>Menu links/items Color</title>
			<default>#FFFF00</default>
		</item>
		<item>
			<var>_ML_SM_BGR_</var>
			<title>Sub-menu Background</title>
			<default>#000080</default>
		</item>
		<item>
			<var>_ML_SM_CLR_</var>
			<title>Sub-menu links/items Color</title>
			<default>#FFFF00</default>
		</item>
		<item>
			<var>_ML_HOV_BGR_</var>
			<title>Menu Hover Background</title>
			<default>#FF0000</default>
		</item>
		<item>
			<var>_ML_HOV_CLR_</var>
			<title>Menu Hover Color</title>
			<default>#FFFF00</default>
		</item>
		<item>
			<var>_ML_S_L_H_O_V_E_R_BGR_</var>
			<class>main menu</class>
			<title>Sub Menu Hover Background</title>
			<default>#B90000</default>
		</item>
		<item>
			<var>_ML_S_L_H_O_V_E_R_CLR_</var>
			<class>main menu</class>
			<title>Sub Menu Hover Color</title>
			<default>#FFFF00</default>
		</item>
		<item>
			<var>_ML_BORDER_</var>
			<class>main menu</class>
			<title>Menu Borders Color</title>
			<default>#A0A0A4</default>
		</item>
	</channel>
</settings>
<$[---COLORS---END---]$>
<$[---FONTS---]$>
<$[---FONTS---SUB---]$>
0
Arial, Helvetica, sans-serif
0.8
em
bold
normal
underline
<$[---FONTS---SUB---END---]$>
<$[---FONTS---END---]$>
<$[---MENUS---]$>
<$[---MENUS---SUB---]$>
Main Menu
mainmenu
	Home|/welcome.do|_self
	Procurement|/checkItems.do|_self
		Check|/checkItems.do|_self
		Order Invitation List|/orderInvitationList.do|
		Order Acceptance List|/orderAcceptanceList.do|
	InHouse Department Activity|/requestMaterials.do|
		Request Form|/requestMaterials.do|
		Approval List|/approvedItemsList.do|
	InHouse Central Store Activity|/requestedItemsList.do|
	Consumption|/consumption.do|
	Adjustment|/adjustments.do|
	Reports|#|
		Present Position|#|
		Transactions|/rptTransactionDt.do|
		Items|#|
		Departments|#|
	Admin|#|
		User|#|
			Create User|/adminUserAdd.do|
			Manage User|/adminUserUpdate.do|
		Item|#|
			Grade|/itemGrade.do|
			Type|/itemType.do|
			Safety|/itemSafety.do|
	Settings|#|
		Change Password|/userChangePwd.do|
	Log out|#|
<$[---MENUS---SUB---END---]$>
<$[---MENUS---END---]$>
