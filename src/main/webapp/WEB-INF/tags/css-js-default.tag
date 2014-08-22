<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@tag description="Importação padrão de css e javascript das páginas"%>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"	href="<c:url value='/resources/css/skin/skin.css'/>" />
<link rel="stylesheet" media="screen" href="<c:url value='/resources/css/skin/bootstrap.css'/>"/>
<script type="text/javascript" charset="utf-8" src="<c:url value='/resources/jquery/jquery.min.js'/>"></script>
<script type="text/javascript" charset="utf-8" src="<c:url value='/resources/js/all/contextPage.js'/>"></script>
<%-- <script type="text/javascript" src="<c:url value='/resources/jquery/datatable/dataTableFunctions.js'/>"></script> --%>

