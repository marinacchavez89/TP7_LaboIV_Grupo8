<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tipo Seguros</title>
</head>
<body>
	
	<nav>
	<a href="Inicio.jsp"style="margin-right: 10px;">Inicio</a>
	<a href="AgregarSeguro.jsp"style="margin-right: 10px;">Agregar seguro </a> 
	<a href="ListarSeguros.jsp" >Listar seguros</a>
	</nav>

	<h1>"Tipos de seguros de la base de datos"</h1>
	
	<form action = "servletListarSeguro.jsp" method = "post">
	<label id="lblSeguro">Busqueda por tipo de Seguros:</label>
	
		<select name="tipoSeguros">
			<option>Seguro de casas</option>
			<option>Seguro de vida</option>
			<option>Seguro de motos</option>
		</select>
	
	<input type="submit" name="btnFiltrar" value="Filtrar" />
	</form>
	
	<br> 
	
	
	<table border = "1" >
		<tr>  <th> ID seguro </th> <th> Descripción seguro </th> <th> Descripción tipo seguro </th>         
		 <th> Costo contratación </th> <th> Costo máximo asegurado </th>
		</tr>
		
		<tr> <td>1</td> <td>2</td> <td>3</td> <td>4</td> <td>5</td> </tr>
	</table>
</body>
</html>