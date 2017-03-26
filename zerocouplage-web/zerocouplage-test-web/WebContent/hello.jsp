<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page Hello</title>
</head>
<body>

<%--  <H1>    Hello  ${out.firstname} ${out.lastname}</H1> --%>
<%--  <H1> vous avez ${out.ageout} ans</H1> --%>
<%--   <H1> vous étes né(e) le  ${out.birthday} </H1>  --%>
<%--    <H1>votre taille est de  ${out.tail} m</H1> --%>
<%--     <H1>votre choix est   ${out.questionout} </H1> --%>
<%--     <H1>votre file est   ${out.file}</H1> --%>

<H1>Hello! ${out.firstname} ${out.lastname}</H1>
<H1>you have : ${out.ageout} ans</H1>
<H1>your date of birth :${out.birthday}</H1>
<H1>your size : ${out.tail} m</H1>
<H1>your response : ${out.questionout}</H1>
<H1>your cv : ${out.file} </H1>
</body>
</html>