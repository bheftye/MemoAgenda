package fmat.proyectoMemo.struts.dao;

import java.sql.PreparedStatement;
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
	
	public boolean aliasDisponible(String alias){
		boolean aliasDisponible = true;
		String aliasUsado = "";
		String sqlBusqueda = "SELECT alias FROM usuarios where alias = '"+alias+"'";
		try{
			Statement statement = connection.createStatement();
			ResultSet resultados = statement.executeQuery(sqlBusqueda);
			while(resultados.next()){
				aliasUsado = resultados.getString("alias");
				if(alias.equals(aliasUsado)){
					aliasDisponible = false;
					break;
				}
			}
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		
		return aliasDisponible;
	}
	
	public boolean modificarContrasena(Usuario usuario, Usuario sesion){
		boolean oprExitosa = false;
		String sqlContrasena = "UPDATE usuarios SET contrasena = MD5(?) WHERE id_usuario = ?";
		PreparedStatement sContrasena = null;
		
		try{
			connection.setAutoCommit(false);
			if(!usuario.getContrasena().equals(sesion.getContrasena())){
				sContrasena = connection.prepareStatement(sqlContrasena);
				sContrasena.setString(1, usuario.getContrasena());
				sContrasena.setInt(2, sesion.getIdUsuario());
				sContrasena.executeUpdate();
			}
			
			connection.commit();
			connection.setAutoCommit(true);
			oprExitosa = true;
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return oprExitosa;
	}
	
	public boolean modificarInformacionUsuario(Usuario usuario, Usuario sesion){
		boolean oprExitosa = false;
		String sqlNombre = "UPDATE usuarios SET nombre = ? WHERE id_usuario = ?";
		String sqlAlias = "UPDATE usuarios SET alias = ? WHERE id_usuario = ?";
		String sqlCorreo = "UPDATE usuarios SET correo = ? WHERE id_usuario = ?";
		PreparedStatement sNombre = null;
		PreparedStatement sAlias = null;
		PreparedStatement sCorreo = null;
		try{
			connection.setAutoCommit(false);
			if(!usuario.getNombre().equals(sesion.getNombre())){
				sNombre = connection.prepareStatement(sqlNombre);
				sNombre.setString(1, usuario.getNombre());
				sNombre.setInt(2, sesion.getIdUsuario());
				sNombre.executeUpdate();
			}
			
			if(!usuario.getAlias().equals(sesion.getAlias())){
				sAlias = connection.prepareStatement(sqlAlias);
				sAlias.setString(1, usuario.getAlias());
				sAlias.setInt(2, sesion.getIdUsuario());
				sAlias.executeUpdate();
			}
			
			if(!usuario.getCorreo().equals(sesion.getCorreo())){
				sCorreo = connection.prepareStatement(sqlCorreo);
				sCorreo.setString(1, usuario.getCorreo());
				sCorreo.setInt(2, sesion.getIdUsuario());
			}
			connection.commit();
			connection.setAutoCommit(true);
			oprExitosa = true;
		}catch(SQLException ex){
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
