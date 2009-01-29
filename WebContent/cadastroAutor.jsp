<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.Map"%>
<%@page import="br.anime.dominio.Autor"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Projeto A.N.I.M.E</title>

<link rel="stylesheet" type="text/css" href="css/style.css" />
<%@taglib prefix="projetoAnime" uri="/WEB-INF/tags/projetoAnime_tags.tld"%>

</head>
<body>

	<% Autor autor = (Autor) request.getAttribute("autor"); %>

	<div class="master" align="center">
		<jsp:include page="template.jsp"></jsp:include>
		
		<div class="corpo" align="center">
			<form name="form.cadastroAutor" action="cadastroAutor.do" method="post">
				<table>
					<tr>
						<th colspan="2">.: Cadastro de usuário :.</th>
					</tr>
					
					
					<tr>
						<td/>	
						<td align="center"><projetoAnime:erros name="nome_erro" cssClass="erro" /></td>
					</tr>
					<tr>
						<td align="right">Nome completo:</td>
						<td colspan="2">
							<% if (autor != null) { %>
								<input type="text" name="autor.nome" size="50" value="<%= autor.getNome() %>"/>
							<% } else { %>
								<input type="text" name="autor.nome" size="50" />
							<% } %>
						</td>
					</tr>
					
					
					<tr>
						<td/>
						<td align="left"><projetoAnime:erros name="username_erro" cssClass="erro" /></td>
					</tr>
					<tr>
						<td align="right">Login:</td>
						<td>
							<% if (autor != null) { %>
								<input type="text" name="autor.username" value="<%= autor.getUsername() %>"/>
							<% } else { %>
								<input type="text" name="autor.username" />
							<% } %>
						</td>
					</tr>
					
					
					<tr>
						<td></td>	
						<td align="left"><projetoAnime:erros name="senha_erro" cssClass="erro" /></td>
					</tr>
					<tr>
						<td align="right">Senha:</td>
						<td>
							<% if (autor != null) { %>
								<input type="password" name="autor.senha" value="<%= autor.getSenha() %>"/>
							<% } else { %>
								<input type="password" name="autor.senha" />
							<% } %>
						</td>
					</tr>
					<!-- 
					<tr>
						<td colspan="2">
							<select name="combo">
								<option value="1">Opção 1</option>
								<option value="2">Opção 2</option>
								<option value="3">Opção 3</option>
								<option value="4">Opção 4</option>
							</select>
						</td>
					</tr>
					 -->
					<tr>
						<td colspan="2" align="right">
							<input type="submit" value="Enviar"/>
						</td>
					</tr>
				</table>
			
			</form>
		
		</div>
	</div>
</body>
</html>