package fmat.proyectoMemo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;

@WebServlet("/addEvent")
public class AddEventServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	
	public AddEventServlet() {

	}
	public void doIt(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		int id_creador = Integer.parseInt(request.getParameter("idUsuario"));
		String nombre = request.getParameter("nombre");
		String ubicacion = request.getParameter("ubicacion");
		String fecha_inicio = request.getParameter("fecha_inicio");
		String fecha_final = request.getParameter("fecha_final");
		String hora_inicio =  request.getParameter("hora_inicio");
		String hora_final =  request.getParameter("hora_final");
		String id_integrante = request.getParameter("id_integrante");
		String id_grupo= request.getParameter("id_grupo");
		
		System.out.println("Id creador:" + id_creador );
		System.out.println("Nombre del evento:" + nombre );
		System.out.println("Ubicacion:" + ubicacion );
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		doIt(request, response);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		doIt(request, response);
	}

}
