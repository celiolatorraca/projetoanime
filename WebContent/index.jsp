<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="br.anime.dominio.Autor"%><html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Projeto A.N.I.M.E</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>

	<% Autor autor = (Autor) request.getAttribute("autor"); %>

	<div class="master" align="center">
		<jsp:include page="template.jsp" />
		
		<div class="corpo" align="center">
			<h2><strong>Corpo</strong></h2>
			<div align="center">
				<% if(autor == null) { %>
					Isso é um conteúdo!
				<% } else { %>
					<font color="red">
						<%= autor.getNome() %> cadastrado com sucesso.
					</font>
				<% } %>
			</div>
		</div>
	</div>
	
</body>
</html>