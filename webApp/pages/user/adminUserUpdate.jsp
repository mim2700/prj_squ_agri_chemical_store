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

</script>
    
</head>

<body>


<html:form method="POST" action="/adminUserUpdateResults">

<table border="0" width="100%" id="table1" cellspacing="1" cellpadding="0">
	<tr>
		<td >&nbsp;</td>
	</tr>
	<tr class="pageTitle">
		<td>
			<font><bean:message key="page.adminUserUpdate.heading"/></font>
		</td>
	</tr>
	<tr class="fill">
		<td >&nbsp;</td>
	</tr>
	<tr class="fill">
		<td align="center">
			<table border="1" class="adminUserUpdate">
				<tr >
					<td align="right" class="label">
						<bean:message key="page.adminUserUpdate.user"/>
					</td>
					<td align="left" class="input">
				
						<html:select property="uid" onchange="getUserObj(this.form,value)">
							<html:option value="0">Select User</html:option>
							<html:optionsCollection  name="allUsers"  label="uid" value="uid" /> 
						</html:select>

					</td>
				</tr>
				<tr >
					<td align="right" class="label">
						<bean:message key="page.adminUserUpdate.name"/>
					</td>
					<td class="input" align="left">
						<input type="text" name="name" size="20" maxlength="100">
					</td>
				</tr>
				<tr >
					<td align="right" class="label">
						<bean:message key="page.adminUserUpdate.pwd"/>
					</td>
					<td class="input" align="left">
						<input type="password" style="visibility:hidden;" name="pwd" size="20">
						<input type="checkBox" name="changePassword" size="20" onclick="javascript:if(this.checked==true){ document.getElementById('pwd').style.visibility='visible'; }else {document.getElementById('pwd').value=''; document.getElementById('pwd').style.visibility='hidden'; };">
						Change Password
					</td>
				</tr>
				<tr>
					<td align="right" class="label">
						<bean:message key="page.adminUserUpdate.department"/>
					</td>
					<td class="input">
						<html:select property="deptId">
							<html:option value="0">Select Department</html:option>
							<html:optionsCollection  name="allDepartments"  label="deptName" value="deptId" /> 
						</html:select>
					</td>
				</tr>
				<tr >
					<td align="right" class="label">
						<bean:message key="page.adminUserUpdate.role"/>
					</td>
					<td align="left" class="input">
						<html:select property="role">
							<html:option value="0">Select Role</html:option>
							<html:optionsCollection  name="allRoles"  label="role_name" value="role_id" /> 
						</html:select>
					</td>
					</td>
				</tr>
				<tr >
					<td  class="input" colspan="2">
						<input type="checkBox" name="active" size="20">
						<bean:message key="page.adminUserUpdate.active"/>
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
			<input type="button" value="Update" onclick="check_updateUser_Empty_and_submit()" />
		</td>
	</tr>
</table>

</html:form>

</body>

</html:html>