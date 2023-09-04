<%@page import="entities.Bebida"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style/reset.css">
    <link rel="stylesheet" href="style/header.css">
    <link rel="stylesheet" href="style/altaBebida.css">
    <title>Foodtruck</title>
    
    <% Bebida be1 = (Bebida) request.getAttribute("be1");%>
    
</head>
<body>
 <jsp:include page="header.jsp"/>
 
	<div class="form">
        <form action="editbebida?id=<%=be1.getId()%>" method="post">
            <div class="form__container">
                <h1>Editar Bebida</h1>
 
 				 <div class="form__item">
                    <label>Nombre</label>
                    <input name="nombre" value="<%=be1.getNombre() %>">
                </div>
 
                <div class="form__item">
                    <label>Precio</label>
                    <input name="precio" value=<%= be1.getPrecio() %>>
                </div>
                 
                 <div class="form__item">
                    <label>Litros</label>
                    <input name="litros" value=<%=be1.getLitros() %>>
                </div>
               
                 <button class="button" type="submit">Editar</button>
               </div>
        </form>
        
    </div>
    
</body>
</html>