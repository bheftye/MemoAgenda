package fmat.proyectoMemo.struts.dao;

import java.sql.SQLException;
import java.sql.Statement;

import fmat.proyectoMemo.struts.model.Grupo;

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
	
}
