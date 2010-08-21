
<%@page import="java.io.IOException"%>
<%@page import="java.io.PrintWriter"%>

<%@page import="com.squ.agri.store.StoreConstants"%>
<%@page import="com.squ.agri.store.bo.Item"%>
<%@page import="com.squ.agri.store.dao.inHouse.ConsumeSubItemsDb"%>

<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.squ.agri.store.dbUtil.HibernateUtil"%>
<%@page import="com.squ.agri.store.users.User"%>

<%

String id =  (String)request.getParameter("id");
		String value = (String)request.getParameter("value");
		String searchBy = (String)request.getParameter("searchBy");
		String from = (String)request.getParameter("from");

		if(id != null) {

			HttpSession session1 = request.getSession(true);
		
			User user = (User) session1.getAttribute(StoreConstants.SESSION_USER);
			
			String searchFrom="Department";
			
			 if(user.getRole().equalsIgnoreCase("Central_Store"))
				searchFrom="Central_Store";
			
			Item[]	arrItem	= new ConsumeSubItemsDb().itemsListFrom_DS(id, value, searchBy,searchFrom);
			
		
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
		    
	response.getWriter().println("<items>");
				for (int i=0;i<arrItem.length;i++)
				{
					response.getWriter().println("<item>");
			        
				
					 response.getWriter().println(" <code>" + arrItem[i].getItemCode() + "</code>");
					 response.getWriter().println(" <name>" + arrItem[i].getItemName() + "</name>");
					 response.getWriter().println(" <quantity>" + arrItem[i].getItemQuantity() + "</quantity>");
				
					   
					response.getWriter().println("</item>");
				
				}

			response.getWriter().println("</items>");			  
				      
		} else {
			//nothing to show
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		}



%>