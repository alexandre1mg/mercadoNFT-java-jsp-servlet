<jsp:include page="header.jsp" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
boolean logado = session.getAttribute("email") == null ? false : true;
String idUsuarioLogado = String.valueOf(session.getAttribute("id_usuarios"));
int id_user = Integer.parseInt(idUsuarioLogado);
%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous" />
<title>Novo Item</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" />
<link rel="stylesheet" href="css/styles.css" />

</head>
<body>



	<h1 id="h1add" align="center">Adicionar NOVO ITEM</h1>


	<div class="container-fluid" style="text-align: center">

		
			<div class="novoitem">
				<form action="ServletAddItem" method="post"
					enctype="multipart/form-data">
					<input type="hidden" name="codigo" value="<%=id_user%>"> 
					<h5><input type="file" name="file" /></h5> 
					<h5><input id="descricao" type="text" name="nome" placeholder="Nome do item" /> </h5>
					<h5><input id="descricao" type="text" name="descricao" placeholder="Descrição" /></h5> 
					<input type="submit" value="Adicionar Item">
				</form>

		</div>

	</div>

</body>
</html>