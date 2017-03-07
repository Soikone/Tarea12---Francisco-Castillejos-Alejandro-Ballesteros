<%-- 
    Document   : ok
    Created on : 20-dic-2016, 21:03:15
    Author     : Angela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ok</title>
        <link rel="stylesheet" type="text/css" href="css/estilos.css" title="style" />
    </head>
    <body>
        <div id="contenedor">
            <div id="principal">
                <%
                String aux = (String)session.getAttribute("aux");
                %><h1><%out.print(aux);%></h1><%
                %>
                <a href="login.jsp">Salir</a>
            </div>
        </div>
    </body>
</html>
