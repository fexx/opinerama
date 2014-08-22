<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="op" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@tag description="Importação do cabeçalho" %>

<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/header/header.css'/>"/>
<link rel="stylesheet" type="text/css"	href="<c:url value='/resources/css/fancybox/jquery.fancybox.css'/>" />
<script type="text/javascript" charset="utf-8"	src="<c:url value='/resources/jquery/fancybox/jquery.fancybox.js'/>"></script>
<script type="text/javascript" charset="utf-8" src="<c:url value='/resources/js/header/header.js'/>"></script>

<input type="hidden" id="path" value="${pageContext.request.contextPath}">
<div id="header">
	<div class="header-center">
      	<div id="topo-logo"></div>
      	<a href="#menu" class="bt-menu" ></a>
      	<a href="#usuario-logado" class="friends right"></a>
		<nav id="acesso">
			<div class="foto-usuario-logado">
				<c:if test="${usuario != null}">
					<c:choose>
						<c:when test="${usuario.foto != null}">
							<img src="${linkTo[UsuarioController].foto[usuario.id]}" alt="${usuario.nome}">
						</c:when>
						<c:otherwise>
							<img alt="${usuario.nome}" src="<c:url value='/resources/img/icon-user/usuario-sem-foto.jpg'/>">
						</c:otherwise>
					</c:choose>
				</c:if>
	    	</div>
	       <ul id="menu-topo">
	       <c:choose>
	       	<c:when test="${usuario != null}">
	       		<li>
	       			
		       		<label id="logado" class="${usuario.id}" idusuario="${usuario.id}">${usuario.nome} </label>
	       		</li> 
	       		<li><label id="pipe">|</label></li> 
	       		<li>
		       		<label id=logout>Sair</label>
	       		</li>
	       	</c:when>
	       	<c:otherwise>
	       		<li><label id="login">Login</label></li>
	       		<li><label id="">|</label></li> 
	       		<li><label id="cadastre">Cadastre&#45;se</label></li>
	       	</c:otherwise>
	       </c:choose>
		    
	       </ul>
        </nav>
	</div>
</div>