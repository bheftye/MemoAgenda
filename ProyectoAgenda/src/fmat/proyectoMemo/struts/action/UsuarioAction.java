package fmat.proyectoMemo.struts.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import fmat.proyectoMemo.struts.dao.DAOUsuario;
import fmat.proyectoMemo.struts.model.Usuario;


public class UsuarioAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> mapSession;
	private String alias;
	private String contrasena;
	private String nombre;
	private String contrasenaConfirmacion;
	private String correo;
	
	/**
	 * Agregar la clase services para que el usuario sea null
	 * @return
	 * @throws Exception
	 */
	
	public String iniciarSesion() throws Exception {
		Usuario usuario = null;
		DAOUsuario dao = new DAOUsuario();
		String texto = "Nombre de usuario o contrase&ntilde;a incorrectos";
		/**
		 * Coloca el usuario al nivel de la sesi�n
		 */
		if(alias != "" && contrasena != ""){
			usuario = dao.obtenerUsuarioPorCredenciales(alias, contrasena);
			texto = "Favor de llenar todos los campos";
		}
		if( usuario != null){
			mapSession.put("usuario", usuario);
			return "portal";
		}else{
			addActionError(texto);
			return "login";
		}
	}
	
	public String registrarUsuario() throws Exception{
		Usuario nuevoUsuario = null;
		DAOUsuario dao = new DAOUsuario();
		String texto = "Registro exitoso, inicia sesión";
		boolean camposLlenos = alias != "" && nombre != "" && contrasena != "" && contrasenaConfirmacion != "" && correo != "";
		if(camposLlenos){
			System.out.println(contrasena);
			System.out.println(contrasenaConfirmacion);
			System.out.println(alias);
			System.out.println(correo);
			System.out.println(nombre);
			
			if(contrasena.equals(contrasenaConfirmacion)){
				nuevoUsuario = new Usuario();
				boolean insercionExitosa = dao.insertarUsuario(nuevoUsuario);
				if(!insercionExitosa){
					texto = "Registro fallido, intentalo de nuevo";
				}
			}
			else{
				texto = "Las contraseñas no coinciden";
			}
		}
		else{
			texto = "Llena todos los campos para continuar el registro";
		}
		addActionError(texto);
		return "login";
	}
	
	public String cerrarSesion() throws Exception{
		mapSession.remove("usuario");
		System.out.println("CERRAR SESI�N");
		return "index";
	}
	
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasenaConfirmacion() {
		return contrasenaConfirmacion;
	}

	public void setContrasenaConfirmacion(String contrasenaConfirmacion) {
		this.contrasenaConfirmacion = contrasenaConfirmacion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public void setSession(Map<String, Object> mapSession) {
		// TODO Auto-generated method stub
		this.mapSession = mapSession;
	}
}
