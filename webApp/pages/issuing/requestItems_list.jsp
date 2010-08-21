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
<table border="0" width="100%" height="100%" id="table1" cellspacing="1" cellpadding="0" >
	<tr><td colspan="9">&nbsp;</td></tr>
	<tr class="pageTitle">
		<td colspan="9">
		<font><bean:message key="page.requestedItemsList.heading"/></font></td>
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
		
			<html:form method="POST" action="/requestedItemDetail">
			
			<table class="requestItemsListTable" border="1" width="100%" height="100%" id="table2" cellspacing="1" cellpadding="0">
				<tr>
					<th><b><bean:message key="page.requestedItemsList.lotId"/></b></th>
					<th>&nbsp;</th>
					
					<th><b><bean:message key="page.requestedItemsList.itemCode"/></b></th>
					<th>&nbsp;</th>
					
					<th><b><font size="4"><bean:message key="page.requestedItemsList.itemName"/></font></b></th>
					<th>&nbsp;</th>
					
					
					
					
					<th><b><font size="4"><bean:message key="page.requestedItemsList.qtyRequested"/></font></b></th>
					<th>&nbsp;</th>
					
					<th><b><bean:message key="page.requestedItemsList.departmentId"/></b></th>
					<th>&nbsp;</th>
					
					<th><b><bean:message key="page.requestedItemsList.action"/></b></th>
				</tr>
	<logic:iterate id="reqForm" name="requestItemsDetailForm" property="oldItems">				
				<tr>
					<td><bean:write name="reqForm" property="procureId"/></td>
					<td></td>
					
					<td><bean:write name="reqForm" property="itemCode"/></td>
					<td>&nbsp;</td>
					
					<td><bean:write name="reqForm" property="itemName"/></td>
					<td>&nbsp;</td>
					
					<td><center><bean:write name="reqForm" property="itemQuantity"/></center></td>
					<td>&nbsp;</td>
					
					<td><bean:write name="reqForm" property="deptDestId"/></td>
					<td>&nbsp;</td>
					
					<td><input type="button" name="C1" value="Action" 
						style="border-style: solid; border-width: 1px; 
						padding-left: 4px; padding-right: 4px; padding-top: 1px; padding-bottom: 1px" 
						onclick="javascript:funSubItem('<html:rewrite action="/requestedItemDetail"/>','<bean:write name="reqForm" property="deptDestId"/>')"></td>
				</tr>
</logic:iterate>				
				</table>
			
			</html:form>
		
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
</table>

</body>

<script language="javascript">
function funSubItem(url,deptId) {
	requestItemsDetailForm.action="http://"+location.host+url+"?deptId="+deptId;
	requestItemsDetailForm.submit();
	
}
</script>
</html:html>