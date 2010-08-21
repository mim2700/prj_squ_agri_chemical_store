<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<%@ page contentType="text/html; charset=Cp1252" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-nested" prefix="nested" %>
<html:html>

<head>
<meta http-equiv="Content-Language" content="en-us">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>Item Details</title>

<!-- Link the CSS file here -->

<link rel="stylesheet" type="text/css" media="screen,projection" href="<html:rewrite page="/pages/template/agriStyle.css"/>" />

<!-- Link the JS file here -->
 <script language="javascript" type="text/javascript" src="<html:rewrite page="/pages/js/agriStore.js"/>"></script>

</head>
<body>
<logic:empty name="CheckItemsDynaForm" property="prnNo">
	<font color="red">There is no Items.</font>
</logic:empty>
<!-- logic:notEmpty name="CheckItemsDynaForm" property="txtLpoNo" -->
<html:form method="post" action="/checkItemDetailResult">
<table class="itemDetails" border="0" width="100%" height="100%" id="table1" cellspacing="1" cellpadding="0">
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr class="pageTitle">
		<td colspan="8">
			<font><bean:message key="page.checkItemDetail.heading"/></font>
		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td colspan="4">
		<p align="center" dir="ltr">&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td class="odd" ><p dir="ltr"><bean:message key="page.checkItemDetail.PR_Number"/></td>
		<td class="even" ><p dir="ltr"><bean:write name="purchaseOrder" property="prnNo"/>
									   <html:hidden name="purchaseOrder" property="prnNo" /></td>
		<td><p dir="ltr">&nbsp;</td>
		<td class="odd" ><p dir="ltr"><bean:message key="page.checkItemDetail.PR_Date"/></td>
		<td class="even" ><p dir="ltr">&nbsp;</td>
		<td><p dir="ltr">&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td class="odd" ><p dir="ltr"><bean:message key="page.checkItemDetail.LPO_Number"/></td>
		<td class="even" ><p dir="ltr"><bean:write name="purchaseOrder" property="lpoNo" />
									   <html:hidden name="purchaseOrder" property="lpoNo" /></td>
		<td>&nbsp;</td>
		<td class="odd" ><p dir="ltr"><bean:message key="page.checkItemDetail.LPO_Date"/></td>
		<td class="even" ><p dir="ltr"><bean:write name="purchaseOrder" property="dateLpo"/></td>
		<td><p dir="ltr">&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td class="odd" ><p dir="ltr"><bean:message key="page.checkItemDetail.GRN_Number"/></td>
		<td class="even" ><p dir="ltr">&nbsp;
									   <html:hidden name="purchaseOrder" property="grnNo" />
		</td>
		<td>&nbsp;</td>
		<td class="odd" ><p dir="ltr"><bean:message key="page.checkItemDetail.GRN_Date"/></td>
		<td class="even" ><p dir="ltr">&nbsp;</td>
		<td><p dir="ltr">&nbsp;</td>
		
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td class="odd" ><p dir="ltr"><bean:message key="page.checkItemDetail.emplyeeName"/></td>
		<td class="even" >&nbsp;</td>
		<td><p dir="ltr">&nbsp;</td>
		<td class="odd" ><p dir="ltr"><bean:message key="page.checkItemDetail.department"/> </td>
		<td class="even" >&nbsp;</td>
		<td><p dir="ltr">&nbsp;</td>
	
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td class="odd" ><p dir="ltr"><bean:message key="page.checkItemDetail.supplierName"/></td>
		<td class="even" ><bean:write name="purchaseOrder" property="supplierName"/>
		<html:hidden name="purchaseOrder" property="supplierId" /></td>
		<td><p dir="ltr">&nbsp;</td>
		<td class="odd" >&nbsp;</td>
		<td class="even" >&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td class="odd" ><p dir="ltr"><bean:message key="page.checkItemDetail.productGroup"/></td>
		<td class="even" ><bean:write name="purchaseOrder" property="productGroup"/></td>
		<td>&nbsp;</td>
		<td class="odd" >&nbsp;</td>
		<td class="even" >&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td colspan="7" rowspan="5">
		
		<table class="itemDetailsProducts" border="0" width="100%" height="100%" id="table2" >
			<tr>
				<th>
				<p dir="ltr"><bean:message key="page.checkItemDetail.productCode"/></th>
				<th >&nbsp;</th>
				<th >
				<p dir="ltr"><bean:message key="page.checkItemDetail.productName"/></th>
				<th >
				<p dir="ltr">&nbsp;</th>
				<th >
				<p dir="ltr"><bean:message key="page.checkItemDetail.productQuantity"/></th>
				
			</tr>
			<tbody>
			<logic:iterate id="setOfItems" name="purchaseOrder" property="items" >
			<tr>
				<td align="center"><bean:write name="setOfItems" property="itemCode"/></td>
				<td>&nbsp;</td>
				<td><bean:write name="setOfItems" property="itemName"/></td>
				<td>&nbsp;</td>
				<td align="center"><bean:write name="setOfItems" property="itemQuantity"/></td>
			</tr>
			</logic:iterate>
			</tbody>
		</table>
		
		</td>
	
	</tr>
	<tr>
		<td>&nbsp;</td>
		
	</tr>
	<tr>
		<td>&nbsp;</td>
		
	</tr>
	<tr>
		<td>&nbsp;</td>
		
	</tr>
	<tr>
		<td>&nbsp;</td>
		
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td colspan="7">
		<table border="1" width="100%" id="table3"  class="itemDetailsFooter">
			
			<tr>
				<td>
				<p dir="ltr" align="center">
				<input type="button" value="Send Invitaion to Department" onclick="check_checkItemsDetails_Empty_and_submit()" />
				</td>
				<td>&nbsp;</td>
				<td>
				<p dir="ltr">
					<logic:equal name="CheckItemsDynaForm" property="userRole" value="Central_Store">
						<html:select property="deptDestId">
							<html:option value="0">Select Department</html:option>
							<html:optionsCollection  name="allDepartments"  label="deptName" value="deptId" /> 
						</html:select>
					</logic:equal>
					
					<logic:notEqual name="CheckItemsDynaForm" property="userRole" value="Central_Store">
						<html:select name="CheckItemsDynaForm" property="deptDestId" disabled="true">
							<html:option value="0">Select Department</html:option>
							<html:optionsCollection  name="allDepartments"  label="deptName" value="deptId" /> 
						</html:select>
						<bean:define id="deptId" name="CheckItemsDynaForm" property="deptDestId"/>
						<input type="hidden" name="deptDestId" value="<%= deptId %>" />
						
					</logic:notEqual>
					
				</td>
				<td>&nbsp;</td>
				<td>
				<p dir="ltr">Department Name</td>
			</tr>
			
		</table>
		</td>

	
	</tr>
</table>
	</html:form>
<!-- /logic:notEmpty -->
</body>

</html:html>