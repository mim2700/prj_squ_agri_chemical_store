<%@ page contentType="text/html; charset=Cp1252" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-nested" prefix="nested" %>

<html:html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=Cp1252"/>
		<title></title>
	</head>
<body topmargin="0" leftmargin="0">
  <div style="border-width:thin; border-style:groove">
	    <font color="#016225">
		    <p align="center">
			    <b><bean:message key="page.welcome.writing.heading"/></b>
			    <bean:message key="page.welcome.writing.para1"/>
		    </p>
		    <p align="center">
			    <i><bean:message key="page.welcome.writing.para2"/></i>
			    <br><bean:message key="page.welcome.writing.para3"/>
		    </p>
	    </font>
    </div>
</body>
</html:html>