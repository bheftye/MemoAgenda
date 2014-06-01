package fmat.proyectoMemo.struts.model;

public class Usuario {
	private int idUsuario;
	private String alias;
	private String contrasena;
	private String nombre;
	private String correo;
	private String foto;
	
	public Usuario(int idUsuario, String alias, String contrasena,
			String nombre, String correo, String foto) {
		super();
		this.idUsuario = idUsuario;
		this.alias = alias;
		this.contrasena = contrasena;
		this.nombre = nombre;
		this.correo = correo;
		this.foto = foto;
	}

	public Usuario(){}
	
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}

}
