package fmat.proyectoMemo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
<<<<<<< HEAD
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
=======
>>>>>>> c4b63c7661766b1835f2b4337ed01659454a01dc

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

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
		String[] repeticion = request.getParameterValues("repeticion");
		
		String hasta_fecha= request.getParameter("hasta_fecha");

		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		 Date fecha_inicial = null, fecha_finali = null, hasta_fechaa = null;
		 try {

		     fecha_inicial = (Date) formatoDelTexto.parse(fecha_inicio);
		     fecha_finali = (Date) formatoDelTexto.parse(fecha_final);
		     hasta_fechaa = (Date) formatoDelTexto.parse(hasta_fecha);
		 } catch (ParseException | java.text.ParseException ex) {
		     ex.printStackTrace();
		 }


		/*	for(int i = 0; i<recordatorio.length; i++){
		//	printWriter.print(recordatorio[i]+ ","+ "<br/>");			
		}*/


		if(nombre.isEmpty() || ubicacion.isEmpty() || fecha_inicio.isEmpty() || fecha_final.isEmpty() || hora_inicio.isEmpty()
				|| hora_final.isEmpty()){
			request.setAttribute("errorMessage", "Quedaron campos obligatorios vac�os... <br /><br />");
			request.getRequestDispatcher("addevent.jsp").forward(request, response);
		}else{
			String repeticion_str = repeticion[0];
			switch(repeticion_str){
			case "0": 
				System.out.println("Repeticion: Ninguno");				
				break;
			case "1": 
				System.out.println("Repeticion: Diario");				
				break;
			case "2": 
				System.out.println("Repeticion: Semanal");				
				break;
			case "3": 
				System.out.println("Repeticion: Mensual");				
				break;
			case "4": 
				System.out.println("Repeticion: Anual");				
				break;				
			}
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
