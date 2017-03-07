<%-- 
    Document   : seguro
    Created on : 20-dic-2016, 22:43:14
    Author     : Angela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>¿Seguro?</title>
        <link rel="stylesheet" type="text/css" href="css/estilos.css" title="style" />
    </head>
    <body>
        <div id="contenedor">
            <div id="principal">
                <form action="../dispatcher">    
                    <%
                    String aux = (String)session.getAttribute("seguro");
                    %><h1><%out.print(aux);%></h1><%
                    %>
                    <p><input type="submit" value="Si" name="submit">
                        <a href="login.jsp"><input type="button" value="No" name="submit"></a></p>
                </form>
            </div>
        </div>
    </body>
</html>
