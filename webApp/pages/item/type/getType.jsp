

<%@page import="com.squ.agri.store.bo.Type"%>

<%

String id = request.getParameter("id");

if(id != null) {

	
		Type type = new Type().getType(id);
	

	response.setContentType("text/xml");
	response.setHeader("Cache-Control", "no-cache");

	response.getWriter().write("<type>");
	response.getWriter().write("<tid>" + type.getTypeId() + "</tid> "); 
	response.getWriter().write("<tname>" + type.getTypeName() + "</tname>");
	
	if(type.isTypeActive())
	 response.getWriter().write("<active>1</active>");
	 else
	 response.getWriter().write("<active>0</active>"); 
	   
	 response.getWriter().write("</type>");   
	
	
      
} else {

	response.setStatus(HttpServletResponse.SC_NO_CONTENT);
}

	
    	
 %>
