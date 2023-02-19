package dam2.dii.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dam2.dii.model.Usuario;
import dam2.dii.service.UsuariosService;


/**
 * Servlet implementation class Form
 */
@WebServlet("/")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String vista = request.getParameter("view");
		String cerrarSesion = request.getParameter("sesion");
		String edit = request.getParameter("edit");
		String buscador = request.getParameter("buscador");
		String id = request.getParameter("id");
		String eliminar = request.getParameter("eliminar");
		
		
		if (vista != null && vista.equals("login")) { //Si pinchan en login en la pantalla principal
			request.getRequestDispatcher("/views/login.jsp").forward(request, response);
		}
		
		else if (vista != null && vista.equals("form")) { //Si pinchan en form en la pantalla principal
			request.getRequestDispatcher("/views/form.jsp").forward(request, response);
		}
		
		
		else if (cerrarSesion != null && cerrarSesion.equals("close")) { //Si pinchan en cualquier momento cerrar Sesion
			
			request.getSession().setAttribute("nombre", null);
			request.getSession().setAttribute("usuario", null);
			request.getSession().setAttribute("usuarios", null);
			request.getSession().setAttribute("confirmar", null);
			request.getSession().setAttribute("error", null);
			request.getSession().setAttribute("buscador", null);
			request.getSession().setAttribute("id", null);
			request.getRequestDispatcher("/views/home.jsp").forward(request, response);
			
			
		}
		
		else if (cerrarSesion != null && cerrarSesion.equals("edit")) { //Si pinchan en el nombre 
			
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
			request.getSession().setAttribute("nombre", usuario.getNombre());
			request.getSession().setAttribute("usuario", usuario);
			request.getSession().setAttribute("error", null);
			response.sendRedirect(request.getContextPath() + "/views/edit.jsp");
			
		}
		
		else if (edit != null) { //Si pinchan en editar campos o Pass
						
			if (edit.equals("campos")) {
				Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
				request.getSession().setAttribute("nombre", usuario.getNombre());
				request.getSession().setAttribute("usuario", usuario);
				request.getSession().setAttribute("confirmar", null);
				request.getSession().setAttribute("error", null);
				response.sendRedirect(request.getContextPath() + "/views/editcampos.jsp");
			}
			
			else if (edit.equals("campos") && id != null) {
				
				
				Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
				request.getSession().setAttribute("nombre", usuario.getNombre());
				request.getSession().setAttribute("usuario", usuario);
				request.getSession().setAttribute("error", null);
				response.sendRedirect(request.getContextPath() + "/views/editcampos.jsp");
				
			}
			
			else if (edit.equals("camposad") && id != null) {
				int idInt = Integer.parseInt(id);
				Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
				Usuario usuarioEditar = UsuariosService.devolverUsuarioId(idInt);
				request.getSession().setAttribute("nombre", usuario.getNombre());
				request.getSession().setAttribute("usuarioEditar", usuarioEditar);
				request.getSession().setAttribute("usuario", usuario);
				request.getSession().setAttribute("error", null);
				response.sendRedirect(request.getContextPath() + "/views/editcamposad.jsp");
				
				
				
			}
			
			else if (edit.equals("eliminar") && id != null) {
				//int idInt = Integer.parseInt(id);
				Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
				request.getSession().setAttribute("nombre", usuario.getNombre());
				request.getSession().setAttribute("usuario", usuario);
				request.getSession().setAttribute("id", id);
				response.sendRedirect(request.getContextPath() + "/views/home.jsp");
				
			}
			
			else {
				Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
				request.getSession().setAttribute("nombre", usuario.getNombre());
				request.getSession().setAttribute("usuario", usuario);
				request.getSession().setAttribute("error", null);
				response.sendRedirect(request.getContextPath() + "/views/editpass.jsp");
			}
			
		}
		
		else if (buscador != null) {
			
			ArrayList<Usuario> usuariosBuscados = UsuariosService.buscarUsuarios(buscador);
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
			request.getSession().setAttribute("nombre", usuario.getNombre());
			request.getSession().setAttribute("usuario", usuario);
			request.getSession().setAttribute("buscador", usuariosBuscados);
			request.getSession().setAttribute("id", null);
			response.sendRedirect(request.getContextPath() + "/views/home.jsp");
			
		}
		
		else if (eliminar != null) {
			
			if (eliminar.equals("no")) {
				
				Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
				request.getSession().setAttribute("nombre", usuario.getNombre());
				request.getSession().setAttribute("usuario", usuario);
				request.getSession().setAttribute("id", null);
				response.sendRedirect(request.getContextPath() + "/views/home.jsp");
				
			}
			
			else {
				int idInt = Integer.parseInt(id);
				UsuariosService.eliminarUsuario(idInt);
				ArrayList<Usuario> listaUsuarios = UsuariosService.devolverUsuarios();
				request.getSession().setAttribute("usuarios", listaUsuarios);
				request.getSession().setAttribute("buscador", null);
				request.getSession().setAttribute("id", null);
				response.sendRedirect(request.getContextPath() + "/views/home.jsp");
				
			}
			
		}
				
		else {
			request.getRequestDispatcher("/views/home.jsp").forward(request, response);
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Parametros vista LOGIN
		String usuarioLogin = request.getParameter("user"); //Parametro user del Login
		String passLogin = request.getParameter("passLogin"); //Parámetro pass del Login
		
		//Parametros vista FORM
		String valor_nombre = request.getParameter("nombre");
		String valor_apellido = request.getParameter("apellido");
		String valor_pass = request.getParameter("pass1");
		String valor_pass2 = request.getParameter("pass2");
		String valor_email = request.getParameter("email");
		String valor_telefono = request.getParameter("telefono");
		
		//Parametros vista EDITCAMPOS
		String nombreEdit = request.getParameter("nombreEdit");
		String apellidoEdit = request.getParameter("apellidoEdit");
		String emailEdit = request.getParameter("emailEdit");
		String telefonoEdit = request.getParameter("telefonoEdit");
		String id = request.getParameter("id");
		String editAdmin = request.getParameter("editAdmin");
		
		//Parametros vista EDITPASS
		String passActual = request.getParameter("passActual");
		String passNueva1 = request.getParameter("nuevaPass1");
		String passNueva2 = request.getParameter("nuevaPass2");
		//String id = request.getParameter("id"); También se usa este parámetro en edición de contraseña
		
		//Si viene del Login pueden pasar tres cosas -> Acceso correcto, el correo no existe o la contraseña es incorrecta
		if (usuarioLogin != null && passLogin != null) {
			
			//Si los datos de acceso son correctos te manda a la vista 
			if (UsuariosService.existeCorreo(usuarioLogin) && UsuariosService.comprobarDatosAcceso(usuarioLogin, passLogin)) {
				
				Usuario usuario = UsuariosService.devolverUsuario(usuarioLogin);
				request.getSession().setAttribute("nombre", usuario.getNombre());
				request.getSession().setAttribute("usuario", usuario);
				request.getSession().setAttribute("id", null);
				if (usuario.isAdministrador()) {
					ArrayList<Usuario> listaUsuarios = UsuariosService.devolverUsuarios();
					request.getSession().setAttribute("usuarios", listaUsuarios);
				}
				response.sendRedirect(request.getContextPath() + "/views/home.jsp");
				//request.getRequestDispatcher("/saludo.jsp").forward(request, response);				
				
			}
			// Si no existe el correo electrónico te manda al formulario
			else if ((UsuariosService.existeCorreo(usuarioLogin) == false)) {
				
				request.getRequestDispatcher("/views/form.jsp").forward(request, response);	
			}
			//Si no te manda a la vista y te da el mensaje de error en la contrasena
			else {
				
				String mensajeContrasenaIncorrecta = "La contraseña es incorrecta";
				request.setAttribute("mensajeContrasenaIncorrecta", mensajeContrasenaIncorrecta);
				request.getRequestDispatcher("/views/login.jsp").forward(request, response);

			}
			
		}
	
		//Si viene del formulario se comprueba en primer lugar si el mail existe, en segundo lugar si las contraseñas son iguales.
		if (valor_email != null) {
			
			int telefono = Integer.parseInt(valor_telefono);
			if (UsuariosService.existeCorreo(valor_email)){ //Si el correo existe manda mensaje de error
				request.setAttribute("mensajeCorreoExiste", "Ese correo electrónico ya está en uso");
				request.getRequestDispatcher("/views/form.jsp").forward(request, response);
			}
			else if (UsuariosService.comprobarPass(valor_pass, valor_pass2)) { //si el correo no existe y las contraseñas son iguales te manda a inicio
				
				Usuario nuevoUsuario = new Usuario (valor_nombre,valor_apellido,valor_email,telefono,valor_pass,valor_pass2);
				UsuariosService.anadirUsuario(nuevoUsuario);
				Usuario UsuarioEnvio = UsuariosService.devolverUsuario(nuevoUsuario.getEmail());
				String nombreUsuario = nuevoUsuario.getNombre();
				request.getSession().setAttribute("nombre", nombreUsuario);
				request.getSession().setAttribute("usuario", UsuarioEnvio);
				request.getSession().setAttribute("id", null);
				response.sendRedirect(request.getContextPath() + "/views/home.jsp");
				//request.getRequestDispatcher("/saludo.jsp").forward(request, response);	
				
			}
			
			else { // si el correo no existe y las contraseñas son diferentes manda el mensaje de error en contraseña
				request.setAttribute("mensajeContrasenaIncorrecta", "Las contraseñas son diferentes");
				request.getRequestDispatcher("/views/form.jsp").forward(request, response);
			}
			
		}
		
		//TODO EDITAR CAMPOS Y EDITAR PASS
		//Si el campo id no es nulo hay dos opciones que se quiera editar campos o editar contraseña
		if (id != null) {
			Usuario usuarioSesion = (Usuario) request.getSession().getAttribute("usuario");
			int idInt = Integer.parseInt(id);
			Usuario usuarioEdicion = UsuariosService.devolverUsuarioId(idInt);
			//Si viene el nombre edit, es que quieren editar campos
			if (nombreEdit != null && editAdmin == null) {
				//Si el correo es diferente al actual y existe otro igual manda error		
				if (!(usuarioSesion.getEmail().equals(emailEdit)) && UsuariosService.existeCorreo(emailEdit)) { 
					request.getSession().setAttribute("nombre", usuarioSesion.getNombre());
					request.getSession().setAttribute("usuario", usuarioSesion);
					request.getSession().setAttribute("error", "Ese correo ya está en uso");
					response.sendRedirect(request.getContextPath() + "/views/editcampos.jsp");
				}
				else { //Si no actualiza los datos del usuario
					int telefonoEditpush = Integer.parseInt(telefonoEdit);
					usuarioSesion.setNombre(nombreEdit);
					usuarioSesion.setApellidos(apellidoEdit);
					usuarioSesion.setEmail(emailEdit);
					usuarioSesion.setTelefono(telefonoEditpush);
					UsuariosService.actualizarUsuario(usuarioSesion.getId(), usuarioSesion);
					request.getSession().setAttribute("nombre", usuarioSesion.getNombre());
					request.getSession().setAttribute("usuario", usuarioSesion);
					request.getSession().setAttribute("error", null);
					request.getSession().setAttribute("confirmar", "El usuario ha sido actualizado");
					response.sendRedirect(request.getContextPath() + "/views/edit.jsp");
					
				}
						
						
			}
			//Si viene contraseña es que quieren editar contraseña
			else if (passActual != null) {
				//Si la contraseña actual y las contraseñas que mandan son iguales se actualiza contraseña
				if (UsuariosService.comprobarPass(usuarioSesion.getId(), passActual) && UsuariosService.comprobarPass(passNueva1, passNueva2)) {
					usuarioSesion.setPass(passNueva1);
					usuarioSesion.setPass2(passNueva2);
					UsuariosService.actualizarUsuario(usuarioSesion.getId(), usuarioSesion);
					request.getSession().setAttribute("nombre", usuarioSesion.getNombre());
					request.getSession().setAttribute("usuario", usuarioSesion);
					request.getSession().setAttribute("error", null);
					request.getSession().setAttribute("confirmar", "La contraseña ha sido actualizada");
					response.sendRedirect(request.getContextPath() + "/views/edit.jsp");
				}
				//Si la contraseña actual es diferente manda mensaje de error				
				else if (!(UsuariosService.comprobarPass(usuarioSesion.getId(), passActual))){
					request.getSession().setAttribute("nombre", usuarioSesion.getNombre());
					request.getSession().setAttribute("usuario", usuarioSesion);
					request.getSession().setAttribute("confirmar", null);
					request.getSession().setAttribute("error", "La contraseña actual no coincide");
					response.sendRedirect(request.getContextPath() + "/views/editpass.jsp");
				}
				else { //Si las contraseñas nuevas son diferentes manda error
					request.getSession().setAttribute("nombre", usuarioSesion.getNombre());
					request.getSession().setAttribute("usuario", usuarioSesion);
					request.getSession().setAttribute("confirmar", null);
					request.getSession().setAttribute("error", "Las contraseñas nuevas no coinciden");
					response.sendRedirect(request.getContextPath() + "/views/editpass.jsp");
				}
			}
			
			else if (editAdmin != null) {
				
				if (!(usuarioEdicion.getEmail().equals(emailEdit)) && UsuariosService.existeCorreo(emailEdit)) { 
					request.getSession().setAttribute("nombre", usuarioSesion.getNombre());
					request.getSession().setAttribute("usuario", usuarioEdicion);
					request.getSession().setAttribute("error", "Ese correo ya está en uso");
					response.sendRedirect(request.getContextPath() + "/views/editcamposad.jsp");
				}
				else { //Si no, actualiza los datos del usuario
					int telefonoEditpush = Integer.parseInt(telefonoEdit);
					usuarioEdicion.setNombre(nombreEdit);
					usuarioEdicion.setApellidos(apellidoEdit);
					usuarioEdicion.setEmail(emailEdit);
					usuarioEdicion.setTelefono(telefonoEditpush);
					UsuariosService.actualizarUsuario(usuarioEdicion.getId(), usuarioEdicion);
					request.getSession().setAttribute("nombre", usuarioSesion.getNombre());
					request.getSession().setAttribute("usuario", usuarioSesion);
					request.getSession().setAttribute("error", null);
					request.getSession().setAttribute("id", null);
					request.getSession().setAttribute("confirmar", "El usuario ha sido actualizado");
					response.sendRedirect(request.getContextPath() + "/views/home.jsp");
					
				}
				
				
			}
			
		}
		
		
	}

}
