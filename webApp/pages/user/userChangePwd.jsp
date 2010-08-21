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

</head>

<body>

<html:form method="POST" action="/userChangePwdResults">

<table border="0" width="100%" id="table1" cellspacing="1" cellpadding="0">
	<tr>
		<td >&nbsp;</td>
	</tr>
	<tr class="pageTitle">
		<td>
			<font><bean:message key="page.userUpdate.heading"/></font>
		</td>
	</tr>
	<tr class="fill">
		<td >&nbsp;</td>
	</tr>
	<tr class="fill">
		<td align="center">
			<table border="1" class="userUpdate">
				<tr >
					<td align="right" class="label">
						<bean:message key="page.userUpdate.Pwd"/>
					</td>
					<td class="input">
						<html:password property="pwd" size="20"/>
					</td>
				</tr>
				<tr >
					<td align="right" class="label">
						<bean:message key="page.userUpdate.NewPwd"/>
					</td>
					<td align="left" class="input">
						<html:password property="newPwd" size="20"/>
					</td>
				</tr>
				<tr >
					<td align="right" class="label">
						<bean:message key="page.userUpdate.ConfirmPwd"/>
					</td>
					<td align="left" class="input">
						<html:password property="confirmPwd" size="20"/>
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
			<html:submit value="Update" />
		</td>
	</tr>
</table>

</html:form>

</body>

</html:html>