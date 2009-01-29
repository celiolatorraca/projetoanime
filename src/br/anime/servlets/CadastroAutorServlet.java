package br.anime.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.dv.ValidationContext;

import br.anime.dominio.Autor;

@SuppressWarnings("serial")
public class CadastroAutorServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("autor.nome");
		String username = req.getParameter("autor.username");
		String senha = req.getParameter("autor.senha");
		
		Map<String, String> erros = VerificaCampos(nome, username, senha);
		
		if (!erros.isEmpty()) {
			req.setAttribute("erros", erros);
			
			RequestDispatcher rd = req.getRequestDispatcher("cadastroAutor.jsp");
			rd.forward(req, resp);
		} else {
			Autor autor = new Autor(nome, username, senha);

			req.setAttribute("autor", autor);

			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	public Map<String, String> VerificaCampos(String nome, String username, String senha) {
		
		Map<String, String> erros = new HashMap<String, String>();
		
		if (nome == null || nome.trim().length() <= 0) {
			erros.put("nomeErro", "Preencha o seu Nome");
		}
		if (username == null || username.trim().length() <= 0) {
			erros.put("usernameErro", "Preencha o seu Login");
		}
		if (senha == null || senha.trim().length() <= 0) {
			erros.put("senhaErro", "Preencha a sua Senha");
		}
		return erros;
	}

}
