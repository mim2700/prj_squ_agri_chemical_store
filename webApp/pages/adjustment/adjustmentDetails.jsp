<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-nested" prefix="nested" %>

<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>

<%@page pageEncoding="Cp1252" contentType="text/html; charset=Cp1252" %>
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title> Adjustment </title>

<!-- Link the CSS file here -->
<link rel="stylesheet" type="text/css" media="screen,projection" href="<html:rewrite page="/pages/template/agriStyle.css"/>" />

<!-- Link the JS file here -->
 <script language="javascript" type="text/javascript" src="<html:rewrite page="/pages/js/ajaxGetObjects.js"/>"></script>

<!-- Link the js files here -->
<script language="javascript" type="text/javascript" src="<html:rewrite page="/pages/js/datetimepicker.js" />"></script>
<script language="javascript" type="text/javascript" src="<html:rewrite page="/pages/js/agriStore.js" />"></script>

</head>

<body>

<html:form method="POST" action="/adjustItemsResults">

<table border="0" width="100%" id="table1" cellspacing="1" cellpadding="0" class="adjustments" >
	<tr>
		<td colspan="4">&nbsp;</td>
	</tr>
	<tr class="pageTitle">
		<td colspan="4">
			<font><bean:message key="page.adjustmentDetails.heading"/></font>	&nbsp;
		</td>
	</tr>
	<tr>
		<td colspan="4">&nbsp;</td>
	</tr>

	<tr class="row3">
		<td align="center"  colspan="4" >
			<table border="1" cellspacing="5" cellpadding="2">
			<tr>
				<td >
					<bean:message key="page.adjustmentDetails.adjustmentType"/>
				</td>
				<td align="left">
						<bean:write name="adjustment" property="adjusment_Name"/>
						<html:hidden name="adjustment" property="adjusment_ID"/>
				</td>
			</tr>
			<tr>
				<td >
					<bean:message key="page.adjustmentDetails.sourceDepartment"/>
				</td>
				<td align="left">
					<bean:write name="source_Dept" property="deptName"/>
					<html:hidden name="source_Dept" property="deptId"/>
				</td>
			</tr>
				<logic:iterate id="items" name="AdjustItemsForm" property="items" indexId="ItemsIndex">
				   <tr>
				   		<td >
							<bean:message key="page.adjustmentDetails.itemAdjusted"/>
						</td>
						<td align="left">
								<table>
								  <tr>
								  	  <td>
										<bean:define id="deptId" name="source_Dept" property="deptId" type="java.lang.String"/>
										<bean:define id="adjustId" name="adjustment" property="adjusment_ID" type="java.lang.String"/>
										 <html:select name="items" property="itemCode" onchange='<%= "getSubItemsList(value,"+deptId+","+ItemsIndex+",\'"+ adjustId +"\');"%>' indexed="true" >
											<html:option value="0">Select Item</html:option>
											<html:optionsCollection  name="allItems"  label="itemName" value="itemCode" /> 
										 </html:select>
								  	</td>
								 	<td>
											 <logic:equal name="adjustment" property="adjusment_Action" value="C">
											   
											   <logic:iterate id="subItems" name="AdjustItemsForm" property="subItems" indexId="SerialNo">
											 	 <table>
												 	 <tr>
												 	 	<td>
														 	 <html:select name="subItems" property="subItemId" onchange='<%= "adjust_select_subItem_Qty("+ItemsIndex+");"%>' disabled="true" indexed="true" >
													 		 </html:select>
												 		 </td>
												 		 <td>
													 		 <html:select name="subItems" property="qtyAvailable" disabled="true" indexed="true" >
												  			 </html:select>
											  			</td> 
											  		</tr>
										  		</table>
									 
											   </logic:iterate>
											   
											</logic:equal>
									</td>
								  </tr>
							</table>
							
						</td>
					</tr>
					<logic:equal name="adjustment" property="adjusment_Action" value="R">
					<tr>
						<td>
								<bean:message key="page.adjustmentDetails.type"/> 
						</td>
						<td  align="left">
								<html:select name="items" property="type" indexed="true">
										<html:option value="0">Select Type</html:option>
										<html:optionsCollection  name="allTypes"  label="typeName" value="typeId" /> 
								</html:select>
						</td>
					</tr>
					<tr>
						<td>
								<bean:message key="page.adjustmentDetails.safety"/> 
						</td>
						<td  align="left">
								<html:select name="items" property="safety" indexed="true">
									<html:option value="0">Select Safety</html:option>
									<html:optionsCollection  name="allSafetys"  label="un_Number" value="safetyId" /> 
								</html:select>
						</td>
					</tr>
					<tr>
						<td>
								<bean:message key="page.adjustmentDetails.measurment"/> 
						</td>
						<td  align="left">
								<html:select name="items" property="measurment" indexed="true">
									<html:option value="0">Select Measurment</html:option>
									<html:optionsCollection  name="allMeasurments"  label="measurment_Unit" value="measurment_Id" /> 
								</html:select>
						</td>
					</tr>
					</logic:equal>
					<tr>
						<td>
								<bean:message key="page.adjustmentDetails.quantity"/> 
						</td>
						<td  align="left">
						<bean:define id="var_adjust_action" name="adjustment" property="adjusment_Action" type="java.lang.String"/>
								<html:text name="items" property="itemQuantity" size="5" indexed="true" onchange='<%= "balance_Adjust_Reduce_Quantity(this,0,\'" + var_adjust_action + "\');"%>' />
						</td>
					</tr>
					 <logic:equal name="adjustment" property="adjusment_Action" value="R">
					<tr>
						<td>
							 <bean:message key="page.adjustmentDetails.mutipleSubitems"/> 
						</td>
						<td  align="left">
								<html:checkbox  name="items" property="multipleSubItem" onclick = '<%= "confirmForMultipleItems();"%>' indexed="true" />
						</td>
					</tr>
					</logic:equal>
				</logic:iterate>
			</table>
		</td>
	</tr>
	<tr class="break">
		<td colspan="4">&nbsp;</td>
	</tr>
	<tr class="pageFooter">
		<td colspan="4" align="center">
			 <logic:equal name="adjustment" property="adjusment_Action" value="C">
				<input type="button" value="Save" onclick="check_adjustmentsDetails_Empty_and_submit('C')">
			 </logic:equal>
			 
			  <logic:equal name="adjustment" property="adjusment_Action" value="R">
				<input type="button" value="Continue" onclick="check_adjustmentsDetails_Empty_and_submit('R')">
			 </logic:equal>
		</td>
	</tr>
</table>

</html:form>

</body>
</html:html>
