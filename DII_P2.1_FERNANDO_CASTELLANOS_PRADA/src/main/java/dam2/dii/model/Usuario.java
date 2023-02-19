package dam2.dii.model;

public class Usuario {
	
	private int id;
	private String nombre;
	private String apellidos;
	private String email;
	private int telefono;
	private String pass;
	private String pass2;
	private boolean administrador;
	
	public Usuario() {
		
	}
	
	

	public Usuario(int id, String nombre, String apellidos, String email, int telefono, String pass, String pass2,
			boolean administrador) {

		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.telefono = telefono;
		this.pass = pass;
		this.pass2 = pass2;
		this.administrador = administrador;
	}

	

	public Usuario(String nombre, String apellidos, String email, int telefono, String pass, String pass2) {
		
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.telefono = telefono;
		this.pass = pass;
		this.pass2 = pass2;
	
	}



	public Usuario(String nombre, String apellidos, String email, int telefono, String pass, String pass2,
			boolean administrador) {

		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.telefono = telefono;
		this.pass = pass;
		this.pass2 = pass2;
		this.administrador = administrador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPass2() {
		return pass2;
	}

	public void setPass2(String pass2) {
		this.pass2 = pass2;
	}

	public boolean isAdministrador() {
		return administrador;
	}

	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}
	
	
	
	

}
