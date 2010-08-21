
<%@page import="java.io.IOException"%>
<%@page import="java.io.PrintWriter"%>

<%@page import="com.squ.agri.store.StoreConstants"%>
<%@page import="com.squ.agri.store.bo.Item"%>
<%@page import="com.squ.agri.store.dao.inHouse.ConsumeSubItemsDb"%>


<%

		String id =  (String)request.getParameter("id");
	
		if(id != null) {

		//	User usr = new User().getUser(id);
			
			
			Item item = (Item) new ConsumeSubItemsDb().getItemById(id);
			
			boolean isMultiple	=item.isMultipleSubItem();
		
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");

			response.getWriter().println("<item>");

			response.getWriter().println(" <code>"+item.getItemCode()+"</code>");
			response.getWriter().println(" <name>"+item.getItemName()+"</name>");
			response.getWriter().println(" <type>"+item.getType()+"</type>");
			
			if(isMultiple)
				response.getWriter().println(" <isMultiple>1</isMultiple>");
			else
				response.getWriter().println(" <isMultiple>0</isMultiple>");
				
			response.getWriter().println(" <safety>"+item.getSafety()+"</safety>");
			response.getWriter().println(" <grade>"+item.getGrade()+"</grade>");
			response.getWriter().println(" <measurment>"+item.getMeasurment()+"</measurment>");
						   
			response.getWriter().println("</item>");
				
		  
				      
		} else {
			//nothing to show
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		}



%>