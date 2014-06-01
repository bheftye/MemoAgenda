package fmat.proyectoMemo.struts.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fmat.proyectoMemo.struts.model.Usuario;

public class DAOUsuario extends DAOBase {

	public DAOUsuario() {
		super();
	}

	/*
	 * public void addSeat(Seat seat) { Statement statement; try { String
	 * insertStatement = "INSERT INTO " + SEATS_TABLE_NAME +
	 * " (id_asientos,ocupado) VALUES ('" + seat.getId_seat() + "'," +
	 * seat.getIsTaken() + ")"; statement = connection.createStatement();
	 * statement.executeUpdate(insertStatement); } catch (SQLException ex) {
	 * ex.printStackTrace(); } }
	 */

	public boolean insertarUsuario(Usuario nuevoUsuario) {
		boolean oprExitosa = false;
		String sql = "INSERT INTO `usuarios`("
				+ "`nombre`, `alias`, `correo`, `contrasena`,`foto`) "
				+ "VALUES (\"" + nuevoUsuario.getNombre() + "\",\""
				+ nuevoUsuario.getAlias() + "\",\"" + nuevoUsuario.getCorreo()
				+ "\"," + "MD5(\"" + nuevoUsuario.getContrasena() + "\"),\""+nuevoUsuario.getAlias()+".jpg\")";
		try {
			Statement statement = connection.createStatement();
			int idUsuario = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			nuevoUsuario.setIdUsuario(idUsuario);
			if(idUsuario != 0){
				oprExitosa = true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return oprExitosa;
	}

	/*
	 * public Seat getSeat(String id) { Seat resultSeat = null; try { String
	 * query = "SELECT * FROM " + SEATS_TABLE_NAME + " WHERE id_asientos = '" +
	 * id + "'"; Statement statement = connection.createStatement(); ResultSet
	 * results = statement.executeQuery(query); while (results.next()) {
	 * resultSeat = new Seat(results.getString("id_asientos"),
	 * results.getInt("ocupado")); } } catch (SQLException ex) {
	 * ex.printStackTrace(); } return resultSeat; }
	 */

	public Usuario obtenerUsuarioPorId(int idUsuario) {
		Usuario usuario = null;
		String sql = "SELECT * FROM `usuarios` WHERE `id_usuario` = "
				+ idUsuario;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultados = statement.executeQuery(sql);
			while (resultados.next()) {
				usuario = new Usuario(resultados.getInt("id_usuario"),resultados.getString("alias"), resultados.getString("contrasena"),resultados.getString("nombre"),resultados.getString("correo"),resultados.getString("foto"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return usuario;
	}
	
	public Usuario obtenerUsuarioPorCredenciales(String alias, String contrasena){
		Usuario usuario = null;
		String sql = "SELECT * FROM `usuarios` WHERE `alias` = \""
				+ alias + "\" and `contrasena` = MD5(\""+contrasena+"\")";
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultados = statement.executeQuery(sql);
			while (resultados.next()) {
				usuario = new Usuario(resultados.getInt("id_usuario"),resultados.getString("alias"), resultados.getString("contrasena"),resultados.getString("nombre"),resultados.getString("correo"),resultados.getString("foto"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return usuario;
	}
}
