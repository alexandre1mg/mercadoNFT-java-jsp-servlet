<jsp:include page="header.jsp" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mercadoNFTs.model.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mercadoNFTs.dao.ItemDao"%>

<!DOCTYPE html>

<%
    boolean logado = session.getAttribute("email") == null ? false : true;
    String idUsuarioLogado = String.valueOf(session.getAttribute("id_usuarios"));
    int id_user = Integer.parseInt(idUsuarioLogado);
    String pnm = String.valueOf(session.getAttribute("pnm"));
%>
<html>
<head>
<meta charset="utf-8" />
<title>MercadoNFTs</title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	
		<div id="pesquisar">
			<form action="ServletPesquisa" method="post">
				<img alt="Img Lupa" width="20em" src="img/search.png">
				<input size="40em" name="pnm" placeholder="procure aqui"></input>
				<input  type="submit" value="Pesquisar"></input>
			</form>			
		</div>
		
		<div id="borderbttm">
			</div>
	<div class="container-fluid">
		<%
		ItemDao itDAO = new ItemDao();
		Item it = new Item();
		itDAO.pesquisar(id_user);
		ArrayList<Item> listait = itDAO.procurar(pnm);
		for (int i = 0; i < listait.size(); i++) {
			it = listait.get(i);
			
		%>
		<div class="itens">
            <img src="img/<%=it.getImagem()%>" alt="" width="100%" height="65%">
            <p>Nome: <output><%=it.getNome()%></output></p>
            <p>Descrição:<output><%=it.getDescricao()%></output></p>
        </div>
		<%
		}
		%>
	</div>

<jsp:include page="footer.jsp" />
</body>
</html>