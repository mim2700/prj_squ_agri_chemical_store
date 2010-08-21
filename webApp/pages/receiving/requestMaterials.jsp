<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-nested" prefix="nested" %>

<html:html>

<head>
<meta http-equiv="Content-Language" content="en-us">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title> Request Materials </title>

 <!-- Link the CSS file here -->
<link rel="stylesheet" type="text/css" media="screen,projection" href="<html:rewrite page="/pages/template/agriStyle.css"/>" />

<script language="javascript" type="text/javascript" src="<html:rewrite page="/pages/js/agriStore.js" />"></script>


</head>

<body>

<html:form method="POST" action="/requestMaterialsCart" >


<div align="center">
<table  width="100%" id="table1" class="requestItems">
<tr><td>&nbsp;</td></tr>
	<tr class="pageTitle">
		<td colspan="2">
			<font><bean:message key="page.requestMaterial.heading"/></font>
		</td>
	</tr>
	<tr><td>&nbsp;</td></tr>
	<tr class="break">
		<td colspan="2" >&nbsp;</td>
	</tr>
	<tr >
		<td style="border-style: solid; border-width: 1px" class="body">
			<table width="75%" align="center" id="requests" class="requestedItemsList" border="1" >
			
				<thead >
					<tr>
						<th><bean:message key="page.requestMaterial.item"/></th>
						<th><bean:message key="page.requestMaterial.qty_Available"/></th>
						<th><bean:message key="page.requestMaterial.qty_Requested"/></th>
						<th>&nbsp;</th>
					</tr>
				</thead>
				<tbody >
				
					<tr>
						<td>
							<html:select name="requestItemsDetailForm" property="itemCode" onchange="javascript: document.getElementById('itemQuantityAvl').selectedIndex=this.selectedIndex;">
							<html:option value="0">Select Item</html:option>
							<html:optionsCollection name="requestItemsDetailForm" property="adjustedItems"  label="itemName" value="itemCode" />
							</html:select>
						
							
							 <!-- select id="items_1" onchange="javascript: document.getElementById('availableQty_1').selectedIndex=this.selectedIndex;" >
							 			<option selected="selected" value="1">Acetone</option>
							 			<option  value="2">Test Tube</option>
							 </select --> 						
						</td>
						<td>
							 <!-- select id="availableQty_1" disabled="disabled" >
							 			<option selected="selected" value="1">20</option>
							 			<option  value="2">30</option>
							 </select --> 
							<html:select name="requestItemsDetailForm" property="itemQuantityAvl"  disabled="true">
							<html:option value="0">Item Quantity </html:option>
							<html:optionsCollection name="requestItemsDetailForm" property="adjustedItems"  label="itemQuantity" value="itemCode" />
							</html:select>
							 							    
						</td>
						<td> 
								<html:text property="itemQuantity" style="border-style: solid; border-width: 1px; padding-left: 4px; padding-right: 4px; padding-top: 1px; padding-bottom: 1px"></html:text>
							  <!-- input type="text" id="txtQtyRequested_1"  size="11" style="border-style: solid; border-width: 1px; padding-left: 4px; padding-right: 4px; padding-top: 1px; padding-bottom: 1px" name="txtQty" /-->
											  	
							<br />
							  
						</td>
						<td>
							 &nbsp;</td>
					</tr>
				</tbody>
			</table>
		</td>
		<td align="center" valign="top" style="border-style: solid; border-width: 1px" class="body">
			<p align="center">
			<!-- input type="button" value="Add New Item" id="addNewItem" onclick = "javascript: addNewRequest();"--></td>
	</tr>
	<tr class="break">
		<td colspan="2" >&nbsp;</td>
	</tr>
	<tr class="pageFooter">
		<table>
		<tr>
			<td style="border-top-style: solid; border-top-width: 1px" >
				<p align="center">
				
				<html:submit property="bttnAddToCart" value="Add to cart" />
				</td>
			<td style="border-top-style: solid; border-top-width: 1px" >
				<p align="center">

					<html:submit property="bttnAddToCart" value="View your cart" />

			</td>
		</tr>
		<tr>
			<td>
						
				
				<br />
							<html:messages id="errors">
							<table border="1" style="border: thin solid black" cellpadding="3" cellspacing="0"><tr>
									<td style="border:hidden;" ><img src="<html:rewrite page="/pages/images/errorMsg.gif" />" /></td>
									<td style="border:hidden;" ><font color="red"><bean:write name="errors" /></font></td>
							</tr></table>
							
							</html:messages>
				
			</td>
		</tr>
		</table>		
		
	</tr>
</table>
</div>
</html:form>
</body>

</html:html>