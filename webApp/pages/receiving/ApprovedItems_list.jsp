<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-nested" prefix="nested" %>

<html:html>

<head>
<meta http-equiv="Content-Language" content="en-us">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>List of Requested Items</title>

<!-- Link the CSS file here -->
<link rel="stylesheet" type="text/css" media="screen,projection" href="<html:rewrite page="/pages/template/agriStyle.css"/>" />

</head>

<html:form method="POST" action="/storeApprovedItemsResults">

<body>
<table border="0" width="100%" height="100%" id="table1" cellspacing="1" cellpadding="0" >
	<tr><td colspan="13">&nbsp;</td></tr>
	<tr class="pageTitle">
		
		<td colspan="13">
			<font><bean:message key="page.approvedItemsList.heading"/></font>
		</td>
	</tr>
	<tr><td colspan="13">&nbsp;</td></tr>

	<tr><td>&nbsp;</td><td colspan="10">&nbsp;</td><td>&nbsp;</td></tr>
	<tr>
		<td>&nbsp;</td>
		<td colspan="10">

		<table border="1" width="100%" height="100%" id="table2" cellspacing="1" cellpadding="0" class="approvedItemsList">
			<tr>
				
				<th><b><bean:message key="page.approvedItemsList.lotId"/></b></th>
				<th>&nbsp;</th>
				
				<th><b><bean:message key="page.approvedItemsList.itemCode"/></b></th>
				<th>&nbsp;</th>
				
				<th><b><font size="4"><bean:message key="page.approvedItemsList.itemName"/></font></b></th>
				<th>&nbsp;</th>
				<th><b><font size="4"><bean:message key="page.approvedItemsList.subItem"/></font></b></th>
				<th>&nbsp;</th>

			</tr>
			<tbody>
			<logic:iterate id="items" name="requestItemsDetailForm" property="newItems">
			<tr>
				<td bgcolor="#C0C0C0" dir="ltr" valign="top"><bean:write name="items" property="procureId"/></td>
				<td bgcolor="#C0C0C0" dir="ltr" valign="top">&nbsp;</td>
				
				<td bgcolor="#C0C0C0" dir="ltr" valign="top"><p align="right"><bean:write name="items" property="itemCode"/></td>
				<td bgcolor="#C0C0C0" dir="ltr" valign="top"></td>
				
				<td bgcolor="#C0C0C0" dir="ltr" valign="top"><p align="left"><bean:write name="items" property="itemName"/></td>
				<td bgcolor="#C0C0C0" dir="ltr" valign="top">&nbsp;</td>

				<td bgcolor="#C0C0C0" dir="ltr" valign="top"><p align="left">
					<table>
					<tr>
					<th><bean:message key="page.approvedItemsList.subItemId"/></th>
					<th><bean:message key="page.approvedItemsList.subItemQty"/></th>
					</tr>
					<logic:iterate id="subItems" name="items" property="subItems">
					<tr>
						<td><bean:write name="subItems" property="subItemId"/></td>
						<td><center><bean:write name="subItems" property="qtyAvailable"/></center></td>
					</tr>	
					</logic:iterate>
					
					</table>
				</td>
				<td bgcolor="#C0C0C0" dir="ltr" valign="top">&nbsp;</td>
				
			</tr>
			</logic:iterate>
			</tbody>
			</table>

		</td>
		
		<td>&nbsp;</td>
		
	</tr>
	<tr>
		<td colspan="13">&nbsp;</td>
		
	</tr>
	<tr  class="pageFooter">
		<td colspan="13" align="center">
		<html:submit value="Store Items" />
		</td>
		
	</tr>
	<tr>
		<td colspan="13">&nbsp;</td>
	</tr>
</table>

</html:form>

</body>

</html:html>
