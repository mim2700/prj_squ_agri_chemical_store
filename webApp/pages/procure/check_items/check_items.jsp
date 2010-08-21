 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<%@ page language="java" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-nested" prefix="nested" %>

<html>

<head>

<!-- Link the CSS file here -->

<link rel="stylesheet" type="text/css" media="screen,projection" href="<html:rewrite page="/pages/template/agriStyle.css"/>" />

<!-- Link the JS file here -->
 <script language="javascript" type="text/javascript" src="<html:rewrite page="/pages/js/agriStore.js"/>"></script>


</head>

<body>
<table border="0" width="100%" cellspacing="0" cellpadding="0" height="100%" id="table1">
	<tr>
		<td width="25%" height="25%" colspan="4" ><p dir="ltr">&nbsp;</td>
	</tr>
	<tr class="pageTitle">

		<td  colspan="4"  >
			<font><bean:message key="page.checkItems.heading"/></font>
		</td>

	</tr>
	<tr>
		<td width="25%" height="25%" colspan="4" ><p dir="ltr">&nbsp;</td>
	</tr>
	<tr>
		<td width="25%">&nbsp;</td>
		<td colspan="2" rowspan="4">
	<html:form method="post" action="/checkItemDetail">
		<table border="1" width="621" cellspacing="0" cellpadding="0" height="100%" id="table2" class="checkItems">
			<tr>
				<td width="260" class="label">
				<p dir="ltr">
				<bean:message key="page.checkItems.PRN"/></td>
				<td width="23">&nbsp;</td>
				<td width="330" colspan="2" class="input">
				<p align="left">
				<input type="text" name="prnNo" size="20" style="border-style: solid; border-width: 1px; padding-left: 4px; padding-right: 4px; padding-top: 1px; padding-bottom: 1px"></td>
			</tr>
			<tr>
				<td width="260"  class="label">
				<p dir="ltr" style="visibility:hidden">
				<bean:message key="page.checkItems.LPONumber"/></td>
				<td width="23">&nbsp;</td>
				<td width="330" colspan="2" class="input">
				<p dir="ltr" style="visibility:hidden">
				<input type="text" name="lpoNo" size="20" style="border-style: solid; border-width: 1px; padding-left: 4px; padding-right: 4px; padding-top: 1px; padding-bottom: 1px"></td>
			</tr>
			<tr >
				<td width="260"  class="label">
				<p dir="ltr" style="visibility:hidden">
				<bean:message key="page.checkItems.GRNNumber"/></td>
				<td width="23">&nbsp;</td>
				<td width="330" colspan="2" class="input">
				<p dir="ltr" style="visibility:hidden">
					<input type="text" name="grnNo" size="20" style="border-style: solid; border-width: 1px; padding-left: 4px; padding-right: 4px; padding-top: 1px; padding-bottom: 1px">
				</td>
			</tr>
			<tr class="break">
				<td width="609" colspan="4">
				<p dir="ltr">&nbsp;</td>
			</tr>
			<tr>
				<td width="258"  class="label">
				<bean:message key="page.checkItems.PartialStorage"/></td>
				<td width="23">&nbsp;</td>
				<td width="141"  valign="top" class="input">
				
					<input type="button" value="Store" onclick="check_checkItems_Empty_and_submit()" name="B3"></td>
				<td width="187" valign="top" class="input">
					<input type="reset" value="Reset" name="B2">
				
				</td>
			</tr>
			<tr class="break">
				<td width="260" >&nbsp;
				</td>
				<td width="23">&nbsp;</td>
				<td width="330" colspan="2">&nbsp;
				</td>
			</tr>
			<tr>
				<td width="260"  class="label" valign="top">
				<p align="left" style="visibility:hidden"><bean:message key="page.checkItems.StoreAll"/></td>
				<td width="23">&nbsp;</td>
				<td width="330" colspan="2" class="input">
				<p align="center">

		<html:form method="post" action="/checkItemDetail">
				<input type="submit" value="Store Directly" name="B1" style="visibility:hidden">
		</html:form>		

				</td>
			</tr>
		</table>
	</html:form>
		</td>
		<td width="25%" rowspan="4">
		<p dir="ltr">&nbsp;
		
		</td>
	</tr>
	<tr>
		<td width="25%">&nbsp;</td>
	</tr>
	<tr>
		<td width="25%">&nbsp;</td>
	</tr>
	<tr>
		<td width="25%">&nbsp;</td>
	</tr>
	<tr>
		<td width="25%" height="25%">&nbsp;</td>
		<td height="25%">&nbsp;</td>
		<td height="25%">&nbsp;</td>
		<td width="25%" height="25%">&nbsp;</td>
	</tr>
	<tr>
		<td width="25%" height="25%">&nbsp;</td>
		<td height="25%">&nbsp;</td>
		<td height="25%">&nbsp;</td>
		<td width="25%" height="25%">&nbsp;</td>
	</tr>
</table>

</body>

</html>