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

<html:form method="POST" action="/consumeItemsResults">

<table border="0" width="100%" id="table1" class="consumption">
	<tr>
		<td colspan="2">&nbsp;</td>
	</tr>
	<tr class="pageTitle">
		<td colspan="2">
				<font><bean:message key="page.consumeSubitems.heading"/></font>
		</td>
	</tr>
	<tr>
		<td colspan="2">&nbsp;</td>
	</tr>
	<tr class="row1">
		<td colspan="2" align="center">
		<table border="0"  width="100%" >
				<tr>
					 <td ><bean:message key="page.consumeSubitems.department"/>&nbsp; <bean:write name="department" property="deptName"/></td>
				</tr>
				<tr>
					<td>
						<table border="1"  width="100%">
							<tr>
								<th ><bean:message key="page.consumeSubitems.itemCode"/></th>
								<th ><bean:message key="page.consumeSubitems.itemName"/></th>
								<th ><bean:message key="page.consumeSubitems.quantity"/></th>
							</tr>
							<tr>
								<td ><bean:write name="Item" property="itemCode"/></td>
								<td ><bean:write name="Item" property="itemName"/></td>
								<td ><bean:write name="Item" property="itemQuantity"/></td>
							</tr>
						</table>
					</td>
				</tr>
		</table>
			
		</td>
	</tr>
	<tr class="break">
		<td colspan="2">&nbsp;</td>
	</tr>
	<tr>
		<td>
		
			<table border="1"  width="100%" id="searchResults" class="searchResults">
				<tr>
					 <th align="left">
					 	<bean:message key="page.consumeSubitems.SubItems"/>
					 </th>
					 <th align="left">
					 	<bean:message key="page.consumeSubitems.manuDate"/>
					 </th>
					 <th align="left"> 
					 	<bean:message key="page.consumeSubitems.expireDate"/>
					 </th>
					 <th align="left"> 
					 	<bean:message key="page.consumeSubitems.quantity"/>
					 </th>
				</tr>
				<logic:iterate id="subItems" name="Item" property="subItems" indexId="SerialNo">
				<tr>
					<td><bean:write name="subItems" property="subItemId"/></td>
					<td><bean:write name="subItems" property="manuDate"/></td>
					<td><bean:write name="subItems" property="expireDate"/></td>
					<td><bean:write name="subItems" property="qtyAvailable"/></td>
				</tr>
				</logic:iterate>
			</table>
		</td>
	</tr>
	<tr  class="break">
		<td colspan="2">&nbsp;</td>
	</tr>
	<tr class="pageFooter">
		<td colspan="2" align="center">
			<p><html:submit value="Submit" /></p>
		</td>
	</tr>
</table>


</html:form>

</body>

</html:html>