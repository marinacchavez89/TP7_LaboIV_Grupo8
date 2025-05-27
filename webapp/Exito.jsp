<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Éxito</title>
</head>
<body>

<jsp:include page="Menu.jsp" />

<h1 style="color:green;">✔ Operación realizada con éxito</h1>

<p><%= request.getAttribute("mensaje") != null ? request.getAttribute("mensaje") : "Todo salió bien." %></p>

<form action="${pageContext.request.contextPath}/servletAgregarSeguro"
method="get">
    <button type="submit">Volver</button>
</form>

</body>
</html>