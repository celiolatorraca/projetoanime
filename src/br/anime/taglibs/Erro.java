package br.anime.taglibs;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

@SuppressWarnings("serial")
public class Erro extends TagSupport {

	private String name;
	private String cssClass;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getCssClass() {
		return cssClass;
	}
	
	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public int doStartTag() throws JspException {

		Map<String, String> erros = (Map<String, String>) this.pageContext.getRequest().getAttribute("erros");
		
		try {
			if ((getName() != null) && (getName().trim().length() > 0) &&
					(erros != null) && (erros.containsKey(getName()))) {
				StringBuilder conteudo = new StringBuilder("<div ");

				//Coloca o css na div caso tenha
				if (getCssClass() != null && getCssClass().trim().length() > 0) {
					conteudo.append("class=\""+getCssClass()+"\" >");
				} else {
					conteudo.append("style=\"color: red;\">");
				}
				//Coloca a msg na div
				String msg = erros.get(getName());
				if (msg != null && msg.trim().length() > 0) {
					conteudo.append(msg);
				}
				conteudo.append("</div>");
				this.pageContext.getOut().print(conteudo.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return SKIP_BODY;
	}
	
}
