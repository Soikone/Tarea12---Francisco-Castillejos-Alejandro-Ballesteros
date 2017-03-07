<%-- 
    Document   : votar
    Created on : 19-dic-2016, 14:26:34
    Author     : franciscocr
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.partido"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Votaciones</title>
        <link rel="stylesheet" type="text/css" href="css/estilos.css" title="style" />
    </head>
    <body>
        <div id="contenedor">
            <div id="principal">
                <form action="../votar"> 
                    <table id="votar">
                        <tr>
                          <td><strong>Logo</strong></td>
                          <td><strong>Acrónimo</strong></td>
                          <td><strong>Nombre</strong></td>
                          <td><strong>Votar</strong></td>
                        </tr>
                        <%
                            ArrayList<partido> partidos =(ArrayList)session.getAttribute("partidos");
                            Iterator It=partidos.iterator();
                            while(It.hasNext()){
                                partido p = (partido)It.next();
                                %>
                                <tr>
                                    <td><img src="imagenes/<% out.print(p.getImagen()); %>"/></td>
                                    <td><% out.print(p.getAcronimo()); %></td>
                                    <td><% out.print(p.getNombre()); %></td>
                                    <td><input type="radio" name="radioVoto" value="<% out.print(p.getNombre()); %>"></td>
                                </tr> 
                                <%
                            }
                        %>    



                    </table>


                    <button type="submit">Votar</button>
                </form>
            </div>
        </div>
    </body>
</html>
