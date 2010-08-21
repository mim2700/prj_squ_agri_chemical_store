<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
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

<body>
			<html:form method="POST" action="/requestedItemsIssue">
<table border="0" width="100%" height="100%" id="table1" cellspacing="1" cellpadding="0" >
	<tr><td colspan="9">&nbsp;</td></tr>
	<tr class="pageTitle">
		<td colspan="9">
		<font><bean:message key="page.IssueItemsList.heading"/></font></td>
	</tr>
		<tr><td colspan="9">&nbsp;</td></tr>
	<tr>
		<td>&nbsp;</td>
		<td colspan="7">

		</td>
		<td>&nbsp;</td>
	</tr>
	<tr><td colspan="9">&nbsp;</td></tr>
	<tr>
		<td>&nbsp;</td>
		<td colspan="7">
		

			
			<table class="requestItemsListTable" border="1" width="100%" height="100%" id="table2" cellspacing="1" cellpadding="0">
				<tr>
					<th><b><bean:message key="page.requestedItemsList.lotId"/></b></th>
					<th>&nbsp;</th>
					
					<th><b><bean:message key="page.requestedItemsList.itemCode"/></b></th>
					<th>&nbsp;</th>
					
					<th><b><font size="4"><bean:message key="page.requestedItemsList.itemName"/></font></b></th>
					<th>&nbsp;</th>
					
					<th><b><font size="4"><bean:message key="page.IssueItemsList.subItemCode"/></font></b></th>
					<th>&nbsp;</th>
					
									
				</tr>
	<logic:iterate id="reqForm" name="requestItemsDetailForm" property="adjustedItems">				
				<tr>
				
					<td><bean:write name="reqForm" property="procureId"/></td>
					<td></td>
					
					<td><bean:write name="reqForm" property="itemCode"/></td>
					<td>&nbsp;</td>
					
					<td><bean:write name="reqForm" property="itemName"/></td>
					<td>&nbsp;</td>
					<td>
					<table border=1>
						<tr>
							<th><bean:message key="page.IssueItemsList.subItemCode"/></th>
							<th><bean:message key="page.IssueItemsList.manuDate"/></th>
							<th><bean:message key="page.IssueItemsList.expiryDate"/></th>
							<th><bean:message key="page.IssueItemsList.total.alocated"/></th>
						</tr>
						<logic:iterate id="subItems" name="reqForm" property="subItems">
									<tr>
										<td><bean:write name="subItems" property="subItemId"/></td>
										<td><bean:write name="subItems" property="manuDate"/></td>
										<td><bean:write name="subItems" property="expireDate"/></td>
										<td><center><bean:write name="subItems" property="qtyAvailable"/></center></td>
									</tr>
						</logic:iterate>
					</table>
					</td>


				</tr>
</logic:iterate>				
				</table>
			
			
		
		</td>
		<td>&nbsp;</td>
	</tr>
	<tr class="pageFooter">
		<td colspan="9">
		<p align="center"></td>
	</tr>
	<tr><td colspan="9">&nbsp;</td></tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr><td colspan="9"><center><html:submit value="Issue Materials"></html:submit></center></td></tr>
</table>
</html:form>
</body>

</html:html>