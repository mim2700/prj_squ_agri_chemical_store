

<%@page import="com.squ.agri.store.bo.Grade"%>

<%

String id = request.getParameter("id");

if(id != null) {

	
		Grade grade = new Grade().getGrade(id);
	

	response.setContentType("text/xml");
	response.setHeader("Cache-Control", "no-cache");

	response.getWriter().write("<grade>");
	response.getWriter().write("<gid>" + grade.getGradeId() + "</gid> "); 
	response.getWriter().write("<number>" + grade.getGradeNumber() + "</number>");
	response.getWriter().write("<name>" + grade.getGradeName() + "</name>");
	response.getWriter().write("<desc>" + grade.getGradeDescription() + "</desc>"); 
	if(grade.isGradeActive())
	 response.getWriter().write("<active>1</active>");
	 else
	 response.getWriter().write("<active>0</active>"); 
	   
	 response.getWriter().write("</grade>");   
	
	
      
} else {

	response.setStatus(HttpServletResponse.SC_NO_CONTENT);
}

	
    	
 %>
