
<%@page import="java.io.*"%>

<%@page import="com.squ.agri.store.StoreConstants"%>
<%@page import="com.squ.agri.store.bo.SubItem"%>
<%@page import="com.squ.agri.store.dao.inHouse.ConsumeSubItemsDb"%>

<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.squ.agri.store.dbUtil.HibernateUtil"%>
<%@page import="com.squ.agri.store.users.User"%>

<%

		String id =  (String)request.getParameter("id");
		String deptId =  (String)request.getParameter("deptId");
		String adjustId =  (String)request.getParameter("adjustId");
		System.out.println(adjustId);
		if(id != null) {

		HttpSession session1 = request.getSession(true);
  //session.setMaxInactiveInterval(-1);
		
		User user = (User) session1.getAttribute(StoreConstants.SESSION_USER);
		
		String searchFrom="Department";
		
		 if(user.getRole().equalsIgnoreCase("Central_Store"))
			searchFrom="Central_Store";
			
							
			SubItem[]	arrItem	= new ConsumeSubItemsDb().subItemsList(id, deptId , -1,searchFrom,adjustId);
			
			
		
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
		    
			response.getWriter().println("<items>");
	
				for (int i=0;i<arrItem.length;i++)
				{
					response.getWriter().println("<item>");
			        
					response.getWriter().println(" <code>" + arrItem[i].getSubItemId() + "</code>");
					response.getWriter().println(" <quantity>" + Integer.toString(arrItem[i].getQtyAvailable()) + "</quantity>");
					
					response.getWriter().println("</item>");
				
				}

			response.getWriter().println("</items>");			  
				      
		} else {
			//nothing to show
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		}



%>