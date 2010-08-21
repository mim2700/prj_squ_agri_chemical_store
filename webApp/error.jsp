<%@ page isErrorPage="true" %>
<%@ page language="java" %>
<%@ page import="java.util.*" %>
<%
     int statusCode = ((Integer)request.getAttribute("javax.servlet.error.status_code")).intValue();
%>

<html>
<head>
<title>Error Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<!-- Link the CSS file here -->
<link rel="stylesheet" type="text/css" media="screen,projection" href="<html:rewrite page="/pages/template/agriStyle.css"/>" />

</head>
<body>

<hr>

<%

	if (statusCode==403)
		{
		
			
				String name  = "";
				String value = "";
				
				java.util.Enumeration attributes = request.getAttributeNames();
				while(attributes.hasMoreElements())
				{
				
					 name  = (String) attributes.nextElement();
					 
					 if(name=="javax.servlet.forward.servlet_path")
					 {
						 if (request.getAttribute(name) == null)
						 {
						  value = "null";
						 }
						 else
						 {
						  value = request.getAttribute(name).toString();
						 }
						 
						 break;
					 }
				
				}
			
		%>
		
		<p>You Can't Access :<%=value%> </p>
		<P>Click<A href="<%=response.encodeURL(request.getContextPath()) %>">Here</A> to return Home</P>
		
		<%}
%>

<hr>

</body>
</html>