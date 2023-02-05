<jsp:include page="header.jsp" />
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mercadoNFTs.model.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mercadoNFTs.dao.UsuarioDAO"%>
<%
    boolean logado = session.getAttribute("email") == null ? false : true;
    String idUsuarioLogado = String.valueOf(session.getAttribute("id_usuarios"));
    int id_user = Integer.parseInt(idUsuarioLogado);
%>
<html>
<head>
<meta charset="utf-8" />
<link rel="stylesheet" href="css/style.css" />
<title>Perfil</title>
</head>
<body>
	<div class="container10">

			<h3>Seu Perfil</h3>
		<div>
		<%
		UsuarioDAO usDAO = new UsuarioDAO();
		Usuario us = new Usuario();
		usDAO.pesquisar(id_user);
		ArrayList<Usuario> listaus = usDAO.pesquisar(id_user);
		for (int i = 0; i < listaus.size(); i++) {
			us = listaus.get(i);
			Double cpf = Double.parseDouble(us.getCpf());
		%>
		<h5>Nome: <output><%=us.getNome()%></output></h5>
		<h5>CPF:  <output><%=us.getCpf()%></output></h5>
		<h5>Email:<output><%=us.getEmail()%></output></h5>
		<%
		}
		%>
		<a href="editarperfil.jsp">Editar</a>
	</div>
</div>
<jsp:include page="footer.jsp" />
</body>
</html>