<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-nested" prefix="nested" %>

<%@page import="com.squ.agri.store.bo.Department"%>

<html dir="ltr">

<head>
<meta http-equiv="Content-Language" content="en-us">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>Invitation for Collect the Items</title>

<!-- Link the CSS file here -->
<link rel="stylesheet" type="text/css" media="screen,projection" href="<html:rewrite page="/pages/template/agriStyle.css"/>" />


</head>

<body>

<table border="0" width="100%" height="100%" id="table1">
<tr><td>&nbsp;</td></tr>
	<tr class="pageTitle">
		<td colspan="3">
			<font><bean:message key="page.orderAcceptanceList.heading"/></font>
		</td>
	</tr>
	<tr><td>&nbsp;</td></tr>
	<tr>
		<td>&nbsp;</td>
		<td>
		<table class="approvedPurchaseList" border="1" width="100%" height="100%" id="table2">
			<tr>
				<th>

				<b><font size="4"><bean:message key="page.orderAcceptanceList.serial"/></font></b></th>
				<th >&nbsp;</th>
				<th>

				<b><font size="4"><bean:message key="page.orderAcceptanceList.requisition_No"/></font></b></th>
				<th>&nbsp;</th>
				<th>
				<b><font size="4"><bean:message key="page.orderAcceptanceList.requisition_Date"/></font></b></th>
				<th>&nbsp;</th>
				<th>
				
				<b><font size="4"><bean:message key="page.orderAcceptanceList.invitation_Date"/></font></b></th>
				<th>&nbsp;</th>
				<th >

				<b><font size="4"><bean:message key="page.orderAcceptanceList.invitation_From"/></font></b></th>
			</tr>
			<logic:iterate id="acceptInvitationList" name="listOfProcurements"  indexId="SerialNo">
			<bean:define id="deptId" name="acceptInvitationList" property="deptId" type="java.lang.String"/>
					
				<tr>
					<td>
						<%= (SerialNo+1) %>
					</td>
					<td>&nbsp;</td>
					<td>
					<html:link action="orderAcceptanceItemDetail"  name="acceptInvitationList" property="paramProcure" ><bean:write name="acceptInvitationList" property="prnNo"/>  </html:link>
					</td>
					<td>&nbsp;</td>
					<td>&nbsp;
					<bean:write name="acceptInvitationList" property="prnDate"/></td>
					<td>&nbsp;</td>
					<td>&nbsp;
				
					<bean:write name="acceptInvitationList" property="dtInfoReceived"/></td>
					<td>&nbsp;</td>
					<td>
					 
					<%= new Department().getDeptName(deptId) %>
							
					</td>
				</tr>
			</logic:iterate>
		</table>
		</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
</table>

</body>

</html>
