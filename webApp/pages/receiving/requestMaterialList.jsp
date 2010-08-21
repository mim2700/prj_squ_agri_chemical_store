<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<%@ page import="org.apache.struts.action.Action"%>
<%@ page import="org.apache.struts.taglib.html.Constants"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-nested" prefix="nested" %>

<html:html>

<head>
<meta http-equiv="Content-Language" content="en-us">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title> Request Materials </title>

 <!-- Link the CSS file here -->
<link rel="stylesheet" type="text/css" media="screen,projection" href="<html:rewrite page="/pages/template/agriStyle.css"/>" />

<script language="javascript" type="text/javascript" src="<html:rewrite page="/pages/js/agriStore.js" />"></script>

</head>

<body>

<html:form method="POST" action="/requestItemsResults" >
<input type="hidden" name="<%= Constants.TOKEN_KEY %>" value="<%=session.getAttribute(org.apache.struts.Globals.TRANSACTION_TOKEN_KEY)%>" >

<div align="center">
<table  width="100%" id="table1" class="requestItems">
<tr><td>&nbsp;</td></tr>
	<tr class="pageTitle">
		<td colspan="2">
			<font><bean:message key="page.requestMaterial.heading"/></font>
		</td>
	</tr>
	<tr><td>&nbsp;</td></tr>
	<tr class="break">
		<td colspan="2" >&nbsp;</td>
	</tr>
	<tr >
		<td style="border-style: solid; border-width: 1px" class="body">
			<table width="75%" align="center" id="requests" class="requestedItemsList" border="1" >
			
				<thead >
					<tr>
						<th><bean:message key="page.requestMaterial.itemId"/></th>
						<th><bean:message key="page.requestMaterial.itemName"/></th>
						<th><bean:message key="page.requestMaterial.qty_Requested"/></th>
						<th>&nbsp;</th>
					</tr>
				</thead>
				<tbody >
				<logic:iterate id="newItems" name="requestItemsDetailForm" property="newItems">
					<tr>
						<td>
							<bean:write name="newItems" property="itemCode"/>
						</td>
						<td>
							<bean:write name="newItems" property="itemName"/>
						</td>
						<td> 
							<bean:write name="newItems" property="itemQuantity"/>
						</td>
						<td>
						 &nbsp;</td>
					</tr>
				</logic:iterate>
				</tbody>
			</table>
		</td>
		<td align="center" valign="top" style="border-style: solid; border-width: 1px" class="body">
			<p align="center">
			<!-- input type="button" value="Add New Item" id="addNewItem" onclick = "javascript: addNewRequest();"--></td>
	</tr>
	<tr class="break">
		<td colspan="2" >&nbsp;</td>
	</tr>
	<tr class="pageFooter">
		<table>
			<tr>
				<td style="border-top-style: solid; border-top-width: 1px" >
					<p align="center">
				
					<html:submit property="bttnAddToCart" value="Submit the Request" />
					
					</td>
				<td style="border-top-style: solid; border-top-width: 1px">&nbsp;</td>
				<td style="border-top-style: solid; border-top-width: 1px" >
					<p align="center">
					
					</td>
			</tr>
			<tr>
				<td>
									<html:messages id="errors">
							<table border="1" style="border: thin solid black" cellpadding="3" cellspacing="0"><tr>
									<td style="border:hidden;" ><img src="<html:rewrite page="/pages/images/errorMsg.gif" />" /></td>
									<td style="border:hidden;" ><font color="red"><bean:write name="errors" /></font></td>
							</tr></table>
							
							</html:messages>
				</td>
			</tr>
		</table>
	</tr>
</table>
</div>
</html:form>
</body>

</html:html>
<script >
	function back()
	{
		history.go(-1);
	}
</script>