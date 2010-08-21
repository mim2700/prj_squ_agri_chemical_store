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


</head>
<html:form method="POST" action="/acptInvitationResults" >
<body>
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
									   <html:hidden name="purchaseOrder" property="prnNo" />
									   <bean:parameter id="procId" name="procureId"/>
									   <html:hidden   property="procureId" value="<%=procId%>" />
									   
									   
									   </td>
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
		<td class="even" >&nbsp;<p dir="ltr">&nbsp;</td>
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
	<tr >
		<td>&nbsp;</td>
		<td colspan="7" class="footer">
		
		<p dir="ltr" align="center"><html:submit value="Accept Invitation" />
		
		</td>
		<td>&nbsp;</td>
	
	</tr>

</table>
	</html:form>

</body>

</html:html>