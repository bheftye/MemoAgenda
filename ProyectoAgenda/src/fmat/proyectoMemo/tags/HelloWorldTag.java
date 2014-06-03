package fmat.proyectoMemo.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloWorldTag extends SimpleTagSupport
{
	@Override
	public void doTag() throws JspException, IOException
	{      
		getJspContext().getOut().print("<b>Hola " + nombre + "!!</b>");    
	}

	String nombre;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


}