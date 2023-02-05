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
%>
<html>
<head>
<meta charset="utf-8" />
<title>Meus Itens</title>
<link rel="stylesheet" href="css/style.css" />

        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

        <!-- FontAwesome -->
        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>

</head>
<body>
	

		<h3>Meus itens</h3>
		<div id="borderbttm">
			</div>
	<div class="container-fluid">
		<%
		ItemDao itDAO = new ItemDao();
		Item item = new Item();
		
		ArrayList<Item> listait = itDAO.pesquisar(id_user);
		for (int i = 0; i < listait.size(); i++) {
			item = listait.get(i);
			
		%>
		
			<div class="itens">
            <img src="img/<%=item.getImagem()%>" alt="" width="100%" height="65%">
            <p>Nome: <output><%=item.getNome()%></output></p>
            <p>Descrição:<output><%=item.getDescricao()%></output></p>
             <a href="ServletDeletarItem?codigo=<%=item.getId()%>"
                           onclick="return confirm('Tem certeza que deseja apagar esse registro? Esta ação não poderá ser desfeita.')"
                           class="btn btn-outline-danger"
                           data-toggle="tooltip" data-placement="top" title="Apagar">
                            Excluir
                        </a>
        </div>

		
		<%
		}
		%>
	</div>
	
<jsp:include page="footer.jsp" />
</body>
</html>