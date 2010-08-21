<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<html:html locale="true">
<head>
<link rel="stylesheet" type="text/css" media="screen,projection" href="<html:rewrite page="/pages/template/agriStyle.css"/>" />
<html:base />
<title><tiles:getAsString name="title" /></title>
</head>
<body topmargin="0" leftmargin="0" bottommargin="0" rightmargin="0">

<table border="1" width="100%" cellspacing="0" cellpadding="0" height="100%" id="table1" >
	<tr>
		<td height="10%" colspan="2" valign="top"><tiles:insert attribute="header" /></td>
	</tr>
	<tr>
		<td width="10%" valign="top" style="padding-right:5px;"><tiles:insert attribute="navigation" /></td>
		<td width="75%" valign="top" ><tiles:insert attribute="body" /></td>
	</tr>
</table>
</html:html>