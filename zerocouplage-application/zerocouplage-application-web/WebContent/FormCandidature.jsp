<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="style/style.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulaire de connexion</title>
</head>
<body class="formulaire">

	<%
		String sFirstName = (String)request.getAttribute("firstName");
		String sLastName = (String)request.getAttribute("lastName");
		String sBirthday = (String)request.getAttribute("birthday");
		String sMail = (String)request.getAttribute("mail");
		String sCivilite = (String)request.getAttribute("civilite");
		String sNatureDemande = (String)request.getAttribute("natureDemande");
		String sNbAnneeExp = (String)request.getAttribute("nbAnneeExp");
		String sCv = (String)request.getAttribute("cv");
		if (sFirstName == null)
			sFirstName = "";
		if (sLastName == null)
			sLastName = "";
		if (sBirthday == null)
			sBirthday = "";
		if (sMail == null)
			sMail = "";
		if (sCivilite == null)
			sCivilite = "";
		if (sNatureDemande == null)
			sNatureDemande = "";
		if (sNbAnneeExp == null)
			sNbAnneeExp = "";
		if (sCv == null)
			sCv = "";
		
	%>


	<font color="red">${GLOBAL_MESSAGE}</font>
	<div class="form">
	
	<form action="Formprocessing.zc" method="POST"
		enctype="multipart/form-data">

		<input type="hidden" name="_ZC_SOURCE_VIEW_NAME"
			value="viewFormCandidature" />
<!-- 		<div class="form_table"> -->
		<table style=" margin-top:60px;margin-left:80px; font-size: 20px;color: white; ">

			<tr >
				<td width="55%">Nom</td>
				<td><input type="text" name="firstName"
					value="<%=sFirstName%>" /> <font color="red">${error_firstName}</font></td>
			</tr>
			<tr>
				<td>Prénom</td>
				<td><input type="text" name="lastName" value="<%=sLastName%>" />
					<font color="red">${error_lastName}</font></td>
			</tr>
			<tr>
				<td>Date de naissance </td>
				<td><input type="text" name="birthday" value="<%=sBirthday%>" />
					<font color="red">${error_birthday}</font></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="mail" value="<%=sMail%>" /> <font
					color="red">${error_mail}</font></td>
			</tr>
			<tr>
				<td>Civilité</td>
				<td><input type="radio" name="civilite" value="M">M <input
					type="radio" name="civilite" value=" Mme" checked> Mme <input
					type="radio" name="civilite" value="Mlle"> Mlle</td>
			</tr>

			<tr>
				<td>Nombre d'années d'expérience</td>
				<td><input type="text" name="nbAnneeExp"
					value="<%=sNbAnneeExp%>" /> <font color="red">${error_nbAnneeExp}</font></td>
			</tr>
			<tr>
				<td>Votre demande?</td>
				<td><select name="natureDemande">
						<option value="stage">Stage
						<option value="poste">Poste
				</select><font color="red">${error_natureDemande}</font></td>
			</tr>
			<tr>
				<td>votre CV</td>
				<td><input type="file" name="cv" value="<%=sCv%>" /> <font
					color="red">${error_Cv}</font></td>
			</tr>
			<tr>
				<td colspan="3" align="right">
				<input type="submit"
					value="enregistrer" style=" width: 7em; height: 2em;" />
					<input type="button" value="Retour" style=" width: 7em; height: 2em;"
					onclick="location.href='return.zc';" /></td>

			</tr>
		</table>
<!-- 		</div> -->
		
		
	</form>
	</div>

</body>
</html>