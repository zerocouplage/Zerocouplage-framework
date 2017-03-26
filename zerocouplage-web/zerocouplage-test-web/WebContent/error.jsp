<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page error</title>
</head>
<body>
	<h2>ERROR</h2>
	<table>
		<tr>
			<td>${firstName} <font color="red">${error_firstName}</font></td>
		</tr>
		<tr>
			<td>${lastName} <font color="red">${error_lastName}</font></td>
		</tr>
		<tr>
			<td>${ageout} <font color="red">${error_ageout}</font></td>
		</tr>
		<tr>
			<td>${birthday} <font color="red">${error_birthday}</font></td>
		</tr>
		<tr>
			<td>${tail} <font color="red">${error_tail}</font></td>
		</tr>
		<tr>
			<td>${questionout}</td>
		</tr>
	</table>

	
</body>
</html>