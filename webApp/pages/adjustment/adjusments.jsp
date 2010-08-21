<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-nested" prefix="nested" %>




<html:html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title> Adjustment </title>

<!-- Link the CSS file here -->
<link rel="stylesheet" type="text/css" media="screen,projection" href="<html:rewrite page="/pages/template/agriStyle.css"/>" />

<!-- Link the JS file here -->
 <script language="javascript" type="text/javascript" src="<html:rewrite page="/pages/js/ajaxGetObjects.js"/>"></script>
 <script language="javascript" type="text/javascript" src="<html:rewrite page="/pages/js/agriStore.js"/>"></script>

</head>

<body>


<html:form method="POST" action="/adjustmentsDetails">

<table border="0" width="100%" id="table1" cellspacing="1" cellpadding="0" class="adjustments" >
	<tr>
		<td colspan="4">&nbsp;</td>
	</tr>
	<tr class="pageTitle">
		<td colspan="4">
			<font><bean:message key="page.adjustment.heading"/></font>	&nbsp;
		</td>
	</tr>
	<tr>
		<td colspan="4">&nbsp;</td>
	</tr>
	<tr class="row1">
		<td align="center" colspan="4">
			<table>
				<tr>
					<td align="right">
						<bean:message key="page.adjustment.adjustmentType"/>
					</td>
					<td align="left">
						<html:select property="adjusmentType">
								<html:option value="0">Select Adjustment</html:option>
								<html:optionsCollection  name="allAdjustments"  label="adjusment_Name" value="adjusment_ID" /> 
				 		</html:select>
					</td>
				</tr>
				<tr>
					<td align="right">
						<bean:message key="page.adjustment.sourceDepartment"/>
					</td>
					<td align="left"> 
						<logic:equal name="AdjustItemsForm" property="userRole" value="Department_Store">
							<html:select property="dep_Source" disabled="true">
									<html:option value="0">Select Department</html:option>
									<html:optionsCollection  name="allDepartments"  label="deptName" value="deptId" /> 
					 		</html:select>
				 		</logic:equal>
				 		
				 		<logic:notEqual name="AdjustItemsForm" property="userRole" value="Department_Store">
							<html:select property="dep_Source">
									<html:option value="0">Select Department</html:option>
									<html:optionsCollection  name="allDepartments"  label="deptName" value="deptId" /> 
					 		</html:select>
				 		</logic:notEqual>
					</td>
				</tr>
			</table>
			 
		</td>
	</tr>
	<tr class="pageFooter">
		<td colspan="4" align="center">
			<input type="button" value="Continue" onclick="check_adjustment_Empty_and_submit()" />
		</td>
	</tr>
</table>

</html:form>

</body>

</html:html>