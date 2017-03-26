<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="style/style.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Demande envoyée</title>
</head>
<body class="login">
<center>
<div class="phrase" style="color: white; margin-left: 2em;">
<h1> <font size="5">Merci ${userout.civilite}  ${userout.firstName} ${userout.lastName} </font>  </h1>
<h1> <font size="5">votre demande a été envoyée avec succès!</font>  </h1>
</div>
<input  type="button" value="Retour"  style=" margin-top:22em; margin-left:-1em; width: 7em; height: 2em;" onclick="location.href='return.zc';"   />

</center>

<!-- <div class="btn_return"> -->
<!-- </div> -->

</body>
</html>
