<%@page import="java.util.LinkedList"%>
<%@page import="entities.Bebida"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
   <link rel="stylesheet" href="style/header.css">
    <link rel="stylesheet" href="style/listadoEmpleados.css">
    <script src="https://kit.fontawesome.com/b95dc486b7.js" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Foodtruck</title>

<%LinkedList<Bebida> Be = (LinkedList<Bebida>)request.getAttribute("listadoBebida"); %>
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

	<div class="table">
		<div class="table_container">
			<table>
			<thead>
			<tr>
				<th>Id</th>
				<th>Precio</th>
				<th>Nombre</th>
				<th>Litros</th>
				<th></th>
				<th></th>
			</tr>
			</thead>
			<tbody>
			<% for (Bebida b : Be){ %>
				<tr>
					<td><%=b.getId()%></td>
					<td><%=b.getPrecio()%></td>
					<td><%=b.getNombre()%></td>
					<td><%=b.getLitros()%></td>
					
					<td><a href="editBebida?id=<%=b.getId()%>">editar</a></td>
					<td><a href="DeleteBebida?id=<%=b.getId()%>">borrar</a></td>
				</tr>
				
			<%} %>
			</tbody>
		</table>
		</div>
	</div>

		
		<a href="nuevaBebida.html">Nueva bebida</a>
	</div>

</body>
</html>