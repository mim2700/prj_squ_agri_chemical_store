<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
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

<html>

<head>
 
<meta http-equiv="Content-Language" content="en-us">
<!-- meta http-equiv="Content-Type" content="text/html; charset=windows-1252" -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Pragma" content="no-cache"> 
<META HTTP-EQUIV="Expires" CONTENT="-1">

<title>Store Order Sub Items</title>

<!-- Link the CSS file here -->
<link rel="stylesheet" type="text/css" media="screen,projection" href="<html:rewrite page="/pages/template/agriStyle.css"/>" />

<!-- Link the datetimepicker js file here -->
<script language="javascript" type="text/javascript" src="<html:rewrite page="/pages/js/datetimepicker.js" />"></script>
<script language="javascript" type="text/javascript" src="<html:rewrite page="/pages/js/agriStore.js" />"></script>
</head>

<body class="orderSubitemsBody">
	
<html:form method="post" action="/orderAcceptanceSubItemResult">

<table border="0" width="100%" id="table1" cellspacing="1" cellpadding="0">
	<tr>
		<td >&nbsp;</td>
	</tr>
	<tr class="pageTitle">
		<td>
			<font><bean:message key="orderSubitems.heading"/></font>
		</td>
	</tr>
	<tr class="fill">
		<td >&nbsp;</td>
	</tr>
	<tr>
		<td class="label">
							<bean:message key="orderSubitems.prn"/> 
							<bean:write name="storeItemsDetailForm" property="prnNo"/>
		</td>
	</tr>
	<tr>
		<td class="label">
						    <bean:message key="orderSubitems.department"/>&nbsp; 
						    <bean:write name="department" property="deptName"/>
		</td>
	</tr>
	<tr class="fill">
		<td >&nbsp;</td>
	</tr>
	<tr class="fill">
		<td align="center">
			<table border="1" width="100%" class="orderSubitems">
				<tr>
					<td class="label"><b><bean:message key="orderSubitems.itemId"/></b></td>
					<td class="label"><b><bean:message key="orderSubitems.itemName"/></b></td>
					<td class="label"><b><bean:message key="orderSubitems.item_Qty"/></b></td>
					<td class="label"><b><bean:message key="orderSubitems.measurment"/></b></td>
				</tr>
				<tr>
					<td class="input">&nbsp;<bean:write name="storeItemsDetailForm" property="itemCode"/></td>
					<td class="input">&nbsp;<bean:write name="storeItemsDetailForm" property="itemName"/></td>
					<td class="input"><center><bean:write name="storeItemsDetailForm" property="itemQuantity"/></center></td>
					<td class="input"><center><bean:write name="storeItemsDetailForm" property="measurment"/></center></td>
				</tr>
			</table>
		</td>
	</tr>
	<tr class="fill">
		<td >&nbsp;</td>
	</tr>
	<tr class="fill">
		<td align="center">
			<table border="1" width="100%" class="orderSubitemsTable">
				<tr>
					<th><bean:message key="orderSubitems.manuDate"/></th>
					<th><bean:message key="orderSubitems.expireDate"/></th>
					<th><bean:message key="orderSubitems.grade"/></th>
					<th><bean:message key="orderSubitems.size"/></th>
					<th><bean:message key="orderSubitems.variation"/></th>
					<th><bean:message key="orderSubitems.subItemId"/></th>
				</tr>
				<bean:define id="totalSubItems" name="storeItemsDetailForm" property="totalSubItems" type="java.lang.Integer"/>
				<logic:iterate id="subItems" name="storeItemsDetailForm" property="subItems" indexId="SerialNo">
					<tr>
						<td>
							<table><tr>
										<td>
											<html:text name="subItems" property="manuDate" size="12" onblur='<%= "updateMultipleSubitems("+SerialNo+","+totalSubItems+",\'manuDate\');"%>' readonly="true" indexed="true"/>
										</td>
										<td>
											<a href="javascript:NewCal('subItems[<%=SerialNo%>].manuDate','yyyyMMdd')">	
												<html:img page="/pages/images/cal.gif"/> </a>
										</td>
								  </tr>
							</table>
						</td>
						<td>
							<table><tr>
										<td>
											<html:text name="subItems" property="expireDate" size="12" onblur='<%= "updateMultipleSubitems("+SerialNo+","+totalSubItems+",\'expireDate\');"%>' readonly="true" indexed="true"/>
										</td>
										<td>
											<a href="javascript:NewCal('subItems[<%=SerialNo%>].expireDate','yyyyMMdd')"> 
													<html:img page="/pages/images/cal.gif"/> </a>
										</td>		
								   </tr>
							</table>
						 </td>
						 <td style="align:right">
						 	<html:select name="subItems" property="grade" indexed="true">
									<html:option value="0">Select Grade</html:option>
									<html:optionsCollection  name="allGrades"  label="gradeName" value="gradeId" /> 
							</html:select>
						 </td>
						  <td style="align:right">
						 	<html:text name="subItems" property="size" size="8" indexed="true" />
						 </td>
						  <td style="align:right">
						 	<html:select name="subItems" property="variation" indexed="true">
								<html:option value="0">Select Variation</html:option>
								<html:optionsCollection  name="allVariations"  label="variation_Value" value="variation_Id" /> 
							</html:select>
						 	
						 </td>
						 <td style="align:right">
						 	&nbsp;<font color="blue"><bean:write name="subItems" property="subItemId"/></font>
						 </td>
					</tr>
				</logic:iterate>
			</table>
		</td>
	</tr>
	<tr class="fill">
		<td>&nbsp;</td>
	</tr>
	<bean:parameter id="status" name="status"/>
	<tr class="pageFooter">
		<td align="center">
			<input type="button" value="submit" onclick="update('<%=status%>');">
		</td>
	</tr>
</table>

</html:form>

</body>
<script language="javascript">

function update(statusVal)
	{
		var result = checkDates_Subitems('<bean:write name="storeItemsDetailForm" property="totalSubItems"/>');
				
		if(result == "OK")
		{
			//parent.updateParent(statusVal);
			
			storeItemsDetailForm.submit();
			//window.close();
			//window.opener.location.href=window.opener.location.href; // refresh the main page
//window.opener.valueOf("")
window.opener.focus(); // focus on the main page

window.opener.document.getElementById('status<bean:write name="storeItemsDetailForm" property="indexNo"/>').value = "OK";
//window.opener.document.getElementById('itemDetails<bean:write name="storeItemsDetailForm" property="indexNo"/>').disabled = "true"
window.close(); // close the popup page

			//parent.location.href=parent.location.href;
			//parent.location.reload(false);
			
		}else
			alert(result);
	}
	
	//function update(statusVal)
	//{
	//	parent.updateParent(statusVal);
	//	storeItemsDetailForm.submit();
	//}
</script>

</html>