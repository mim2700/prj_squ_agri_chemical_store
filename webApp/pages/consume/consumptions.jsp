<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-nested" prefix="nested" %>

<html:html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>Consumption</title>

<!-- Link the CSS file here -->
<link rel="stylesheet" type="text/css" media="screen,projection" href="<html:rewrite page="/pages/template/agriStyle.css"/>" />

<script language="javascript" type="text/javascript" src="<html:rewrite page="/pages/js/agriStore.js" />"></script>

<!-- Link the JS file here -->
 <script language="javascript" type="text/javascript" src="<html:rewrite page="/pages/js/ajaxGetObjects.js"/>"></script>


</head>

<body>

<html:form method="POST" action="/consumeSubitems">

<table border="0" width="100%" id="table1" class="consumption">
	<tr>
		<td colspan="2">&nbsp;</td>
	</tr>
	<tr class="pageTitle">
		<td colspan="2">
				<font><bean:message key="page.consumption.heading"/></font>
		</td>
	</tr>
	<tr>
		<td colspan="2">&nbsp;</td>
	</tr>
	<tr class="row1">
		<td colspan="2" align="center">
			<bean:message key="page.consumption.department"/>&nbsp; <bean:write name="department" property="deptName"/>
		</td>
	</tr>
	<tr class="break">
		<td colspan="2">&nbsp;</td>
	</tr>
	<tr>
		<td colsapn="2" align="center">
			  <table border="1" align="center" width="100%" id="table1" class="itemSearch">
			  	<tr>
			  			<td align="right" class="label"><bean:message key="page.consumption.itemCode"/></td>
			  			<td align="left" class="input">
			  				<input type="text" name="txtItemCode" size="20" onkeyup="javascript: getItemsList(<bean:write name="department" property="deptId"/>,value,'code','')" style="border-style: solid; border-width: 1px; padding-left: 4px; padding-right: 4px; padding-top: 1px; padding-bottom: 1px">
			  			</td>
			  			<td align="right" class="label"><bean:message key="page.consumption.itemName"/></td>
			  			<td align="left" class="input"><input type="text" name="txtItemName" size="20" onkeyup="javascript: getItemsList(<bean:write name="department" property="deptId"/>,value,'name','')" style="border-style: solid; border-width: 1px; padding-left: 4px; padding-right: 4px; padding-top: 1px; padding-bottom: 1px"></td>
			  	</tr>
			  	<tr>
			  			<td align="right" valign="top" class="label"><!-- bean:message key="page.consumption.subitemsCodes"/ --></td>
			  			<td align="left" class="input">
			  				  <select name="lstItemCode" size="5" width="100" onclick="javascript:consume_ItemCode_updateFields()"  style="visibility:hidden">
							  
							  </select>
			  				
			  			</td>
			  			<td align="right" valign="top" class="label"><!-- bean:message key="page.consumption.subitemsNames"/ --></td>
			  			<td align="left" class="input">
			  				 <select name="lstItemName" size="5" width="100" onclick="javascript:consume_ItemName_updateFields()" style="visibility:hidden">
				
							  </select>
			  			</td>			  	
			  	</tr>
			  	<tr>
			  		<td class="label">
			  			<bean:message key="page.consumption.itemSelection"/>
			  		</td>
			  		<td colspan="3" align="left" class="input">
			  			<table border="1" align="center" width="100%">
				  				<tr>
					  				<th align="center">
					  					<bean:message key="page.consumption.itemCode"/>
					  				</th>
					  				<th align="center">
					  					<bean:message key="page.consumption.itemName"/>
					  				</th>
					  				<th align="center">
					  					<bean:message key="page.consumption.qtyAvialable"/>
					  				</th>
					  				<th align="center">
					  					<bean:message key="page.consumption.quantity"/>
					  				</th>
					  			</tr>
					  			<tr>
					  				<td align="center">
					  					<select name="itemCode" disabled="disabled" onchange="consume_SelectedItems_updateFields('itemCode')">
							 			</select> 
					  				</td>
					  				
					  				<td align="center">
					  					<select name="itemName" disabled="disabled" onchange="consume_SelectedItems_updateFields('itemName')">
							 			</select> 
					  				</td>
					  				<td align="center">
					  					 <select name="txtQuantityAvialable" disabled="disabled" onchange="consume_SelectedItems_updateFields('txtQuantityAvialable')">
							 			  </select> 	
					  				</td>
					  				<td align="center">
					  					<input type="text" name="itemQuantity" size="10" onchange="balance_consumption_quantity()"  style="border-style: solid; border-width: 1px; padding-left: 4px; padding-right: 4px; padding-top: 1px; padding-bottom: 1px">
					  				</td>
				  				</tr>
			  			</table>
			  		</td>
			  	</tr>
			  	
			  </table>
		</td>
	</tr>
	<tr  class="break">
		<td colspan="2">&nbsp;</td>
	</tr>
	<tr class="pageFooter">
		<td colspan="2" align="center">
			<p><input type="button" value="Submit" onclick="check_consumption_Empty_and_submit()" /></p>
		</td>
	</tr>
</table>


</html:form>

</body>

</html:html>