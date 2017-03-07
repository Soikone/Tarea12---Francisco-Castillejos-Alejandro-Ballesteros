<%-- 
    Document   : escrutinio
    Created on : 20-dic-2016, 23:32:59
    Author     : Angela
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.partido"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Escrutinio</title>
        <link rel="stylesheet" type="text/css" href="css/estilos.css" title="style" />
    </head>
    <body>
        <div id="contenedor">
            <div id="principal">
                    <table id="votar">
                        <tr>
                          <td><strong>Logo</strong></td>
                          <td><strong>Acrónimo</strong></td>
                          <td><strong>Nombre</strong></td>
                          <td><strong>Numero de votos</strong></td>
                        </tr>
                        <%
                            ArrayList<partido> partidos =(ArrayList)session.getAttribute("backup");
                            Iterator It=partidos.iterator();
                            while(It.hasNext()){
                                partido p = (partido)It.next();
                                %>
                                <tr>
                                    <td><img src="imagenes/<% out.print(p.getImagen()); %>"/></td>
                                    <td><% out.print(p.getAcronimo()); %></td>
                                    <td><% out.print(p.getNombre()); %></td>
                                    <td><% out.print(p.getNumVotos()); %></td>
                                </tr> 
                                <%
                            }
                        %>    



                    </table>
                        <a href="login.jsp" id="escrutinioA">Salir</a>
            </div>
        </div>
    </body>
</html>
