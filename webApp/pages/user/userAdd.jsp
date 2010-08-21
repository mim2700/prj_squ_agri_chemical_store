<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-nested" prefix="nested" %>

<html:html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>Add User</title>

<!-- Link the CSS file here -->
<link rel="stylesheet" type="text/css" media="screen,projection" href="<html:rewrite page="/pages/template/agriStyle.css"/>" />

<!-- Link the JS file here -->
 <script language="javascript" type="text/javascript" src="<html:rewrite page="/pages/js/ajaxGetObjects.js"/>"></script>
 <script language="javascript" type="text/javascript" src="<html:rewrite page="/pages/js/agriStore.js"/>"></script>
 
</head>

<body>

<html:form method="POST" action="/adminUserAddResult">

<table border="0" width="100%" id="table1" cellspacing="1" cellpadding="0">
	<tr>
		<td >&nbsp;</td>
	</tr>
	<tr class="pageTitle">
		<td>
			<font><bean:message key="page.adminUserAdd.heading"/></font>
		</td>
	</tr>
	<tr class="fill">
		<td >&nbsp;</td>
	</tr>
	<tr class="fill">
		<td align="center">
			<table border="1" class="adminUserAdd">
				<tr >
					<td align="right" class="label">
						<bean:message key="page.adminUserAdd.Uid"/>
					</td>
					<td class="input" align="left">
						 <input type="text" name="uid" maxlength="15" >
					</td>
				</tr>
				<tr >
					<td align="right" class="label">
						<bean:message key="page.adminUserAdd.Name"/>
					</td>
					<td class="input" align="left">
						 <input type="text" name="name" maxlength="100">
					</td>
				</tr>
				<tr >
					<td align="right" class="label">
						<bean:message key="page.adminUserAdd.Pwd"/>
					</td>
					<td align="left" class="input">
						<input type="password" name="pwd">
					</td>
				</tr>
				<tr >
					<td align="right" class="label">
						<bean:message key="page.adminUserAdd.Role"/>
					</td>
					<td class="input" align="left">
						<html:select property="role">
							<html:option value="0">Select Role</html:option>
							<html:optionsCollection  name="allRoles"  label="role_name" value="role_id" /> 
						</html:select>
					</td>
				</tr>
				<tr >
					<td align="right" class="label">
						<bean:message key="page.adminUserAdd.department"/>
					</td>
					<td class="input" align="left">
						<html:select property="deptId">
							<html:option value="0">Select Department</html:option>
							<html:optionsCollection  name="allDepartments"  label="deptName" value="deptId" /> 
						</html:select>
					</td>
				</tr>
				<tr >
					<td  class="input" colspan="2" align="center">
						<input type="checkBox" name="active" size="20">
						<bean:message key="page.adminUserAdd.active"/>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr class="fill">
		<td>&nbsp;</td>
	</tr>
	<tr class="pageFooter">
		<td align="center">
			<input type="button" value="AddUser" onclick="check_AddUser_Empty_and_submit()" name="B1">
		</td>
	</tr>
</table>

</html:form>


</body>

</html:html>