<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulaire de conexion</title>
</head>
<body>
	<%
		String sFirstName = request.getParameter("firstName");
		String sLastName = request.getParameter("lastName");
		String sage = request.getParameter("ageout");
		String sBirthday = request.getParameter("birthday");
		String sTail = request.getParameter("tail");
		String sQuestionout = request.getParameter("questionout");
		String sFile = request.getParameter("fil");
		if (sFirstName == null)
			sFirstName = "";
		if (sLastName == null)
			sLastName = "";
		if (sage == null)
			sage = "";
		if (sBirthday == null)
			sBirthday = "";
		if (sTail == null)
			sTail = "";
		if (sQuestionout == null)
			sQuestionout = "";
		if (sFile == null)
			sFile = "";
	%>


	<font color="red">${GLOBAL_MESSAGE}</font>
	<form action="processing.zc" method="POST"
		enctype="multipart/form-data">
		<input type="hidden" name="_ZC_SOURCE_VIEW_NAME" value="viewI" />
		<table>

			<tr>
				<td>First name:</td>
				<td><input type="text" name="firstName"
					value="<%=sFirstName%>" /> <font color="red">${error_firstName}</font></td>
			</tr>
			<tr>
				<td>Last name</td>
				<td><input type="text" name="lastName" value="<%=sLastName%>" />
					<font color="red">${error_lastName}</font></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><input type="text" name="ageout" value="<%=sage%>" /> <font
					color="red">${error_ageout}</font></td>
			</tr>

			<tr>
				<td>Date de naissance</td>
				<td><input type="text" name="birthday" value="<%=sBirthday%>" />
					<font color="red">${error_birthday}</font></td>
			</tr>

			<tr>
				<td>Taille</td>
				<td><input type="text" name="tail" value="<%=sTail%>" /> <font
					color="red">${error_tail}</font></td>
			</tr>
			<tr>
				<td>Are you interested in zerocouplage?</td>
				<td><input type="radio" name="questionout" value="true">Yes<br>
					<input type="radio" name="questionout" value="false" checked>
					No<br></td>
			</tr>
			<tr>
				<td>File</td>
				<td><input type="file" name="fil" value="<%=sFile%>" /> <font
					color="red">${error_taille}</font></td>
			</tr>
			<tr>
				<td colspan="3" align="center"><input type="submit"
					value="enregistrer" /></td>
			</tr>
		</table>

	</form>
</body>
</html>