<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dam2.dii.model.Usuario"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.1.0.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<title>Cambio contraseña</title>
</head>
<body>

	<div class="container">
	
		<%@ include file="cabecera.jsp"%> 
		
		<%Usuario user = (Usuario) request.getSession().getAttribute("usuario");%>
		
		     <div class="row mx-auto">
			     <form class="row mx-auto justify-content-center align-items-center" action="<%=request.getContextPath()%>/" method="post">
			         <div class="col-xl-12 justify-content-center align-items-center">
                        <label class="form-label">Contraseña actual</label>
                        <input class="form-control" type="password" required name="passActual" placeholder="Contraseña actual" value=""><br>
                     </div>
			         <div class="col-xl-6 justify-content-center align-items-center">
                        <label class="form-label">Nueva contraseña</label>
                        <input class="form-control" type="password" required name="nuevaPass1" placeholder="Contraseña nueva" value=""><br>
                     </div>
			         <div class="col-xl-6 justify-content-center align-items-center">
                        <label class="form-label">Repita contraseña</label>
                        <input class="form-control" type="password" required name="nuevaPass2" placeholder="Repita contraseña" value=""><br>
                     </div>
			         
			         
			         <input class="barras" type="number" hidden=true name="id" value="<%=user.getId()%>"><br>
			         <div class="col-xl-3 justify-content-center align-items-center">
			         <input class="btn-success" type="submit" name="boton" value="Actualizar contraseña">
			         
			         <% String error = (String) request.getSession().getAttribute("error");
                     if (error != null){
                         %><p><%=error%></p><% 
                     }%>
                     </div>
			     </form>
		     </div>
		
		<%@ include file="pie.jsp"%>  
	
	</div> 
      
</body>
</html>
