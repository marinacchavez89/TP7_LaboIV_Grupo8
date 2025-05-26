<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Éxito</title>
</head>
<body>

<nav>
    <a href="Inicio.jsp" style="margin-right: 10px;">Inicio</a>
    <a href="AgregarSeguro.jsp" style="margin-right: 10px;">Agregar seguro</a>
    <a href="ListarSeguros.jsp">Listar seguros</a>
</nav>

<h1 style="color:green;">✔ Operación realizada con éxito</h1>

<p><%= request.getAttribute("mensaje") != null ? request.getAttribute("mensaje") : "Todo salió bien." %></p>

<form action="Inicio.jsp">
    <button type="submit">Volver</button>
</form>

</body>
</html>