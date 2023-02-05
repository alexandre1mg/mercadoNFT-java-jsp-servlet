<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	

	<link rel="stylesheet" href="css/style.css" />

	<link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.0.0/mdb.min.css" rel="stylesheet" />
<title>MercadoNFTs</title>
</head>
<body>
	<section class="h-100 gradient-form" style="background-color: white;">
		<div class="container py-5 h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-xl-10">
					<div class="card rounded-3 text-black">
						<div class="row g-0">
							<div class="col-lg-6">
								<div class="card-body p-md-5 mx-md-4">

									<div class="text-center">
										
										<h4 class="mt-1 mb-5 pb-1">Mercado NFTs</h4>
									</div>

									<form action="ServletLogin" method="post">


										<div class="form-outline mb-4">
											<input name="email" type="email" id="form2Example11" class="form-control"
												placeholder="email@exemplo.com" /> <label
												class="form-label" for="form2Example11">Email</label>
										</div>

										<div class="form-outline mb-4">
											<input name="senha" type="password" id="form2Example22"
												class="form-control" /> <label class="form-label"
												for="form2Example22">Senha</label>
										</div>

										<div class="text-center pt-1 mb-5 pb-1">
											
											<button 
												class="btn btn-primary btn-block fa-lg gradient-custom-2 mb-3"
												type="submit">Entrar</button>
												

										</div>
											
										<div
											class="d-flex align-items-center justify-content-center pb-4">
											<p class="mb-0 me-2">Não possui uma conta?</p>
											
												<a href="cadastrar.jsp"><button  type="button" class="btn btn-outline-danger">Cadastre-se</button></a>
											
										</div>

									</form>

								</div>
							</div>
							<div
								class="col-lg-6 d-flex align-items-center gradient-custom-2">
								<div class="text-white px-3 py-4 p-md-5 mx-md-4">
									<h4 class="mb-4" style="color: white;">Mostre o que você tem e diga o que quer!</h4>
									<p class="small mb-0 " style="color: white;">Aqui você pode colocar suas NFTs que
										quer vender ou trocar e também você pode colocar pedido de
										compra.</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>