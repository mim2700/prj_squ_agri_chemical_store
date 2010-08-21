<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<html:html locale="true">
<head>
<html:base />
<title><tiles:getAsString name="title" /></title>
<link rel="stylesheet" type="text/css" media="screen,projection" href="<html:rewrite page="/pages/template/agriStyle.css"/>" />
</head>
<body topmargin="0" leftmargin="0" bottommargin="0" rightmargin="0">

<table border="0" width="100%" cellspacing="0" cellpadding="0" height="100%" id="table1" style="border-collapse: collapse" bordercolor="#111111">
	<tr>
		<td width="85%" valign="top">
<html:html locale="true">
		<p><tiles:insert attribute="body" />
</html:html></td>
	</tr>
	<tr>
		<td height="5%"><tiles:insert attribute="footer" /></td>
	</tr>
</table>
</html:html>