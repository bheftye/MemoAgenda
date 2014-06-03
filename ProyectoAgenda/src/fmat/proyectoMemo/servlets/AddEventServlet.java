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

		//Obteniendo el arreglo de integrantes
		String[] integrantes = request.getParameterValues("integrantes");
		String[] grupos = request.getParameterValues("grupos");

		//Obteniendo el arreglo de recordatorio
		String[] recordatorio = request.getParameterValues("frutas");

		//	printWriter.print("Tus frutas favoritas son: ");

		/*	for(int i = 0; i<recordatorio.length; i++){
		//	printWriter.print(recordatorio[i]+ ","+ "<br/>");			
		}

		for(int i = 0; i<integrantes.length; i++){
	//		printWriter.print(integrantes[i]+ ","+ "<br/>");			
		}*/

		if(nombre.isEmpty() || ubicacion.isEmpty() || fecha_inicio.isEmpty() || fecha_final.isEmpty() || hora_inicio.isEmpty()
				|| hora_final.isEmpty()){
			request.setAttribute("errorMessage", "Quedaron campos obligatorios vacíos... <br /><br />");
			request.getRequestDispatcher("addevent.jsp").forward(request, response);
		}


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
