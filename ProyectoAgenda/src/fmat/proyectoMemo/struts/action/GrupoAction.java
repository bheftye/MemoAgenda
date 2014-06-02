package fmat.proyectoMemo.struts.action;

import com.opensymphony.xwork2.ActionSupport;

import fmat.proyectoMemo.struts.dao.DAOGrupo;
import fmat.proyectoMemo.struts.model.Grupo;

public class GrupoAction  extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private Grupo grupo;
	
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
	
	
}	
