
<!DOCTYPE html>
<%
    boolean logado = session.getAttribute("email") == null ? false : true;
    String idUsuarioLogado = String.valueOf(session.getAttribute("id_usuarios"));
%>
<html>
<head>
<meta charset="utf-8" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" />
<link rel="stylesheet" href="css/styles.css" />

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
</head>
<body>
	<header class="topo1" id="Topo">
		<nav class="navbar navbar-expand-lg">
			<div class="container-fluid">
				<a class="navbar-brand" href="index.jsp">Mercado NFTs</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">


					</ul>
					<div>
						    <% if (logado) {%>
                            
                            <%} else {%>
                            <a class="nav-link" href="login.jsp">Entrar</a>
                            <%} %>
					</div>
					<div class="dropdown">
						<button class="btn btn-secondary dropdown-toggle" type="button"
							id="dropdownMenuButton1" data-bs-toggle="dropdown"
							aria-expanded="false" style="background-color: rgb(0, 0, 65);">Menu</button>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
								<li><a class="dropdown-item" href="perfil.jsp">Perfil</a></li>
								<li><a class="dropdown-item" href="novoitem.jsp">Novo Item</a></li>
								<li><a class="dropdown-item" href="meusitens.jsp">Meus Itens</a></li>
								<li><hr class="dropdown-divider" /></li>
								<li><a class="dropdown-item" href="ServletDeslogar">Sair</a></li>
						</ul>
					</div>
											    <% if (logado) {%>
                            <img class="img001" src="img/mcc.jpg" width="50px"></img>
                            <%} else {%>
                            
                            <%} %>
					
				</div>
			</div>
		</nav>
	</header>
</body>
</html>