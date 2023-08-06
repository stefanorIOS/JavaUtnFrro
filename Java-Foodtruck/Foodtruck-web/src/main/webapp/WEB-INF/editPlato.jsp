<%@page import="entities.Plato"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style/reset.css">
    <link rel="stylesheet" href="style/header.css">
    <link rel="stylesheet" href="style/altaEmpleado.css">
    <title>Foodtruck</title>
    
    <% Plato plato = (Plato) request.getAttribute("plato");%>
    
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
	<div class="form">
        <form action="editPlato?id=<%=plato.getId()%>" method="post">
            <div class="form__container">
                <h1>Editar Bebida Menu</h1>
                
                <div class="form__item">
                    <label>ID</label>
                    <input type="text" name="id"  maxlength="8" value=<%=plato.getId() %>>
                </div>
                 <div class="form__item">
                    <label>Nombre</label>
                    <input name="nombre">
                </div>
                 <div class="form__item">
                    <label>Receta</label>
                    <input name="receta">
                </div>
                
                <div class="form__item">
                    <label>Precio</label>
                    <input name="precio">
                </div>
                 <div class="form__item">
                    <label>Descripcion</label>
                    <input name="descripcion">
                </div>
               
                 <button class="button" type="submit">Editar</button>
               </div>
        </form>
        
    </div>
    
</body>
</html>