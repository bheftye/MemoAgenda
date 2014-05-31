<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MEMO | Agenda En Línea</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
<link rel="icon" type="image/png" href="images/favicon-memo.png">
</head>
<body>
	<div id="background-green">background</div>
	<div class="page">
		<div class="home-page">
			<div class="sidebar">
				<a href="index.html" id="logo"><img src="images/logo.png"
					alt="logo"></a>
				<ul>
					<li class="home"><a href="index.html">Inicio</a></li>
					<li class="about"><a href="about.html">Perfil</a></li>
					<li class="blog"><a href="blog.html">Agenda</a></li>
					<li class="projects"><a href="projects.html">Ajustes</a></li>
					<li class="contact"><a href="contact.html">Contacto</a></li>
				</ul>
				<div class="connect">
					<a href="#" id="fb">facebook</a> <a href="#" id="twitter">twitter</a>
				</div>
			</div>
			<div class="body">
				<div class="login">
					<a href="login.html" id="login">Iniciar sesión | Registrarse</a>
				</div>
				<div class="content-login">
					<div>
						<table>
							<tr>
								<td><h3>Iniciar sesión</h3>
									
									<!-- 
									<form action="login">
										 -->
										 
										<h4>Escribe tu alias y contrase&ntilde;a para iniciar
											sesi&oacute;n</h4>
										
											<s:actionerror />
											<s:form action="iniciarSesion">
											
											<s:textfield name="alias" value="Alias *"
											onBlur="this.value=!this.value?'Alias *':this.value;"
											onFocus="this.select()" 
											onClick="this.value='';" />
											
											<s:textfield name="contrasena"  value="Contraseña *"
											onBlur="this.value=!this.value?'Contrase&ntilde;a *':this.value;"
											onFocus="this.select()" 
											onClick="this.value='';" />
											
											<s:submit  class="submit" 
											value="Iniciar sesión" />
											</s:form>
										
										<!--  
										<input type="text" value="Nombre *"
											onBlur="this.value=!this.value?'Nombre *':this.value;"
											onFocus="this.select()" 
											onClick="this.value='';">
											 
									    <input
											type="text" value="Contrase&ntilde;a *"
											onBlur="this.value=!this.value?'Contrase&ntilde;a *':this.value;"
											onFocus="this.select()" onClick="this.value='';"> 
											
										<input 
											type="submit" class="submit" 
											value="Iniciar sesi&oacute;n">
										-->
										<p>
											<a href="#">¿Olvidaste tu contraseña?</a>
										</p>
										
									<!--  	
									</form>
									-->
									
									</td>
								
								<td class="linea"><h3 class="registro">Registro</h3>
									<form action="index.html">
										<h4>Escribe tu nombre, contrase&ntilde;a y correo
											electr&oacute;nico para registrarte.</h4>
										<input type="text" value="Nombre *"
											onBlur="this.value=!this.value?'Nombre *':this.value;"
											onFocus="this.select()" onClick="this.value='';"> <input
											type="text" value="Alias *"
											onBlur="this.value=!this.value?'Alias *':this.value;"
											onFocus="this.select()" onClick="this.value='';"> <input
											type="text" value="Correo electr&oacute;nico *"
											onBlur="this.value=!this.value?'Correo electr&oacute;nico *':this.value;"
											onFocus="this.select()" onClick="this.value='';"> <input
											type="text" value="Contrase&ntilde;a *"
											onBlur="this.value=!this.value?'Contrase&ntilde;a *':this.value;"
											onFocus="this.select()" onClick="this.value='';"> <input
											type="text" value="Confirmar contrase&ntilde;a *"
											onBlur="this.value=!this.value?'Contrase&ntilde;a *':this.value;"
											onFocus="this.select()" onClick="this.value='';"> <input
											type="submit" class="submit" value="Registrarse">
									</form></td>
							</tr>
						</table>
					</div>
				</div>
				<div class="footer">
					<p>&#169; 2014 MEMO | AGENDA EN LINEA</p>
					<ul>
						<li><a href="index.html">Inicio</a></li>
						<li><a href="about.html">Perfil</a></li>
						<li><a href="projects.html">Agenda</a></li>
						<li><a href="blog.html">Ajustes</a></li>
						<li><a href="contact.html">Contacto</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>