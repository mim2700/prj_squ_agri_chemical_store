<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
<title>Add User</title>

                               
<link rel="stylesheet" type="text/css" media="screen,projection" href=""/>

</head><body>

<form action="/userUpdate" method="POST">

<table border="0" width="100%" id="table1" cellspacing="1" cellpadding="0">
	<tr>
		<td>&nbsp;</td>
	</tr>
	<tr class="pageTitle">
		<td align="center">
			<b><font size="6"><bean:message key="page.userUpdate.heading"/></font></b>
		</td>
	</tr>
	<tr class="fill">
		<td>&nbsp;</td>
	</tr>
	<tr class="fill">
		<td align="center">
			<table border="1" class="userUpdate">
				<tr>
					<td align="right" class="label">
						<bean:message key="page.userUpdate.Pwd"/>
					</td>
					<td class="input">
						 <input type="text" name="j_username" size="20"/>
					</td>
				</tr>
				<tr>
					<td align="right" class="label">
						<bean:message key="page.userUpdate.NewPwd"/>
					</td>
					<td align="left" class="input">
						<input type="password" name="j_password" size="20"/>
					</td>
				</tr>
				<tr>
					<td align="right" class="label">
						<bean:message key="page.userUpdate.ConfirmPwd"/>
					</td>
					<td align="left" class="input">
						<input type="text" name="j_passwordConfirm" size="20"/>
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
			<input type="submit" value="Update"></input>
		</td>
	</tr>
</table>

</form>

</body></html>