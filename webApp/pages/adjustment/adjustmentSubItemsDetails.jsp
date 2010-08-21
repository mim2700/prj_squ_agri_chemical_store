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

<!-- Link the js files here -->
<script language="javascript" type="text/javascript" src="<html:rewrite page="/pages/js/datetimepicker.js" />"></script>
<script language="javascript" type="text/javascript" src="<html:rewrite page="/pages/js/agriStore.js" />"></script>

</head>

<body>

<html:form method="POST" action="/adjustmentsSubItemsDetailsResults">

<table border="0" width="100%" id="table1" cellspacing="1" cellpadding="0" class="adjustments" >
	<tr>
		<td colspan="4">&nbsp;</td>
	</tr>
	<tr class="pageTitle">
		<td colspan="4">
			<font><bean:message key="page.adjustmentSubItemsDetails.heading"/></font>	&nbsp;
		</td>
	</tr>
	<tr>
		<td colspan="4">&nbsp;</td>
	</tr>
	<tr class="row1">
		<td align="left" colspan="2">
			<bean:message key="page.adjustmentSubItemsDetails.adjustmentType"/>
			
			<bean:write name="adjustment" property="adjusment_Name"/>
			<html:hidden name="adjustment" property="adjusment_ID"/>
		
		</td>
		<td align="left" colspan="2">
			<bean:message key="page.adjustmentSubItemsDetails.sourceDepartment"/>
		
			<bean:write name="source_Dept" property="deptName"/>
			<html:hidden name="source_Dept" property="deptId"/>
			
		</td>
	</tr>
	<tr class="row1">
		<td align="left" colspan="2">
			<bean:message key="page.adjustmentSubItemsDetails.measurment"/>
			
			<bean:write name="measurment" property="measurment_Unit"/>
		
		
		</td>
		<td align="left" colspan="2">
			<bean:message key="page.adjustmentSubItemsDetails.itemName"/>
		
			<bean:write name="item" property="itemName"/>

			
		</td>
	</tr>
	<tr class="break">
		<td colspan="4">&nbsp;</td>
	</tr>
	<tr class="row3">
		<td  align="center"  colspan="4">
			<table width="100%" border="1">
			<tr>
				 <th align="center"><bean:message key="page.adjustmentSubItemsDetails.subitemCode"/></th>
				 <th align="center"><bean:message key="page.adjustmentSubItemsDetails.manuDate"/></th>
				 <th align="center"><bean:message key="page.adjustmentSubItemsDetails.expDate"/> </th>
				 <th align="center"><bean:message key="page.adjustmentSubItemsDetails.grade"/>  </th>
				 <th align="center"><bean:message key="page.adjustmentSubItemsDetails.size"/></th>
				 <th align="center"><bean:message key="page.adjustmentSubItemsDetails.variation"/></th>
			 </tr>
				<logic:iterate id="subItems" name="AdjustItemsForm" property="subItems" indexId="SerialNo">
				   
				   <tr>
						<td align="center" width="20%">
						
							<bean:write name="subItems" property="subItemId" />
	
						</td>
						<td align="center">
								<table>
									<tr>
										<td><html:text name="subItems" property="manuDate" size="10" readonly="true" indexed="true"/></td>
										<td><a href="javascript:NewCal('subItems[<%=SerialNo%>].manuDate','yyyyMMdd')">	
										            <html:img page="/pages/images/cal.gif"/> </a>
										 </td>
									</tr>
								</table>
							</td>
							
							<td align="center">
								<table>
									<tr>
										<td><html:text name="subItems" property="expireDate" size="10" readonly="true" indexed="true"/></td>
										<td><a href="javascript:NewCal('subItems[<%=SerialNo%>].expireDate','yyyyMMdd')"> 
												<html:img page="/pages/images/cal.gif"/> </a>	
										 </td>
									</tr>
								</table>
							</td>
							<td align="center">
							 		<html:select name="subItems" property="grade" indexed="true">
											<html:option value="0">Select Grade</html:option>
											<html:optionsCollection  name="allGrades"  label="gradeName" value="gradeId" /> 
									</html:select>
							</td>
							<td align="center">
							 	<html:text name="subItems" property="size" size="8" indexed="true" />
							</td>
							<td align="center">
							 	<html:select name="subItems" property="variation" indexed="true">
									<html:option value="0">Select Variation</html:option>
									<html:optionsCollection  name="allVariations"  label="variation_Value" value="variation_Id" /> 
								</html:select>
							 	
							</td>
					</tr>
				</logic:iterate>
			</table>
		</td>
	</tr>
	<tr class="break">
		<td colspan="4">&nbsp;</td>
	</tr>
	<tr class="pageFooter">
		<td colspan="4" align="center">
			<input type="button" value="Save" onclick="submitForm()">
		</td>
	</tr>
</table>

</html:form>

<script language="javascript">

function submitForm()
	{
		var result = checkDates_Subitems('<bean:write name="AdjustItemsForm" property="totalSubItems"/>');
		if(result == "OK")
		{
			
			AdjustItemsForm.submit();

		}else
			alert(result);
	}

</script>

</body>
</html:html>
