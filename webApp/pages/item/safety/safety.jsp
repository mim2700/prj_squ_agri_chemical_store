<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-nested" prefix="nested" %>

<html:html>

<head>
<meta http-equiv="Content-Language" content="en-us">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>Safety</title>

<!-- Link the CSS file here -->
<link rel="stylesheet" type="text/css" media="screen,projection" href="<html:rewrite page="/pages/template/agriStyle.css"/>" />

<!-- Link the JS file here -->
 <script language="javascript" type="text/javascript" src="<html:rewrite page="/pages/js/ajaxGetObjects.js"/>"></script>
<script language="javascript" type="text/javascript" src="<html:rewrite page="/pages/js/agriStore.js"/>"></script>

</head>

<body>
<html:form method="post" action="/itemSafetyResults">

<table border="0" width="100%" id="table1" cellspacing="1" cellpadding="0">
	<tr>
		<td >&nbsp;</td>
	</tr>
	<tr class="pageTitle">
		<td>
			<font><bean:message key="page.itemSafety.heading"/></font>
		</td>
	</tr>
	<tr class="fill">
		<td >&nbsp;</td>
	</tr>
	<tr class="fill">
		<td align="center">
			<table border="1" class="itemSafety">
				<tr >
					<td align="right" class="label">
						<bean:message key="page.itemSafety.Safetys"/>
					</td>
					<td class="input" align="left">		
						<html:select property="safetyId" onchange="getSafety(this.form,value)">
							<html:option value="0">Select Safety</html:option>
							<html:optionsCollection  name="allSafetys"  label="un_Number" value="safetyId" /> 
						</html:select>
					</td>
				</tr>
				<tr >
					<td align="right" class="label">
						<bean:message key="page.itemSafety.sid"/>
					</td>
					<td class="input" align="left">
						 <input type="text" disabled="disabled" name="safetyId2">
					</td>
				</tr>
				<tr >
					<td align="right" class="label">
						<bean:message key="page.itemSafety.un_number"/>
					</td>
					<td align="left" class="input">
						<input type="text" name="un_Number" maxlength="20">
					</td>
				</tr>
				<tr >
					<td align="right" class="label">
						<bean:message key="page.itemSafety.number_other"/>
					</td>
					<td class="input" align="left">
						<input type="text" name="other_number" maxlength="10">
					</td>
				</tr>
				<tr >
					<td align="right" class="label">
						<bean:message key="page.itemSafety.description"/>
					</td>
					<td class="input" align="left">
						<textarea name="safetyDescription" maxlength="500" onkeyup="return ismaxlength(this)"></textarea>
					</td>
				</tr>
				<tr >
					<td  class="input" colspan="2" align="center">
						<input type="checkBox" name="safetyActive" size="20">
						<bean:message key="page.itemSafety.active"/>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr class="fill">
		<td>&nbsp;</td>
	</tr>
	<tr class="pageFooter">
		<td align="center">
			<input type="button" value="Submit" onclick="check_itemSafety_Empty_and_submit()" name="B1">
			<input type="reset" value="Reset" name="btnRst">
		</td>
	</tr>
</table>


</html:form>
</body>

</html:html>

