<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar</title>
<link rel="stylesheet" href="css/style.css" />
 <script type="text/javascript">
  function cad() {
	  window.alert("Cadastro realizado com sucesso!");
}
  </script>
</head>
<body>
<jsp:include page="header.jsp" />
	<div class="container10">
		    <div class="">
        <h1 class="display-4">Cadastro</h1>
        <form action="ServletUsuario" method="post">
             <input placeholder="Nome" type="text" name="nm"><br><br/>
             <input placeholder="CPF" type="text" name="cpf"> <br> <br/>
             <input placeholder="Email" type="text" name="email"> <br><br/> 
             <input placeholder="Senha" type="password" name="senha"> <br><br/> 
             <input onclick="cad();" type="submit" value="Cadastrar"> 
        </form>
        
    </div>
	</div>
<jsp:include page="footer.jsp" />
</body>
</html>