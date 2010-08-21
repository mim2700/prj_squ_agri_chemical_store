<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-nested" prefix="nested" %>

<%@ page import="com.squ.agri.store.*" %>
<%@ page import="com.squ.agri.store.users.*" %>
<%@ page import="javax.servlet.http.*" %>

<%

response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>CSS DropDown Menu</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<!-- Keep the http-equiv meta tag for IE8 -->

  <meta http-equiv="X-UA-Compatible" content="IE=8" />

<!-- Link the CSS file here -->

<link rel="stylesheet" type="text/css" media="screen,projection" href="<html:rewrite page="/pages/template/style.css"/>" />

</head>

<body>
    
<%

if (request.getUserPrincipal() != null) {

if(request.getUserPrincipal().getName() != null)
{
		HttpSession	session2	= request.getSession();
		User	user	=	(User) session2.getAttribute(StoreConstants.SESSION_USER);

		if( user == null)
			 {//
			 	User	user2	=	new User().getUser(request.getUserPrincipal().getName());
				 session	=	request.getSession();
				session.setAttribute(StoreConstants.SESSION_USER, user2);
			 }
}	

}

%>

<!-- PULL DOWN MENU - BEGIN -->

<div class="mainmenu">

<ul>
      <li class="li_nc"><html:link page="/welcome.do" target="_self" >Home</html:link></li>
      <li class="li_hc"><html:link page="/checkItems.do" target="_self" >Procurement</html:link><ul class="ul_ch">
         <li class="li_nc"><html:link page="/checkItems.do" target="_self" >Check</html:link></li>
         <li class="li_nc"><html:link page="/orderInvitationList.do"  >Order Invitation List</html:link></li>
         <li class="li_nc"><html:link page="/orderAcceptanceList.do"  >Order Acceptance List</html:link></li>
      </ul></li>
      <li class="li_hc"><html:link page="/requestMaterials.do"  >InHouse Department Activity</html:link><ul class="ul_ch">
         <li class="li_nc"><html:link page="/requestMaterials.do"  >Request Form</html:link></li>
         <li class="li_nc"><html:link page="/approvedItemsList.do"  >Approval List</html:link></li>
      </ul></li>
      <li class="li_nc"><html:link page="/requestedItemsList.do"  >InHouse Central Store Activity</html:link></li>
      <li class="li_nc"><html:link page="/consumption.do"  >Consumption</html:link></li>
      <li class="li_nc"><html:link page="/adjustments.do"  >Adjustment</html:link></li>
<!--       
      <li class="li_hc"><html:link page="#"  >Reports</html:link>
      <ul class="ul_ch">
         <li class="li_nc"><html:link page="/report.do"  >Present Position</html:link></li>
         <li class="li_nc"><html:link page="/rptTransactionDt.do"  >Transactions</html:link></li>
         <li class="li_nc"><html:link page="#"  >Items</html:link></li>
         <li class="li_nc"><html:link page="#"  >Departments</html:link></li>
         
      </ul></li>
 -->      
      <% //if(request.isUserInRole("admin")) {%>
      <li class="li_hc"><html:link page="/adminUserAdd.do"  >Admin</html:link><ul class="ul_ch">
         <li class="li_hc"><html:link page="/adminUserAdd.do"  >User</html:link><ul class="ul_ch">
            <li class="li_nc"><html:link page="/adminUserAdd.do"  >Create User</html:link></li>
            <li class="li_nc"><html:link page="/adminUserUpdate.do"  >Manage User</html:link></li>
         </ul></li>
         <li class="li_hc"><html:link page="/itemGrade.do"  >Item</html:link><ul class="ul_ch">
            <li class="li_nc"><html:link page="/itemGrade.do"  >Grade</html:link></li>
            <li class="li_nc"><html:link page="/itemType.do"  >Type</html:link></li>
            <li class="li_nc"><html:link page="/itemSafety.do"  >Safety</html:link></li>
         </ul></li>
      </ul></li>
      <%// } %>
      <li class="li_hc"><html:link page="/userChangePwd.do"  >Settings</html:link><ul class="ul_ch">
         <li class="li_nc"><html:link page="/userChangePwd.do"  >Change Password</html:link></li>
      </ul></li>
      <!--  li class="li_nc"><html:link page="/welcome.do?logout=true"  >Log out</html:link></li -->
</ul>


</div>

<!-- END OF PULL DOWN MENU -->


</body>
</html>
