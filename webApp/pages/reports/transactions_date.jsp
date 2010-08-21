<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<%@ page contentType="text/html;charset=windows-1256"  language="java" import="java.util.*"%>

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-nested" prefix="nested" %>
<html:html locale="true">
<script type="text/javascript" src="<html:rewrite page="/pages/js/datetimepicker.js"/>" ></script>
<head>
<meta http-equiv="Content-Language" content="en-us">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>Report - Transaction</title>

<!-- Link the CSS file here -->
<link rel="stylesheet" type="text/css" media="screen,projection" href="<html:rewrite page="/pages/template/agriStyle.css"/>" />

</head>

<body>
<%
session.setAttribute("org.apache.struts.action.LOCALE", new Locale("ar"));
%>
<table class="rptTransactionDt" border="0" width="100%" height="100%" id="table1" cellspacing="1" cellpadding="0">
	<tr>
		<td colspan="7">&nbsp;</td>
	</tr>
	<tr class="pageTitle">
		<td colspan="7" align="center">
			<b><font size="5"><bean:message key="page.report.transactionByDate.heading"/></font></b>
		</td>
	</tr>
	<tr>
		<td colspan="7">&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td class="label"><b><bean:message key="page.report.transactionByDate.departmentName"/></b></td>
		<td colspan="2" class="input">&nbsp;<b>&nbsp;</b></td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<html:form method="POST" action="/rptTransactionDtGenerate">
	<tr>
		<td>&nbsp;</td>
		<td class="label"><b><bean:message key="page.report.transactionByDate.startDate"/></b></td>
		<td class="input" colspan="2" ><html:text property="orderFromDate" readonly="true"></html:text>
		<a href="javascript:NewCal('orderFromDate','ddmmyyyy')"> 
		<html:img page="/pages/images/cal.gif"/> </a></td>
		<td class="label">
		<p align="right"><b><bean:message key="page.report.transactionByDate.endDate"/></b></td>
		<td class="input" ><html:text property="orderToDate" readonly="true"></html:text>
		<a href="javascript:NewCal('orderToDate','ddmmyyyy')"> 
		<html:img page="/pages/images/cal.gif"/> </a></td>
	</tr>
	<tr>
		<td colspan="7">&nbsp;</td>
	</tr>
	<tr class="pageFooter">
		<td colspan="7" align="center">
			<input type="submit" value="Submit" name="B1">
		</td>
	</tr>
	</html:form>
</table>

</body>

</html:html>