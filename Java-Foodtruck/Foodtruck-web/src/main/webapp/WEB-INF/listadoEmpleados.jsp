<%@page import="java.util.LinkedList"%>
<%@page import="entities.Empleado"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    
    <link rel="stylesheet" href="style/header.css">
    <link rel="stylesheet" href="style/listadoEmpleados.css">
    <script src="https://kit.fontawesome.com/b95dc486b7.js" crossorigin="anonymous"></script>
    
    <title>Foodtruck</title>
    
    <%LinkedList<Empleado> le = (LinkedList<Empleado>)request.getAttribute("listaEmpleados");%>
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

    <div class="tabla">
		<div class="tabla__container">
            <h1>Listado de Empleados</h1>
            <table>
                <thead>
                <tr>
                    <th>DNI</th>
                    <th>Nombre</th>
                    <th>Turno</th>
                    <th>Roles</th>
                    <th>Editar</th>
                    <th>Borrar</th>
                </tr>
                </thead>
                <tbody>
                <% for (Empleado e : le){ %>
                    <tr>
                        <td><%=e.getDni()%></td>
                        <td><%=e.getNombre()%></td>
                        <td><%=e.getTurno() %></td>
                        <td><%= e.getRoles() %></td>
                        <td class="link"><a href="empleadoeditar?dni=<%=e.getDni()%>"><i class="fa-solid fa-pencil"></i></a></td>
                        <td class="link"><a href="empleadoborrar?dni=<%=e.getDni()%>"><i class="fa-regular fa-circle-xmark"></i></a></td>
                    </tr>
                <%} %>
                </tbody>
            </table>
            <a class="button" href="altaEmpleado.html">Nuevo Empleado</a>
        </div>
	</div>
</body>
</html>