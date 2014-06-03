package fmat.proyectoMemo.struts.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fmat.proyectoMemo.struts.model.Grupo;
import fmat.proyectoMemo.struts.model.Usuario;

public class DAOGrupo extends DAOBase{
	
	public boolean insetarGrupo(Grupo grupo){
		boolean oprExitosa = false;
		String sql = "INSERT INTO `grupos`(`nombre`, `id_creador`, `status`) VALUES ('"+grupo.getNombre()+"',"+grupo.getIdUsuarioCreador()+",1)";
		try {
			Statement statement = connection.createStatement();
			int idGrupo = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			grupo.setIdGrupo(idGrupo);
			if(idGrupo != 0){
				oprExitosa = true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return oprExitosa;
	}
	
	public boolean insertarIntegranteEnGrupo(int idGrupo, int idUsuario){
		boolean oprExitosa = false;
		String sql = "INSERT INTO `integrantes`(`id_grupo`, `id_usuario`) VALUES ('"+idGrupo+"',"+idUsuario+")";
		try {
			Statement statement = connection.createStatement();
			int renglonesAfectados = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			if(renglonesAfectados != 0){
				oprExitosa = true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return oprExitosa;
	}
	
	public boolean esIntegrante(int idGrupo, int idUsuario){
		boolean esIntegrante = false;
		String sql = "SELECT * FROM `integrantes` WHERE id_grupo = "+idGrupo+" and id_usuario = "+idUsuario;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultados = statement.executeQuery(sql);
			int numRenglones = 0;
			while(resultados.next()){
				numRenglones++;
			}
			if(numRenglones > 0 ){
				esIntegrante = true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return esIntegrante;
	}
	
	public ArrayList<Usuario> obtenerIntegrantesDeGrupo(int idGrupo){
		ArrayList<Usuario> integrantes = new ArrayList<>();
		String sql  = "SELECT * FROM grupos LEFT JOIN integrantes ON grupos.id_grupo = integrantes.id_grupo WHERE grupos.id_grupo = "+idGrupo+" and  integrantes.id_grupo = "+idGrupo;
		return integrantes;
	}
	
	public Grupo obtenerGrupoPorId(int idGrupo){
		Grupo grupo = new Grupo();
		String sql = "SELECT * FROM";
		return grupo;
	}
	
}
