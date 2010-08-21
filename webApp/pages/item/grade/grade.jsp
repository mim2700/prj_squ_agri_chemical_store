<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-nested" prefix="nested" %>

<html:html>

<head>
<meta http-equiv="Content-Language" content="en-us">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>Grade</title>

<!-- Link the CSS file here -->
<link rel="stylesheet" type="text/css" media="screen,projection" href="<html:rewrite page="/pages/template/agriStyle.css"/>" />

<!-- Link the JS file here -->
 <script language="javascript" type="text/javascript" src="<html:rewrite page="/pages/js/ajaxGetObjects.js"/>"></script>
<script language="javascript" type="text/javascript" src="<html:rewrite page="/pages/js/agriStore.js"/>"></script>

</head>

<body>
<html:form method="post" action="/itemGradeResults">

<table border="0" width="100%" id="table1" cellspacing="1" cellpadding="0">
	<tr>
		<td >&nbsp;</td>
	</tr>
	<tr class="pageTitle">
		<td>
			<font><bean:message key="page.itemGrade.heading"/></font>
		</td>
	</tr>
	<tr class="fill">
		<td >&nbsp;</td>
	</tr>
	<tr class="fill">
		<td align="center">
			<table border="1" class="itemGrade">
				<tr >
					<td align="right" class="label">
						<bean:message key="page.itemGrade.Grades"/>
					</td>
					<td class="input" align="left">		
						<html:select property="gradeId" onchange="getGrade(this.form,value)">
							<html:option value="0">Select Grade</html:option>
							<html:optionsCollection  name="allGrades"  label="gradeName" value="gradeId" /> 
						</html:select>
				
					</td>
				</tr>
				<tr >
					<td align="right" class="label">
						<bean:message key="page.itemGrade.gid"/>
					</td>
					<td class="input" align="left">
						 <input type="text" disabled="disabled" name="gradeId2">
					</td>
				</tr>
				<tr >
					<td align="right" class="label">
						<bean:message key="page.itemGrade.name"/>
					</td>
					<td align="left" class="input">
						<input type="text" name="gradeName" maxlength="50">
					</td>
				</tr>
				<tr >
					<td align="right" class="label">
						<bean:message key="page.itemGrade.number"/>
					</td>
					<td class="input" align="left">
						<input type="text" name="gradeNumber" maxlength="5">
					</td>
				</tr>
				<tr >
					<td align="right" class="label">
						<bean:message key="page.itemGrade.description"/>
					</td>
					<td class="input" align="left">
						<textarea name="gradeDescription" maxlength="500" onkeyup="return ismaxlength(this)"></textarea>
					</td>
				</tr>
				<tr >
					<td  class="input" colspan="2" align="center">
						<input type="checkBox" name="gradeActive" size="20">
						<bean:message key="page.itemGrade.active"/>
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
			<input type="button" value="Submit" onclick="check_itemGrade_Empty_and_submit()" name="B1">
			<input type="reset" value="Reset" name="btnRst">
		</td>
	</tr>
</table>


</html:form>
</body>

</html:html>