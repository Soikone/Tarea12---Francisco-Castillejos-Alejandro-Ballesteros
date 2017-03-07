<%-- 
    Document   : censo
    Created on : 20-dic-2016, 22:08:46
    Author     : Angela
--%>

<%@page import="Modelo.votante"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Censo</title>
        <link rel="stylesheet" type="text/css" href="css/estilos.css" title="style" />
    </head>
    <body>
        <div id="contenedor">
            <div id="principal">
                <form action="../votar"> 
                    <table id="votar">
                        <tr>
                          <td><strong>DNI</strong></td>
                          <td><strong>Nombre</strong></td>
                          <td><strong>¿Ha votado?</strong></td>
                        </tr>
                        <%
                            ArrayList<votante> votantes =(ArrayList)session.getAttribute("votantes");
                            Iterator It=votantes.iterator();
                            while(It.hasNext()){
                                votante v = (votante)It.next();
                                %>
                                <tr>
                                    <td><% out.print(v.getDni()); %></td>
                                    <td><% out.print(v.getNombre()); %></td>
                                    <td><% if(v.isVoto()){out.print("Si");}else{out.print("No");} %></td>
                                </tr> 
                                <%
                            }
                        %>    



                    </table>


                        <a href="login.jsp" id="censoA">Salir</a>
                </form>
            </div>
        </div>
    </body>
</html>
