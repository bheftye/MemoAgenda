package fmat.proyectoMemo.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

@SuppressWarnings("serial")
public class ShowFriends extends TagSupport {
	public int doStartTag() throws JspException {
		generate( pageContext.getOut() );
		return( SKIP_BODY );
	}
	
	String id_usuario;



	private void generate(JspWriter out) {
		// TODO Auto-generated method stub
		String preffix ="<tr><td>";
		String suffix ="</td></tr>";
		try {
			out.println(preffix + " Id usuario: "+id_usuario + suffix);
			out.println(preffix + "Genny" + suffix);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(String id_usuario) {
		this.id_usuario = id_usuario;
	}
}
