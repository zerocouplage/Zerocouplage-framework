<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.zerocouplage.application.web.bean.*"%>
<%@page import="java.util.List"%>
<%@ page import="org.zerocouplage.application.web.business.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="style/style.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultation des données</title>
</head>
<body class="formulaire">
	<div class="liste">
		<CENTER>
			<H3 style="color: white; margin-top: 3em; font-size: 25px;">Liste
				des candidats</H3>
		</CENTER>
	</div>
	<%
		List<BeanUser> userList = RecrutBusiness.getUsers();

		if (userList.isEmpty()) {
			response.sendRedirect("EmptyDB.jsp");
		}
		String pathCv = request.getParameter("pathCv");
		String idCandidat = String.valueOf(request
				.getParameter("idCandidat"));
	%>

	<div class="table">
		<TABLE BORDER="1" CELLPADDING="3" CELLSPACING="1"
			style="color: white; margin-top: 3em;">
			<TR>
				<TH>Nom</TH>
				<TH>Prénom</TH>
				<TH>date de naissance</TH>
				<TH>Email</TH>
				<TH>Civilité</TH>
				<TH>nbre d'années d'experience</TH>
				<TH>Type de la demande</TH>
				<TH>Date de la demande</TH>
				<TH>Action</TH>
				<TH>Supprimer</TH>
			</TR>
			<%
				Iterator iter = userList.iterator();
				while (iter.hasNext()) {
					BeanUser user = (BeanUser) iter.next();
			%>

			<TR>
				<TD><%=user.getNom()%></TD>
				<TD><%=user.getPrenom()%></TD>
				<TD><%=user.getDan()%></TD>
				<TD><%=user.getEmail()%></TD>
				<TD><%=user.getCivilite()%></TD>
				<TD><%=user.getNbAnneeExp()%></TD>
				<TD><%=user.getNatureDemande()%></TD>
				<TD><%=user.getDateDemande()%></TD>
				<TD>
					<%
						pathCv = user.getPath();
					%>
					<FORM METHOD="POST" action="showCv.zc">
						<input type="hidden" name="pathCv" value="<%=pathCv%>" /> <input
							type="hidden" name="_ZC_SOURCE_VIEW_NAME" value="Data" /> <input
							type="submit" value="voir Cv" />
					</FORM>

				</TD>
				<TD>
					<%
						idCandidat = String.valueOf(user.getIdUser());
					%>
					<FORM METHOD="POST" action="deleteCandidat.zc">
						<input type="hidden" name="idCandidat" value="<%=idCandidat%>" />
						<input type="hidden" name="_ZC_SOURCE_VIEW_NAME" value="Data" />
						<input type="submit" value="supprimer" />
					</FORM>
				</TD>
			</TR>
			<%
				}
			%>
		</TABLE>
<!-- 		<div class="btn_table"> -->
		<input type="submit" value="retour" style=" margin-top:1em; margin-left:73em; width: 7em; height: 2em;"
			onclick="location.href='return.zc'">
<!-- 	</div> -->
	</div>
	
</body>
</html>