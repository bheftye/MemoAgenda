package fmat.proyectoMemo.struts.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import fmat.proyectoMemo.struts.model.Usuario;


public class UsuarioAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> mapSession;
	private String alias;
	private String contrasena;
	
	/**
	 * Agregar la clase services para que el usuario sea null
	 * @return
	 * @throws Exception
	 */
	
	public String iniciarSesion() throws Exception {
		Usuario usuario = new Usuario();

		String texto = "Nombre de usuario o contraseña incorrectos";
		/**
		 * Coloca el usuario al nivel de la sesión
		 */
		
		if(alias.equals("Maya") && contrasena.equals("123")){
			usuario.setAlias("Maya");
			usuario.setContrasena("123");
			
			mapSession.put("usuario", usuario);
			return "portal";
		}else{
			addActionError(texto);
			return "login";
		}
	}
	
	public String cerrarSesion() throws Exception{
		mapSession.remove("usuario");
		System.out.println("CERRAR SESIÓN");
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

	@Override
	public void setSession(Map<String, Object> mapSession) {
		// TODO Auto-generated method stub
		this.mapSession = mapSession;
	}
}
