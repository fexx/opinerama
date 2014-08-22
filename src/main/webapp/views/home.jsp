<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="op" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Opinerama - Tudo sobre os seus produtos e serviços favoritos</title>
	<op:css-js-default/>
<%-- 	<op:notificacao /> --%>
	<link rel="stylesheet" type="text/css"	href="<c:url value='/resources/css/skin/media.css'/>" />
	<link rel="stylesheet" type="text/css"	href="<c:url value='/resources/css/home/home.css'/>" />
	<link rel="stylesheet" type="text/css"	href="<c:url value='/resources/css/skin/responsivo.css'/>" />
	<script type="text/javascript" charset="utf-8" src="<c:url value='/resources/js/home/home.js'/>"></script>

</head>
<body>
	<op:header/>
	
<input type="hidden" id="mensagemIndex" value="${mensagem}">
<div id="corpo">
	<div id="content">
		
		<div id="search">
		     <div class="section-logo">
		     	<img class="img-produto" src="<c:url value='/resources/img/geral/cascata.png'/>">
		     </div>
		     <div class="section-search">
		     	<div class="imagem-slide"></div>
     			<form id="form" method="post">
		     		<div class="input-pesquisa">
		     			<div class="bt-pesquisa">
			     			<div class="input-group">
							      <input type="text" class="form-control-fine nome-produto" id="nome-produto" name="nome" placeholder="Encontre o produto que deseja avaliar">
							      <span class="input-group-btn"><button class="btn btn-default pesquisaProduto" type="button">Encontre</button></span>
		    				</div>
	    				</div>
		     		</div>
     			</form>
		     </div>
		</div>
	
	<div id="sec-produtos-destaque">
		<div id="sec-menu-produtos">
			<div class="label-categoria">
				<p><span>Categorias de produtos</span></p>
			</div>
			<div class="menu-categoria">
			 	<ul>
			 		<div class="admin-acesso">
			 		<li class="cad-categoria">Cadastro de categorias</li>
			 		<li class="cad-fornecedor">Cadastro de fornecedores</li>
			 		</div>
			 		<li class="avaliar-produto">Avaliar Produto</li>
			 		<li><a href="/opinae/">Home</a></li>
			 		<li>perfil</li>
			 		<li>log</li>
			 		<li>Cadastro fisico</li>
			 		<li>cadastro jurídico</li>
			 		<li>cadastro complementar</li>
			 		<li>Config de acesso</li>
			 		<li>produto a</li>
			 	</ul>
			</div>
		</div>
		<div id="sec-lista-produtos">
			<div class="menu-produto">
			<img class="img-produto" src="<c:url value='/resources/img/geral/apple-iphone-5.jpg'/>">
				<div class="produtos">
				
				</div>
				
				<div class="sec-class">
					<div class="rede-social">
					<img class="img-produto" src="<c:url value='/resources/img/geral/facebook_variation.png'/>">
					</div>
					<div class="classificacao">
					<img class="img-produto" src="<c:url value='/resources/img/geral/star.png'/>">
					</div>
				</div>
			</div>
			<div class="menu-produto">
			<img class="img-produto" src="<c:url value='/resources/img/geral/apple-iphone-5.jpg'/>">
				<div class="produtos">
				
				</div>
				
				<div class="sec-class">
					<div class="rede-social">
					<img class="img-produto" src="<c:url value='/resources/img/geral/facebook_variation.png'/>">
					</div>
					<div class="classificacao">
					<img class="img-produto" src="<c:url value='/resources/img/geral/star.png'/>">
					</div>
				</div>
			</div>
			<div class="menu-produto">
			<img class="img-produto" src="<c:url value='/resources/img/geral/apple-iphone-5.jpg'/>">
				<div class="produtos">
				
				</div>
				
				<div class="sec-class">
					<div class="rede-social">
					<img class="img-produto" src="<c:url value='/resources/img/geral/facebook_variation.png'/>">
					</div>
					<div class="classificacao">
					<img class="img-produto" src="<c:url value='/resources/img/geral/star.png'/>">
					</div>
				</div>
			</div>
		</div>
	</div>	

</div>
</div>	
<op:footer/>	
</body>
</html>