<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
</head>
<body>

<jsp:include page="Menu.jsp" />

<h1 style="color:red;">❌ Ocurrió un error</h1>

<p><%= request.getAttribute("error") != null ? request.getAttribute("error") : "Algo falló durante la operación." %></p>

<form action="AgregarSeguro.jsp">
    <button type="submit">Volver</button>
</form>

</body>
</html>