<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="op" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Opinerama : Opinar produto</title>
<op:css-js-default/>
<%-- <link rel="stylesheet" type="text/css"	href="<c:url value='/resources/css/fancybox/jquery.fancybox-buttons.css'/>" /> --%>
<%-- <link rel="stylesheet" type="text/css"	href="<c:url value='/resources/css/fancybox/jquery.fancybox-thumbs.css'/>" /> --%>
<%-- <link rel="stylesheet" type="text/css"	href="<c:url value='/resources/css/fancybox/jquery.fancybox.css'/>" /> --%>
<%-- <script type="text/javascript" src="<c:url value='/resources/jquery/fancybox/jquery.fancybox.js'/>"></script> --%>
<%-- <script type="text/javascript" src="<c:url value='/resources/jquery/fancybox/jquery.fancybox-buttons.js'/>"></script> --%>
<%-- <script type="text/javascript" src="<c:url value='/resources/jquery/fancybox/jquery.fancybox-thumbs.js'/>"></script> --%>
<%-- <script type="text/javascript" src="<c:url value='/resources/jquery/outras/jquery.easing-1.3.pack.js'/>"></script> --%>
<%-- <script type="text/javascript" src="<c:url value='/resources/jquery/outras/jquery.mousewheel-3.0.6.pack.js'/>"></script> --%>
<%-- <script type="text/javascript" src="<c:url value='/resources/jquery/jquery.slickhover.js'/>"></script> --%>
<%-- <script type="text/javascript" charset="utf-8" src="<c:url value='/resources/js/produto/pesquisaProduto.js'/>"></script> --%>
<link rel="stylesheet" type="text/css"	href="<c:url value='/resources/css/skin/media.css'/>" />
<link rel="stylesheet" type="text/css"	href="<c:url value='/resources/css/produto/pesquisaProduto.css'/>" />
<script type="text/javascript" charset="utf-8" src="<c:url value='/resources/js/produto/listaProdutos.js'/>"></script>
</head>
  <body>
<op:header/>

	<div class="container">
			<div class="one columns">
				<div class="panel panel-default">
					<div class="panel-heading">Encontre o produto que deseja avaliar</div>
					  <div class="panel-body">
					  <div class="two columns">
					  	<select id="idCategoriaSuperPai" class="select-fine selectpicker show-tick">
					  		<option value="0">Todas as categorias</option>
					  		<c:forEach var="categoria" items="${categorias}">
					  			<option value="${categoria.id}">${categoria.descricao}</option>
					  		</c:forEach>
					  	</select>
					  </div>
					   <div class="two columns">
							<div class="input-group">
								<input type="text" class="form-control-fine" id="nome-produto-pesq" placeholder="Busque pelo produto que deseja avaliar">
								<span class="input-group-btn">
									<button class="btn btn-default" id="bt-buscar-produto" type="button">Encontre</button>
								</span>
				    		</div>
					   </div>	
					  </div>
			    </div>
			</div>
		
		<div class="buscando-loading"></div>
			<div class="produtos-encontrados">
				<c:choose>
					<c:when test="${totalProdutos > 0}">
						<h4 class="total-produtos"> ${totalProdutos} ${texto}</h4>
					</c:when>
					<c:otherwise>
<!-- 						<h4 class="total-produtos"> Nenhum produto encontrado </h4> -->
					</c:otherwise>
				</c:choose>
								
				<c:forEach var="produto" items="${listaProdutos}">
					<div class="resultado-pesquisa-produto ${produto.categoria.superPai}" id="${produto.id}">
						<div class="img-pesq-produto">
							
							<c:choose>
								<c:when test="${produto.foto != null}">
									<img class="img-pesquisa" src="${linkTo[ProdutoController].foto[produto.id]}">
								</c:when>
								<c:otherwise>
									<img class="img-pesquisa" src="../resources/img/produto/produto-semImagem.gif">
								</c:otherwise>
							</c:choose>
						
						</div>
						<div class="informacoes-pesquisa-produto">
							<div class="titulo-prod-pesquisado">
								${produto.nome}
							</div>
							<div class="descricao-prod-pesquisado">
								${produto.descricao}
							</div>
						</div>
					</div>
				</c:forEach>	
			</div>
	</div>
	
	<op:footer/>
  </body>
</html>