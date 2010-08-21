<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-nested" prefix="nested" %>

<html:html>

<head>
<meta http-equiv="Content-Language" content="en-us">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>Invitation for Collect the Items</title>

<!-- Link the CSS file here -->
<link rel="stylesheet" type="text/css" media="screen,projection" href="<html:rewrite page="/pages/template/agriStyle.css"/>" />


</head>


<body>
<table border="0" width="100%" height="100%" id="table1">
	<tr>
		<td>&nbsp;</td>
	</tr>
	<tr class="pageTitle">
		<td  colspan="3">
			<font><bean:message key="page.orderInvitationList.heading"/></font>
		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>
		<table class="invitationItemsList" border="1" width="100%" height="100%" id="table2">
			<tr>
				<th>

				<b><font size="4"><bean:message key="page.orderInvitationList.serial"/></font></b></th>
				<th >&nbsp;</th>
				<th>

				<b><font size="4"><bean:message key="page.orderInvitationList.requisition_No"/></font></b></th>
				<th>&nbsp;</th>
				<th>
				<b><font size="4"><bean:message key="page.orderInvitationList.requisition_Date"/></font></b></th>
				<th>&nbsp;</th>
				<th>
				
				<b><font size="4"><bean:message key="page.orderInvitationList.invitation_Date"/></font></b></th>
				<th>&nbsp;</th>
				<th >

				<b><font size="4"><bean:message key="page.orderInvitationList.invitation_From"/></font></b></th>
			</tr>
			<logic:iterate id="inviteList" name="lstProcurementInfo"  indexId="SerialNo">
			<tr>
				<td><bean:write name="SerialNo" />

				</td>
				<td>&nbsp;</td>
				<td>
				<html:link action="orderInvitationItemDetail"  name="inviteList" property="paramProcure" ><bean:write name="inviteList" property="prnNo"/>  </html:link></td>
				<td>&nbsp;</td>
				<td>
				&nbsp;</td>
				<td>&nbsp;</td>
				<td>
			
				<bean:write name="inviteList" property="dtInfoReceived"/></td>
				<td>&nbsp;</td>
				<td>

				<bean:write name="inviteList" property="deptSourceId"/></td>
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

</html:html>
