<%-- 
    Document   : registro
    Created on : 16-dic-2016, 9:47:02
    Author     : franciscocr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
        <link rel="stylesheet" type="text/css" href="css/estilos.css" title="style" />
    </head>
    <body>
        <div id="contenedor">
            <div id="principal">
                <form action="../registraUsuario">                
                    <fieldset>
                        <legend>Registro</legend>
                        <p>Nombre <input type="text" name="nombre"/></p>
                        <p>Dni <input type="text" name="dni" size="9" maxlength="9" /></p>
                        <p>Contraseña <input type="password" name="password"/></p>
                        <p><input type="submit" value="Registrar" name="registrar"></p>
                    </fieldset>
                </form>
            </div>
        </div>
    </body>
</html>
