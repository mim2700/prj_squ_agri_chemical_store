<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<%@ page contentType="text/html; charset=Cp1252" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-nested" prefix="nested" %>
<html>
<script type="text/javascript" src="<html:rewrite page="/pages/js/datetimepicker.js"/>" ></script>
<head>
<meta http-equiv="Content-Language" content="en-us">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>Store Order Sub Items</title>
</head>

<body>

<table border="1" width="100%" id="table1" cellspacing="0" cellpadding="0">
	<tr>
		<td><b><bean:message key="page.orderAcceptanceSubItemDetail.visionItem"/></b></td>
		<td>&nbsp;</td>
		<td>
		<p align="center"><bean:message key="page.orderAcceptanceSubItemDetail.subItems"/></p>
		<p>&nbsp;</p>
		<p>&nbsp;</td>
	</tr>
	
	
<logic:iterate id="arrItems" name="procurementForm" property="arrItems" >
	<tr>
		<td>
		<table border="1" width="100%" id="table2">
			<tr>
					<bean:message key="page.orderAcceptanceSubItemDetail.visionDept"/>&nbsp;<bean:write name="arrItems" property="deptDestId"/><br><br>
					<bean:message key="page.orderAcceptanceSubItemDetail.visionItemId"/>&nbsp;<bean:write name="arrItems" property="itemCode"/><br>
					<bean:message key="page.orderAcceptanceSubItemDetail.visionItemName"/>&nbsp;<bean:write name="arrItems" property="itemName"/><br>
					<bean:message key="page.orderAcceptanceSubItemDetail.visionItemQty"/>&nbsp;<bean:write name="arrItems" property="itemQuantity"/>
			</tr>
		</table>
		</td>
		<td></td>
		<td>
			<table border="1" width="100%" id="table3" cellspacing="0" cellpadding="0">
					<tr>
						<td><i><bean:message key="page.orderAcceptanceSubItemDetail.ManufacturingDate"/></i></td>
						<td>&nbsp;</td>
						<td><i><bean:message key="page.orderAcceptanceSubItemDetail.ExpiryDate"/></i></td>
						<td>&nbsp;</td>
						<td><i><bean:message key="page.orderAcceptanceSubItemDetail.ActualItemId"/></i></td>
						<td>&nbsp;</td>
					</tr>
				<logic:iterate id="subItems" name="arrItems" property="subItems" indexId="SerialNo">
					<tr>
						<td>
						
						<html:text name="subItems" property="manuDate" readonly="true" indexed="true"></html:text>
						<a href="javascript:NewCal('subItems[<%=SerialNo%>].manuDate','ddmmyyyy')"> 
							<html:img page="/pages/images/cal.gif"/> </a>
						&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td align="right"><font color="blue"><bean:write name="subItems" property="subItemId"/></font></td>
						<td >&nbsp;</td>
					</tr>
				</logic:iterate>
			</table>
		</td>
	</tr>
</logic:iterate>

 

			
			</table>

</body>

</html>