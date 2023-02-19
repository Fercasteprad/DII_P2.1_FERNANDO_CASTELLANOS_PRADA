 
    
     <%String usuario = (String) request.getSession().getAttribute("nombre");
     
     if (usuario != null){%>
    	 
    	  <div class="row bg-light">
	            <div class="col-xl-4 d-flex justify-content-center align-items-center">
	                <p>Hola, 
	                <a href="<%=request.getContextPath()%>/?sesion=edit"><%=usuario%></a></p>
	            </div>
	            <div class="col-xl-4 d-flex justify-content-center align-items-center">
                    <a href="<%=request.getContextPath()%>/views/home.jsp">Inicio</a>
                </div>
	            <div class="col-xl-4 d-flex justify-content-center align-items-center">
	                <a href="<%=request.getContextPath()%>/?sesion=close">Cerrar sesion</a>
	            </div>
                
          </div>
    	 
     <%} else {%>
    	 
    	   <div class="row bg-light">
	            <div class="col-xl-6 d-flex justify-content-center align-items-center">
	                <a href="<%=request.getContextPath()%>/?view=login">Login</a>
	            </div>
	            <div class="col-xl-6 d-flex justify-content-center align-items-center">
	                <a href="<%=request.getContextPath()%>/?view=form">Darse de alta</a>
	            </div>
           </div>
     <%}
     %>
    

