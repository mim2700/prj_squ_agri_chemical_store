<%@ page contentType="text/html; charset=Cp1252" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-nested" prefix="nested" %>

<%@ page import="com.squ.agri.store.*" %>
<%@ page import="com.squ.agri.store.bo.*" %>
<%@ page import="com.squ.agri.store.users.*" %>
<%@ page import="javax.servlet.http.*" %>

<%

response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>

<%
User	user =null;

		try
			{
				if (request.getUserPrincipal() != null) {

						if(request.getUserPrincipal().getName() != null)
						{
								HttpSession	session2	= request.getSession();
								user	=	(User) session2.getAttribute(StoreConstants.SESSION_USER);
						
								if( user == null)
									 {//
									 	User	user2	=	new User().getUser(request.getUserPrincipal().getName());
										 session	=	request.getSession();
										session.setAttribute(StoreConstants.SESSION_USER, user2);
										
										user = user2;
									 }
									
						}	
				
				}
			}
			catch (Exception e)
			{
				
			}

%>


<html:html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=Cp1252"/>
		<title></title>
		<!-- Link the CSS file here -->
<link rel="stylesheet" type="text/css" media="screen,projection" href="<html:rewrite page="/pages/template/agriStyle.css"/>" />
		
	</head>
<body topmargin="0" leftmargin="0" >

<table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse" align="center" width="100%">
  <tr>
  <td colspan="3" align="center">
  		<table cellspacing="0" cellpadding="0" border="0">
  			<tr>
  				<td><img height="80px" align="center" src="<html:rewrite page="/pages/images/Logo_SQU.gif"/>"></td>
				<td align="left">
			  		<b><font face="Old English Text MT" color="#000080" size="5"> <bean:message key="page.layout.header.squ.Name"/></font></b>
			  		<br/>
			  		<font face="Arial Black" color="#000080" size="1"><bean:message key="page.layout.header.college.Name"/></font>
			  		<br/>
			  		<b><font face="Arial Black" color="#000080" size="1"><bean:message key="page.layout.header.prj.Name"/></font></b>
  				</td>
  			</tr>
  		</table>
  </td>
  </tr>
  	  	
  	<%
    if (request.getUserPrincipal() != null)
	    if(request.getUserPrincipal().getName() != null)
	    	if(user != null)
		    {
%>

  <tr>
    <td width="25%" >&nbsp;  
		<font color="black" size="2"> Welcome<font color="green"> <b> <%= user.getUid() %></font></b>, Your Role is : <font color="green"> <b><%= user.getRole() %></b> </font></font>	    	
	</td>
    <td width="50%" align="center">&nbsp;
        	<font color="black" size="2">Department: ( <font color="green"><b><%= new Department().getDeptName(user.getDeptId())  %></b></font>)</font>  
    </td>
    <td width="25%" align="right">
      <table border="0" width="100%">
      	<tr>
      		<td><font color="black" size="2"><%= new java.util.Date() %></font></td>
      		<td><html:link page="/welcome.do?logout=true"  ><img border="0" src="<html:rewrite page="/pages/images/logout.gif"/>"></html:link></td>
      	</tr>
      </table>
    </td>
  </tr>
  
  <% 
  }
   %>
   
  </table>
  
<%

if(user == null)
{
%>
<hr>
<% 
  }
   %>
</body>


</html:html>

