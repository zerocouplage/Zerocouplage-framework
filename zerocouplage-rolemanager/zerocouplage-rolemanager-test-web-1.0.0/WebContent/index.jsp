<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="com.zcrolemanager.impl.controller.ZCRule" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulaire de conexion</title>
</head>
<body>

<%
ZCRule zcr= new ZCRule();
String subject= zcr.getSubject();
String sLastName = request.getParameter("lastname");  
if(sLastName == null)sLastName = "";
%>
   <fieldset style="margin-top: 100px;color: fuchsia;">
   <legend style="color: blue">Gestion d'accès avec Orbac</legend>
   <font color="red">${GLOBAL_MESSAGE}</font> 
  
   <form style="margin-top: 30px;" action="gnote_rectify.0c"  method="POST" >
   <input type="hidden" name="_ZC_SOURCE_VIEW_NAME"  value="viewI" />
    <table>   
	    <tr>  
	        <td>Status :  <%=subject %>    </td>
	         
		    <td><input type="hidden" name="lastname" value="<%=subject %>" size="7"/></td>      	    
	    </tr>  
	    
	    <tr>
		    <td><input style="width:100px;margin-left: 5px;"   type="submit" name="out_action" value="Rectify" /></td>  
	    </tr>    
    </table>    
   </form>
   
   <form action="gnote_show.0c"  method="POST" >
   <input type="hidden" name="_ZC_SOURCE_VIEW_NAME"  value="viewI" />
    <table>   
        <tr>  
	             
	    <td>     
		    <input type="hidden" name="lastname" value="<%=subject %>" size="7"/>      	    
	    </td>  
	    
		    <td><input style="width:100px;" type="submit" name="out_action" value="Show" /></td>   
	    </tr>    
    </table>    
   </form>  
      
   <form action="gnote_save.0c"  method="POST" >
   <input type="hidden" name="_ZC_SOURCE_VIEW_NAME"  value="viewI" />
    <table>   
        <tr>  
	                
	    <td>     
		    <input type="hidden" name="lastname" value="<%=subject %>" size="7"/>      	    
	    </td>  
	   
		    <td><input style="width:100px;"   type="submit" name="out_action" value="Save" size="20" /></td>  
	    </tr>    
    </table>    
   </form>
   </fieldset>
</body>  
</html>