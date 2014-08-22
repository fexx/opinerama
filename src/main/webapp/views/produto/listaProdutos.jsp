<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="op" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
  <body>
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
								<img class="img-pesquisa" src="../resources/images/produto/produto-semImagem.gif">
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
  </body>
</html>