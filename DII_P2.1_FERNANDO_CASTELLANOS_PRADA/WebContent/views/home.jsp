<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
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

<title></title>
</head>
<body>
    <div class="container">

        <%@ include file="cabecera.jsp"%>   

        <%ArrayList<Usuario> listaUsuarios =  (ArrayList<Usuario>) request.getSession().getAttribute("usuarios");
        
        if(listaUsuarios != null){
        	%>
        	<div>
	            <table class="table">
	                <thead>
	                    <tr>
	                        <th scope="col">id</th>
		                    <th scope="col">Nombre</th>
		                    <th scope="col">Apellidos</th>
		                    <th scope="col">email</th>
		                    <th scope="col">Acciones</th>
	                    </tr>
	                </thead>
	                <tbody>
            <%
        	for (int i = 0; i<listaUsuarios.size();i++){
        		
        		   Usuario auxiliar = listaUsuarios.get(i);
        	%>
        	           <tr>
        	               <td scope="row"><%=auxiliar.getId()%></td> 
        	               <td scope="row"><%=auxiliar.getNombre()%></td>    
        	               <td scope="row"><%=auxiliar.getApellidos()%></td> 
        	               <td scope="row"><%=auxiliar.getEmail()%></td>
        	               <td scope="row">
        	              <a href="<%=request.getContextPath()%>/?edit=camposad&id=<%=auxiliar.getId()%>">
                                <button class="btn-warning">Editar</button>
                           </a>
                           <a href="<%=request.getContextPath()%>/?edit=eliminar&id=<%=auxiliar.getId()%>">
                                <button class="btn-danger">Eliminar</button>
                           </a>
                           <% 
                           String idUsuario = (String) request.getSession().getAttribute("id");
                           
                           if (idUsuario != null){
                        	   
                        	   int idUsuarioInt = Integer.parseInt(idUsuario);
                        	   
                        	   if (auxiliar.getId() == idUsuarioInt){
                        		   
                        		   
                        		   
                        	
                               
                               %>
                            
                              
                                    <label class="form-label">Estás seguro de eliminar al usuario</label>
                                    <a href="<%=request.getContextPath()%>/?eliminar=si&id=<%=auxiliar.getId()%>">
                                      <button class="btn-success">Sí</button>
                                    </a>
                                    <a href="<%=request.getContextPath()%>/?eliminar=no">
                                        <button class="btn-light">No</button>
                                    </a>
                                
                            
                               <%
                               
                               
                               
                               }
                     	   }  
                           %>
                           </td>      	           
        	           </tr>

        	<%
        	}
            %>
	                </tbody>
	            </table>
            
            </div><br>
            <div class="row">
                 <form class="row justify-content-center align-items-center" action="<%=request.getContextPath()%>/" method="get">
                     <div class="col-xl-8 justify-content-center align-items-center">
                        <label class="form-label">Buscador</label>
                        <input class="form-control" type="text" required name="buscador" placeholder="Introduce texto" value=""><br>
                     </div>
                     <div class="col-xl-4 justify-content-center align-items-center">
                        <input class="btn-success" type="submit" name="boton" value="Buscar usuario">
                     </div>
                  </form>
             </div>
            <%
            
            
            
        }
        
        ArrayList<Usuario> usuariosBuscados =  (ArrayList<Usuario>) request.getSession().getAttribute("buscador");
        
        if (usuariosBuscados != null){
            %>
            <div>
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">id</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Apellidos</th>
                            <th scope="col">mail</th>
                            <th scope="col">Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
            <%
            for (int i = 0; i<usuariosBuscados.size();i++){
                
                   Usuario auxiliar = usuariosBuscados.get(i);
            %>
                       <tr>
                           <td scope="row"><%=auxiliar.getId()%></td> 
                           <td scope="row"><%=auxiliar.getNombre()%></td>    
                           <td scope="row"><%=auxiliar.getApellidos()%></td> 
                           <td scope="row"><%=auxiliar.getEmail()%></td>
                           <td scope="row">
                           <a href="<%=request.getContextPath()%>/?edit=camposad&id=<%=auxiliar.getId()%>">
                                <button class="btn-warning">Editar</button>
                           </a>
                           <a href="<%=request.getContextPath()%>/?edit=eliminar&id=<%=auxiliar.getId()%>">
                                <button class="btn-danger">Eliminar</button>
                           </a>
                           <% 
                           String idUsuario = (String) request.getSession().getAttribute("id");
                           
                           if (idUsuario != null){
                               
                               int idUsuarioInt = Integer.parseInt(idUsuario);
                               
                               if (auxiliar.getId() == idUsuarioInt){
                                   
                                   
                                   
                            
                               
                               %>
                            
                              
                                     <label class="form-label">Estás seguro de eliminar al usuario</label>
                                    <a href="<%=request.getContextPath()%>/?eliminar=si&id=<%=auxiliar.getId()%>">
                                      <button class="btn-success">Sí</button>
                                    </a>
                                    <a href="<%=request.getContextPath()%>/?eliminar=no">
                                        <button class="btn-light">No</button>
                                    </a>
                                
                            
                               <%
                               
                               
                               
                               }
                           }  
                           %>
                      
                           </td>                   
                       </tr>

            <%
            }
            %>
                    </tbody>
                </table>
            
            </div><br>
            <%} %>
            


        <%@ include file="pie.jsp"%>  
    </div> 
</body>
</html>
