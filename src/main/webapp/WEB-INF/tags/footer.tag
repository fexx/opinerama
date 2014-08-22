<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="op" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@tag description="Importação do rodapé" %>

<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/footer/footer.css'/>"/>
<link rel="stylesheet" type="text/css"	href="<c:url value='/resources/css/fancybox/jquery.fancybox.css'/>" />
<script type="text/javascript" charset="utf-8"	src="<c:url value='/resources/jquery/fancybox/jquery.fancybox.js'/>"></script>
<script type="text/javascript" charset="utf-8" src="<c:url value='/resources/js/footer/footer.js'/>"></script>

<div id="footer">
		<div id="footer-center">
			<div id="footer-menu">
			     <div id="menu-esquerdo">
				        <p><span id="sobre">Sobre a Opinerama</span></p>
				        <p><span id="faq">FAQ</span></p>
						<p><span id="contato">Contato</span></p>
				 </div>
			</div>
			 <div id="footer-logo">
			 
			 </div>
		</div> 
 </div>
 <hr>
<div class="reserved">
	© 2013 - <script type="text/javascript"> var d = new Date(); document.write(d.getFullYear());</script> <a href="/">Opinerama</a>, Inc. All Rights Reserved.
	<a href="#">Terms of Use</a> and
	<a href="#">Privacy</a>
</div>
