<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<html:html locale="true">
<head>
<link rel="stylesheet" type="text/css" media="screen,projection" href="<html:rewrite page="/pages/template/agriStyle.css"/>" />
<html:base />
<title><tiles:getAsString name="title" /></title>
<link rel="stylesheet" type="text/css" media="screen,projection" href="<html:rewrite page="/pages/template/agriStyle.css"/>" />
</head>
<body topmargin="0" leftmargin="0" bottommargin="0" rightmargin="0">

<table border="0" width="100%" cellspacing="0" cellpadding="0" height="102%" id="table1">
	<tr>
		<td height="75" valign="top"><tiles:insert attribute="header" /></td>
	</tr>
	<tr>
		<td>
        <tiles:insert attribute="body" />
		</td>
	</tr>
	<tr>
		<td height="41"><tiles:insert attribute="footer" /></td>
	</tr>
</table>
</html:html>