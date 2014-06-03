package fmat.proyectoMemo.struts.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import fmat.proyectoMemo.struts.dao.DAOGrupo;
import fmat.proyectoMemo.struts.model.Grupo;
import fmat.proyectoMemo.struts.model.Usuario;

public class GrupoAction  extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 1L;
	private Grupo grupo;
	private Map<String, Object> mapSession;
	private Usuario usuario;
	
	public String crearGrupo(){
		String texto = "No se realizó la operación, intentalo de nuevo";
		if(!grupo.getNombre().equals("")){
			DAOGrupo dao = new DAOGrupo();
			boolean insercionExitosa = dao.insetarGrupo(grupo);
			if(insercionExitosa){
				return "editGroup";
			}
		}
		addActionError(texto);
		return "createGroup";
	}
	
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	@Override
	public void setSession(Map<String, Object> mapSession) {
		// TODO Auto-generated method stub
		this.mapSession = mapSession;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}
}	
