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

<title>Información usuario</title>
</head>
<body>

	<div class="container">
	
		<%@ include file="cabecera.jsp"%>  
		
		
		<%Usuario user = (Usuario) request.getSession().getAttribute("usuario");%>
		
		
		    <div class="row bg-light">
		        <div class="col-xl-6 d-flex justify-content-center align-items-center">
                    <p>¿Qué quieres editar?</p>
                </div>
		        <div class="col-xl-3 d-flex justify-content-center align-items-center">
		            <a href="<%=request.getContextPath()%>/?edit=campos">Editar campos</a>
		        </div >
		        <div class="col-xl-3 d-flex justify-content-center align-items-center">
		            <a href="<%=request.getContextPath()%>/?edit=pass">Editar contraseña</a>
		        </div>
		    </div>
		
		     <% String confirmacion = (String) request.getSession().getAttribute("confirmar");
		     if (confirmacion != null){
		    	 %> 
		    	 <div><%=confirmacion%></div>
		    	 <%
		     } %>
		     
		     <div class="row mx-auto">

			     <form class="row mx-auto justify-content-center align-items-center" action="<%=request.getContextPath()%>/" method="post">
		            <div class="col-xl-6 justify-content-center align-items-center">
	                    <label class="form-label">Nombre</label>
	                    <input class="form-control" type="text" required name="nombre" placeholder="Nombre" value="<%=user.getNombre()%>" disabled><br>
                    </div>
			        <div class="col-xl-6 justify-content-center align-items-center">
	                    <label class="form-label">Apellido</label>
	                    <input class="form-control" type="text" required name="apellido" placeholder="Apellido" value="<%=user.getApellidos()%>" disabled><br>
                    </div>
                    <div class="col-xl-6 justify-content-center align-items-center">
				        <label class="form-label">email</label>
                        <input class="form-control" type="email" required name="email" placeholder="email" value="<%=user.getEmail()%>" disabled><br>
                    </div>
			        <div class="col-xl-6 justify-content-center align-items-center">
	                    <label class="form-label">Teléfono</label>
                        <input class="form-control" type="number" required name="telefono" placeholder="Telefono" value="<%=user.getTelefono()%>" disabled><br>
                    </div>
			     </form>
		     </div>
		
		<%@ include file="pie.jsp"%>   
	
	</div>
      
</body>
</html>
