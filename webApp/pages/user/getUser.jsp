

<%@page import="com.squ.agri.store.users.User"%>

<%

String id = request.getParameter("id");

if(id != null) {

	User usr = new User().getUser(id);
//System.out.println("-----------------");
//System.out.println(usr.getUid());
//System.out.println("---------------");
	response.setContentType("text/xml");
	response.setHeader("Cache-Control", "no-cache");
    
        // XML formatted response:
	response.getWriter().write("<user><uid>" + usr.getUid() + "</uid> "); 
	response.getWriter().write(" <name>" + usr.getName() + "</name>");
	response.getWriter().write("<role>" + usr.getRole() + "</role>");
	response.getWriter().write("<deptId>" + usr.getDeptId() + "</deptId>"); 
	if(usr.isActive())
	 response.getWriter().write("<active>1</active>");
	 else
	 response.getWriter().write("<active>0</active>"); 
	   
	 response.getWriter().write("</user>");   
	
	
      
} else {
	//nothing to show
	response.setStatus(HttpServletResponse.SC_NO_CONTENT);
}

	
    	
 %>
