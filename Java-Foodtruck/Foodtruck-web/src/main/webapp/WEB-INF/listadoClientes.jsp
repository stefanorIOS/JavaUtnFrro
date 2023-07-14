<%@page import="java.util.LinkedList"%>
<%@page import="entities.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style/reset.css">
<link rel="stylesheet" href="style/header.css">
<title>Foodtruck</title>

<%LinkedList<Cliente> lc = (LinkedList<Cliente>)request.getAttribute("listaclientes"); %>
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

<div>
		<table>
			<thead>
			<tr>
				<th>DNI</th>
				<th>Nombre</th>
				<th>Dirección</th>
				<th></th>
				<th></th>
			</tr>
			</thead>
			<tbody>
			<% for (Cliente c : lc){ %>
				<tr>
					<td><%=c.getDni()%></td>
					<td><%=c.getNombre()%></td>
					<td><%=c.getDireccion()%></td>
					<td><a href="clienteeditar?dni=<%=c.getDni()%>">editar</a></td>
					<td><a href="clienteborrar?dni=<%=c.getDni()%>">borrar</a></td>
				</tr>
				
			<%} %>
			</tbody>
		</table>
		<a href="altaCliente.html">Nuevo Cliente</a>
	</div>

</body>
</html>