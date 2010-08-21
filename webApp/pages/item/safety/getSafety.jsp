


<%@page import="com.squ.agri.store.bo.Safety"%>

<%

String id = request.getParameter("id");

if(id != null) {

	
		Safety safety = new Safety().getSafety(id);
	

	response.setContentType("text/xml");
	response.setHeader("Cache-Control", "no-cache");

	response.getWriter().write("<safety>");
	response.getWriter().write("<sid>" + safety.getSafetyId() + "</sid> "); 
	response.getWriter().write("<un_number>" + safety.getUn_Number()+ "</un_number>");
	response.getWriter().write("<other_number>" + safety.getOther_number() + "</other_number>");
	response.getWriter().write("<desc>" + safety.getSafetyDescription() + "</desc>"); 
	if(safety.isSafetyActive())
	 response.getWriter().write("<active>1</active>");
	 else
	 response.getWriter().write("<active>0</active>"); 
	   
	 response.getWriter().write("</safety>");   
	
	
      
} else {

	response.setStatus(HttpServletResponse.SC_NO_CONTENT);
}

	
    	
 %>



