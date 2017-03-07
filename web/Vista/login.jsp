<%-- 
    Document   : login
    Created on : 16-dic-2016, 10:23:16
    Author     : franciscocr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="css/estilos.css" title="style" />
    </head>
    <body>
        <div id="contenedor">
            <div id="principal">
                <form action="../dispatcher">                
                    <fieldset>
                        <legend>Login</legend>
                        <p>Dni <input type="text" name="dni" size="9" maxlength="9"/></p>
                        <p>Contraseña <input type="password" name="password"/></p>
                        <p><input type="submit" value="Entrar" name="submit">
                        <input type="submit" value="Borrar votante" name="submit">
                        <input type="submit" value="Cerrar escrutinio" name="submit">
                        <input type="submit" value="Censar" name="submit"></p>
                    </fieldset>
                </form>
                <a href="registro.jsp">¿No tienes cuenta?. Registrate</a>
            </div>
        </div>
    </body>
</html>
