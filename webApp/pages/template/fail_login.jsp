<%@ page contentType="text/html; charset=Cp1252" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-nested" prefix="nested" %>

<%

response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>

<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Cp1252"/>
<title></title>
<!-- Link the CSS file here -->
<link rel="stylesheet" type="text/css" media="screen,projection" href="<html:rewrite page="/pages/template/agriStyle.css"/>" />

</head>
<body>
<br>
<center>
	
	<div><font size="5" color="red" >Fails To Login</font></div>
			
		<div>To Login Again Please Click <html:link page="/welcome.do"  >Here</html:link></div>
		
</center>
<br>
</body>
</html:html>
