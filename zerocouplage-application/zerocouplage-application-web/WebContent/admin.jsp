<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="style/style.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Connexion administrateur</title>
</head>
<body class="login" >

	<%
		String sLogin = request.getParameter("login");
		String sPass = request.getParameter("pass");
		if (sLogin == null) {
			sLogin = "";
		}
		if (sPass == null) {
			sPass = "";
		}
	%>
	<font color="red">${GLOBAL_MESSAGE}</font>
	<form action="processing.zc" method="POST">
		<input type="hidden" name="_ZC_SOURCE_VIEW_NAME" value="viewI" />
		<div class="loginn">
		<table style="color: white;">

			<tr>
				<td>Login:</td>
				<td><input type="text" name="login" value="<%=sLogin%>" /> <font
					color="red">${error_login_admin}</font></td>
			</tr>
			<tr/>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="pass" value="<%=sPass%>" /> <font
					color="red">${error_password_admin}</font></td>

			</tr>



		</table></div>
		
		<div class="button">
			<input type="submit" value="se connecter" style=" width: 7em; height: 2em;" /> 
			<input type="button" style=" width: 10em; height: 2em;"
				value="retour  d'acceuil" onclick="location.href='return.zc'" />

		</div>


	</form>
</body>

</html>