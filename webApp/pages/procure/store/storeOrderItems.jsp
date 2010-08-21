<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page contentType="text/html; charset=Cp1252" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-nested" prefix="nested" %>

<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Pragma" content="no-cache"> 
<META HTTP-EQUIV="Expires" CONTENT="-1">
<!-- Link the JS file here -->
 <script language="javascript" type="text/javascript" src="<html:rewrite page="/pages/js/agriStore.js" />"></script>

<html:html>

<title>Store Items CS</title>

<!-- Link the CSS file here -->
<link rel="stylesheet" type="text/css" media="screen,projection" href="<html:rewrite page="/pages/template/agriStyle.css"/>" />

</head>

<body >

 <html:form method="POST" action="/storeItemsDetailResults">
 
<table border="0" style="width: 100%; ">
<tr><td>&nbsp;</td></tr>
<tr class="pageTitle">
		<td>
			<font><bean:message key="page.orderAcceptanceItemDetail.heading"/></font>
		</td>
</tr>
<tr><td>&nbsp;</td></tr>	
<tr><td>
<table id="requestDetails" width="70%" class="orderAcptRequestDetails">

	<tr id="rd1" >
		<td class="label" ><b><bean:message key="page.orderAcceptanceItemDetail.PR_Number"/></b> </td>
		<td id="requesisionNoField" class="input"> <bean:write name="purchaseOrder" property="prnNo"/> 
										<html:hidden name="purchaseOrder" property="prnNo" />
									    <bean:parameter id="procId" name="procureId"/>
									    <html:hidden   property="procureId" value="<%=procId%>" />
		</td>
		<td width="10%">&nbsp; </td>
		<td class="label" > <b><bean:message key="page.orderAcceptanceItemDetail.PR_Date"/></b> </td>
		<td id="RN_Date" class="input" > <bean:write name="purchaseOrder" property="datePrn"/> </td>
	</tr>
	<tr id="rd2">	
		<td class="label" > <b><bean:message key="page.orderAcceptanceItemDetail.LPO_Number"/></b> </td>
		<td id="lpoNoField" class="input" ><bean:write name="purchaseOrder" property="lpoNo" /> </td>
		<td width="10%">&nbsp; </td>
		<td class="label" > <b><bean:message key="page.orderAcceptanceItemDetail.LPO_Date"/></b> </td>
		<td id="LPO_Date" class="input" > <bean:write name="purchaseOrder" property="dateLpo"/> </td>
		
	</tr>
	<tr>	
		<td class="label"  > <b><bean:message key="page.orderAcceptanceItemDetail.GRN_Number"/></b> </td>
		<td id="grnNoField" class="input" > <bean:write name="purchaseOrder" property="grnNo" /> </td>
		<td width="10%">&nbsp; </td>
		<td class="label" > <b><bean:message key="page.orderAcceptanceItemDetail.GRN_Date"/></b> </td>
		<td id="GRN_Date" class="input" > &nbsp;</td>
		
	</tr>
	
	<tr>
	
		<td class="label" > <b><bean:message key="page.orderAcceptanceItemDetail.supplierCode"/></b> </td>
		<td id="supplierCodeField" class="input" > <bean:write name="purchaseOrder" property="supplierId" /> </td>
		<td width="10%">&nbsp; </td>
		<td class="label"  > <b><bean:message key="page.orderAcceptanceItemDetail.supplierName"/></b> </td>
		<td id="supplierNameField" class="input" > <bean:write name="purchaseOrder" property="supplierName" /> </td>
		
	</tr>
	
	<tr>
		<td class="label" > <b><bean:message key="page.orderAcceptanceItemDetail.productGroup"/></b> </td>
		<td id="productGroupField" class="input" ><bean:write name="purchaseOrder" property="productGroup" /></td>
		<td width="10%">&nbsp; </td>
		<td class="label" > <b><bean:message key="page.orderAcceptanceItemDetail.productGroupName"/></b> </td>
		<td id="productGroupNameField" class="input" > &nbsp; </td>
	</tr>
	
</table>
</td></tr>
<tr><td>&nbsp;</td></tr>
<tr><td>  
 	<b><bean:message key="page.orderAcceptanceItemDetail.selectDepartment"/></b> &nbsp; 
				<html:select property="deptDestId" onchange="updateDepartmentList(value)">
					<html:option value="0">Select Department</html:option>
					<html:optionsCollection  name="allDepartments"  label="deptName" value="deptId" /> 
				</html:select>
	
</td></tr>
<tr><td>&nbsp;</td></tr>
<tr><td>
<table id="productDetails" style="width: 100%;" class="orderAcptItemDetails"  cellpadding="0" runat ="server">

	<tr>
		<th class="style1" width="3%" align="center"><b><bean:message key="page.orderAcceptanceItemDetail.serial"/></b></th>
		<th class="style1" width="5%" align="center"><b><bean:message key="page.orderAcceptanceItemDetail.product_id"/></b></th>
		<th class="style1"  align="center"><b><bean:message key="page.orderAcceptanceItemDetail.product_name"/></b></th>
		<th class="style1" width="3%" align="center"><b><bean:message key="page.orderAcceptanceItemDetail.type"/></b></th>
		<th class="style1" width="4%" align="center"> 
		    <b> 
		    <bean:message key="page.orderAcceptanceItemDetail.saftey"/>
			</b>
		</th>
		<th class="style1" width="4%" align="center"> 
		    <b> 
		    <bean:message key="page.orderAcceptanceItemDetail.measurment"/>
			</b>
		</th>
		<th class="style1" width="6%" align="center"><b><bean:message key="page.orderAcceptanceItemDetail.receivedQty"/></b> </th>
		<!--   th class="style1" width="6%" align="center"><b><bean:message key="page.orderAcceptanceItemDetail.totalQty"/></b> </th -->
		<th class="style1" width="25%" align="center"><b><bean:message key="page.orderAcceptanceItemDetail.department"/></b></th>
		<th class="style1" width="5%" align="center"><b><bean:message key="page.orderAcceptanceItemDetail.qty"/></b></th>
		<th class="style1" width="10%" align="center"><b><bean:message key="page.orderAcceptanceItemDetail.cs_Qty"/></b></th>
		<th class="style1" width="10%" align="center"><b><bean:message key="page.orderAcceptanceItemDetail.mutipleSubitems"/></b></th>
		<th class="style1" width="11%" align="center"><b><bean:message key="page.orderAcceptanceItemDetail.itemDetail"/></b></th>
		<th class="style1" width="13%" ><b><bean:message key="page.orderAcceptanceItemDetail.status"/></b></th>
	</tr>
<logic:iterate id="arrItems" name="procurementForm" property="arrItems" indexId="arrIndex">	
	<tr>
		<td class="style3" width="3%" valign="top" ><%= (arrIndex+1) %></td>
		<td class="style3" width="5%" valign="top" ><bean:write name="arrItems" property="itemCode"/></td>
		<td class="style3" width="6%" valign="top" ><bean:write name="arrItems" property="itemName"/></td>
		<td class="style3" width="3%" valign="top" >
			<html:select name="arrItems" property="type" style="font-size:x-small;" indexed="true">
					<html:option value="0">Select Type</html:option>
					<html:optionsCollection  name="allTypes"  label="typeName" value="typeId" /> 
			</html:select>
		</td>
		<td class="style3" width="4%" valign="top" >
			<html:select name="arrItems" property="safety" style="font-size:x-small;" indexed="true">
				<html:option value="0">Select Safety</html:option>
				<html:optionsCollection  name="allSafetys"  label="un_Number" value="safetyId" /> 
			</html:select>
		</td>
		<td class="style3" width="4%" valign="top" >
			<html:select name="arrItems" property="measurment" style="font-size:x-small;" indexed="true">
				<html:option value="0">Select Measurment</html:option>
				<html:optionsCollection  name="allMeasurments"  label="measurment_Unit" value="measurment_Id" /> 
			</html:select>
		</td>
		<td class="style3" width="6%" valign="top" >
			
			<input name="txtReceived_Qty_p_1" id="Received_Qty<%= arrIndex %>" type="text" size="5" value='<bean:write name="arrItems" property="itemQuantity"/>'  style="width: 60px" readonly /></td>
					
		<td class="style3"  valign="top">    
			<html:select name="arrItems" property='deptDestId' indexed="true" style="font-size:x-small;" >
				<html:option value="0">Select Department</html:option>
				<html:optionsCollection  name="allDepartments"  label="deptName" value="deptId" /> 
			</html:select>
		</td>
		<td class="style3"  valign="top">
			<html:text  name="arrItems" property="itemQuantity" size="3" onchange='<%= "balanceTheQuantity(this," +  arrIndex + ");" %>'  indexed="true" />
		</td>
		<td class="style3"  valign="top">
			<html:text name="arrItems" property="itemCentralStoreQty" size="3" onchange='<%= "balanceTheQuantity(this," + arrIndex + ");" %>' indexed="true" value="0"/>
		</td>
		<td class="style3"  valign="top"  >
			<logic:equal name="arrItems" property="multipleSubItem" value="true">
				<html:checkbox  name="arrItems" property="multipleSubItem" disabled="true" indexed="true" />
			</logic:equal>
			<logic:equal name="arrItems" property="multipleSubItem" value="false">
				<html:checkbox  name="arrItems" property="multipleSubItem" indexed="true" />
			</logic:equal>
		</td>
		<td class="style3" width="11%" valign="top" id="remarkField_1" >

			<logic:lessEqual name="arrItems" property="itemQuantity" value="0">
				<input type='button' value='Fill Item Details' disabled="true" />
			</logic:lessEqual>
			
			<logic:greaterThan name="arrItems" property="itemQuantity" value="0">
				<input type='button' value='Fill Item Details' name='itemDetails<%= arrIndex %>' onClick="javascript:PopupMe('<html:rewrite page="/orderAcceptanceSubItemDetail.do"/>','<%=procId%>','<bean:write name="purchaseOrder" property="prnNo"/>','<bean:write name="arrItems" property="itemCode"/>','<bean:write name="arrItems" property="itemName"/>','<bean:write name="arrItems" property="itemQuantity"/>','status<bean:write name="arrItems" property="itemCode"/>','<bean:write name="arrIndex"/>','<bean:write name="user" property="uid"/>'); return false;">
			</logic:greaterThan> 
			
			
			<!-- textarea id = "txtRemarks_1" maxlength="500" onkeyup="return ismaxlength(this)"  Style=" margin: 0 auto;" rows="0" cols="20" ></textarea -->
		</td>
		<!--  td class="style3" width="13%" id="addField_1" valign="top" >&nbsp;
		</td -->
		<td class="style3"  valign="top" >
			<logic:lessEqual name="arrItems" property="itemQuantity" value="0">
				<input id='status<%= arrIndex %>'  name="status<%= arrIndex %>" value="OK" readonly="true" size="5">
			</logic:lessEqual>
			
			<logic:greaterThan name="arrItems" property="itemQuantity" value="0">
				<input id='status<%= arrIndex %>'  name="status<%= arrIndex %>" value="NOT OK" readonly="true" size="5">
			</logic:greaterThan> 
		</td>
	</tr>
	</logic:iterate>

	<tr class="footer">
		<td align="center" colspan="14" >
			<bean:define id="totalItems" name="procurementForm" property="totalItems" type="java.lang.Integer"/>
			  <input type="button" value="Store" onclick="submit_StoreOrderItems('<%= totalItems %>');">
			
		</td>
	</tr>
</table>
<!-- script language="javascript" type="text/javascript">addNewDepartment(1);addNewDepartment(2);</script-->
  </html:form>
  
  
</td></tr>
</table>
<div id="PopupWin_dropin" style="position:absolute;visibility:hidden;left:1100px;top:100px;width:504px;height:400px;background-color:#F5F5F5;border:solid thin #cccccc">
<div align="right" style="background-color:navy"><a href="#" onClick="PopupWin_dismissbox();return false"><FONT COLOR="#FFFFFF">[X]</FONT></a></div>
<IFRAME ID="PopupWin_cframe" SRC="" width=500 height=400 FRAMEBORDER=0></IFRAME></div>

<script language="javascript">
function refreshIFrame(iframeID) {
document.frames(iframeID).location.reload();
}


</script>

</body>

</html:html>