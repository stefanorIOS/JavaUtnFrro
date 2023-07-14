<%@page import="entities.Empleado"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="style/reset.css">
    <link rel="stylesheet" href="style/header.css">
    <link rel="stylesheet" href="style/updateEmpleado.css">
    <script src="https://kit.fontawesome.com/b95dc486b7.js" crossorigin="anonymous"></script>
    <title>Foodtruck</title>
    
    <% Empleado e = (Empleado) request.getAttribute("emp");%>
</head>
<body>
    <header>
        <div class="header">
            <div class="header__container">
                <nav><a>Logo</a></nav>
                <nav><a>Pedidos</a></nav>
                <nav><a>Productos</a></nav>
                <nav><a href="administracion.html">Administración</a></nav>
            </div>
        </div>
    </header>

    <div class="form" action="empleadoeditar?dni=<%=e.getDni()%>" method="post">
        <form action="listadoempleados" method="post">
            <div class="form__container">
                <h1>Modificar Empleado</h1>
                <div class="form__item">
                    <label>DNI</label>
                    <input name="dni" type="text" maxlength="8" value=<%=e.getDni() %>>
                </div>
                <div class="form__item">
                    <label>Nombre</label>
                    <input name="nombre" type="text" value=<%=e.getNombre()%>>
                </div>
                <div class="form__item">
                    <label>Turno</label>
                    <select name="turno">
                    	<option value="none" selected disabled hidden>Select an Option</option>
                        <option value="Tarde">Tarde</option>
                        <option value="Noche">Noche</option>
                    </select>
                </div>
                <div class="form__item">
                    <label>Contraseña</label>
                    <input name="password">
                </div>
                <button class="button" type="submit">Modificar</button>	
            </div>      
        </form>
    </div>
</div>
    
</body>
</html>