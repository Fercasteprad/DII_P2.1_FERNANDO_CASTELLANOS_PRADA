<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.1.0.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<title>Formulario de acceso</title>
</head>
<body>
	
					<div class="container">
						<form class="row" action="<%=request.getContextPath()%>/" method="post">
						    <div class="col-md-6">
						    <label class="form-label">Nombre</label>
							<input class="form-control" type="text" required name="nombre" placeholder="Nombre" value=""><br>
							</div>
							<div class="col-md-6">
							<label class="form-label">Apellidos</label>
							<input class="form-control" type="text" required name="apellido" placeholder="Apellido" value=""><br>
							</div>
							<div class="col-md-6">
                            <label class="form-label">email</label>
							<input class="form-control" type="email" required name="email" placeholder="email" value=""><br>
							       <%
							       String mensajeError = (String) request.getAttribute("mensajeCorreoExiste");
							       if (mensajeError != null) {
          
                                        %><div><%=mensajeError%></div>
                                    <%
                                     }
							        %>
							</div>
							<div class="col-md-6">
                            <label class="form-label">Telefono</label>
							<input class="form-control" type="number" required name="telefono" placeholder="Telefono" value=""><br>
							</div>
							<div class="col-md-6">
                            <label class="form-label">Contraseña</label>
							<input class="form-control" type="password" required name="pass1" placeholder="Contraseña" value=""><br>
							</div>
							<div class="col-md-6">
                            <label class="form-label">Repite contraseña</label>
							<input class="form-control" type="password" required name="pass2" placeholder="Repita contraseña" value=""><br>
							       <%
                                   String mensajeError2 = (String) request.getAttribute("mensajeContrasenaIncorrecta");
                                   if (mensajeError2 != null) {
          
                                        %><div><%=mensajeError2%></div>
                                    <%
                                     }
                                    %>
                            </div>
                            <div class="justify-content-center">
							<input class="btn-success" type="submit" name="boton" value="Enviar formulario">
							</div>
						</form>
						<%@ include file="pie.jsp"%>  
					</div>

			
</body>
</html>