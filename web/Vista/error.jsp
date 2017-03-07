<%-- 
    Document   : error
    Created on : 20-dic-2016, 21:04:01
    Author     : Angela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
        <link rel="stylesheet" type="text/css" href="css/estilos.css" title="style" />
    </head>
    <body>
        <div id="contenedor">
            <div id="principal">
                <%
                String aux = (String)session.getAttribute("error");
                %><h1><%out.print(aux);%></h1><%
                %>
                <input type='button' value='Volver' onClick='history.go(-1);'>
            </div>
        </div>
    </body>
</html>
