<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=Cp1252" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-nested" prefix="nested" %>
<html:html>
<head>

<title>CSS DropDown Menu</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<!-- Keep the http-equiv meta tag for IE8 -->

  <meta http-equiv="X-UA-Compatible" content="IE=8" />


<!-- Link the CSS file here -->
<link rel="stylesheet" type="text/css" media="screen,projection" href="template/style.css" />
<link rel="stylesheet" type="text/css" media="screen,projection" href="<html:rewrite page="/pages/template/agriStyle.css"/>" />

<!-- Link the JS file here -->
 <script language="javascript" type="text/javascript" src="<html:rewrite page="/pages/js/ajaxGetObjects.js" />"></script>

</head>

<body>
&nbsp;
<center><img src="<html:rewrite page="/pages/images/chem-pic.gif"/>"></center>

<table width="60%" border="0" style="visibility:hidden;">
<tr>
	<td>
		<input type="text" id="txtSearch" />
	</td>
	<td>
		<select id="searchType">
			<option selected="selected" value="0">select search type</option>
			<option value="item_from_CS">Search Item Form CS</option>
			<option value="item_from_DS">Search Item Form DS</option>
		</select>
	</td>
	<td>
		<input type="button" value="Search" onclick="searchFormDB()" />
	</td>
</tr>
<tr>
	<td colspan="3">results</td>
</tr>
</table>
  
</body>

<!--  logic:equal name="loginForm" property="logedOn" value="true" -->
	<!--logic:redirect forward="login"/ -->
<!-- /logic:equal -->

</html:html>
