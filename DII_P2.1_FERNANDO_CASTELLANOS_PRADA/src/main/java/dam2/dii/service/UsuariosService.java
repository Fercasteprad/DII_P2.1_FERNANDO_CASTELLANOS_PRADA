package dam2.dii.service;

import java.util.ArrayList;

import dam2.dii.DAO.UsuarioDAO;
import dam2.dii.model.Usuario;


public class UsuariosService {
	
	public static ArrayList<Usuario> listarUsuarios(){
		
		ArrayList<Usuario> usuariosPrueba = UsuarioDAO.getListaUsuarios();
		
		return usuariosPrueba;
		
	}
	
	public static void anadirUsuario (Usuario nuevoUsuario) {
		
		UsuarioDAO.anadirContacto(nuevoUsuario);
		
	}
	
	public static boolean existeCorreo (String correoComprobar) {
		
		boolean existeCorreo = UsuarioDAO.comprobarCorreo(correoComprobar);
		return existeCorreo;
		
	}
	
	public static boolean comprobarDatosAcceso (String usuario, String pass) {
		
		boolean acceso = UsuarioDAO.comprobarDatosAcceso(usuario, pass);
		return acceso;
		
	}
	
	public static boolean comprobarPass (String pass1, String pass2) {
		
		boolean passIguales = false;
		
		if (pass1.equals(pass2)) {
			passIguales = true;
		}
		
		return passIguales;
		
	}
	
	public static Usuario devolverUsuario (String correo) {
		
		Usuario usuario = UsuarioDAO.devolverUsuario(correo);
		return usuario;
		
	}
	
	public static Usuario devolverUsuarioId (int idUsuario) {
		
		Usuario usuario = UsuarioDAO.devolverUsuarioId(idUsuario);
		return usuario;
		
	}
	
	public static void actualizarUsuario (int idUsuario, Usuario usuarioActualizado) {
		
		UsuarioDAO.actualizarUsuario(idUsuario, usuarioActualizado);
		
	}
	
	public static boolean comprobarPass (int idUsuario, String pass) {
		
		boolean comprobacionPass = UsuarioDAO.comprobarPass(idUsuario, pass);
		return comprobacionPass;
		
	}
	
	public static ArrayList<Usuario> devolverUsuarios (){
		
		ArrayList<Usuario> listaUsuarios = UsuarioDAO.devolverUsuarios();
		return listaUsuarios;
		
	}
	
	public static ArrayList<Usuario> buscarUsuarios (String texto){
		
		ArrayList<Usuario> listaUsuarios = UsuarioDAO.buscadorUsuarios(texto);
		return listaUsuarios;
		
	}
	
	public static void eliminarUsuario (int id) {
		
		UsuarioDAO.eliminarUsuario(id);
		
	}

}
