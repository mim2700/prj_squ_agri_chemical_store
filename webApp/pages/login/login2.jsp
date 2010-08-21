<%@ page contentType="text/html; charset=Cp1252" %>
<%@ page language="java"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-nested" prefix="nested" %>

<%

response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=Cp1252"/>
		<title></title>
	</head>

<body bgcolor="#C0C0C0">

 <form name="frmTom" method="POST" action="<%= response.encodeURL("j_security_check")%>">
	
        <input name="j_username" value="<%=request.getAttribute("userName") %>" />
        <input name="j_password" size="50" value="<%=request.getAttribute("userPwd") %>"/>
       
       <input type="submit" value="Submit" />
       
    </form>
    
    <form name="frmInvalid" method="POST" action="<%= response.encodeURL("login.do")%>">
    </form>
   <script language = "Javascript">

   		//if(document.frmTom.j_username.value == "null")
   		//	document.frmInvalid.submit();
   		//else
    		document.frmTom.submit();
    
    </script>
</body>
</html>