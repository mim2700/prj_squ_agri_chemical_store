<%@ page contentType="text/html; charset=Cp1252" %>
<%@ page language="java"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-nested" prefix="nested" %>

<html:html locale="true">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=Cp1252"/>
		<title></title>
		<!-- Link the CSS file here -->
<link rel="stylesheet" type="text/css" media="screen,projection" href="<html:rewrite page="/pages/template/agriStyle.css"/>" />
		
	</head>
<body onload="javascript:document.LoginForm.j_username.focus();">

   <html:form method="POST"  action="/login1">
   <center>
    <font><bean:message key="page.login.heading"/></font>
   
<div style="border-style:groove; width:30%; height:60%" >

    <table border="0" align="center" cellpadding="1" cellspacing="2" style="border-collapse: collapse" >
      <tr>
        <td><bean:message key="page.login.uid"/></td>
        <td><input type="text" name="j_username" size="20" style="border-style: solid; border-width: 1; padding-left: 4; padding-right: 4; padding-top: 1; padding-bottom: 1"></td>
      </tr>
      <tr>
        
        <td><bean:message key="page.login.pwd"/></td>
        
        <td><input type="password" name="j_password" size="20" style="border-style: solid; border-width: 1; padding-left: 4; padding-right: 4; padding-top: 1; padding-bottom: 1"></td>
      </tr>
      <tr>
      <td></td>   
        <td align="center">
        
        
        <html:submit value="Submit" />
        <input type="reset" value="Reset" />
        
        </td>
     
      </tr>
    </table> 
    </div>
</center>
    </html:form>
   
</body>
</html:html>