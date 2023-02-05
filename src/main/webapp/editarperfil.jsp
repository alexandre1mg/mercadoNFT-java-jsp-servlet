<jsp:include page="header.jsp" />
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mercadoNFTs.model.Usuario"%>
<%@page import="com.mercadoNFTs.dao.UsuarioDAO"%>
<%@page import="java.util.ArrayList"%>
<%
boolean logado = session.getAttribute("email") == null ? false : true;
String idUsuarioLogado = String.valueOf(session.getAttribute("id_usuarios"));
int id_user = Integer.parseInt(idUsuarioLogado);
%>
<html>
<head>
<link rel="stylesheet" href="css/style.css" />

<meta charset="utf-8">
<title>Editar</title>
</head>
<body>
	<div style="text-align: center"><h3>Editando Perfil</h3></div>
	<div class="container10">
		<%
		UsuarioDAO usDAO = new UsuarioDAO();
		Usuario us = new Usuario();
		usDAO.pesquisar(id_user);
		ArrayList<Usuario> listaus = usDAO.pesquisar(id_user);
		for (int i = 0; i < listaus.size(); i++) {
			us = listaus.get(i);
			Double cpf = Double.parseDouble(us.getCpf());
		%>
		<form action="EditarPerfil?codigo=<%=id_user%>" method="post">
			<h5><div>Nome: <input type="text" name="nome" value="<%=us.getNome()%>"></div></h5>
			<h5><div>CPF: <input type="text" name="cpf" value="<%=us.getCpf()%>"></div></h5>
			<h5><div>Email:<input type="text" name="email" value="<%=us.getEmail()%>"></div></h5>
			   <input class="btn" type="submit"value="Salvar">
		</form>
		<%
		}
		%>
	</div>

</body>
</html>