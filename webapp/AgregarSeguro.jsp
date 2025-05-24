<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar Seguros</title>
</head>
<body>
	
	<nav>
	<a href="Inicio.jsp"style="margin-right: 10px;">Inicio</a>
	<a href="AgregarSeguro.jsp"style="margin-right: 10px;">Agregar seguro </a> 
	<a href="ListarSeguros.jsp" >Listar seguros</a>
	</nav>

		<h1>"Agregar seguros"</h1>

  <form  action="servletAgregarSeguro" method="post">
    <p>
      <label for="idSeguro">Id Seguro:</label>
<!--  seguro utilicemos id autogenerado -->
    </p>

    <p>
      <label for="descripcion">Descripción:</label>
      <input type="text" id="descripcion" name="descripcion" required />
    </p>

    <p>
      <label for="idTipo">Tipo de seguro:</label>
      <select id="idTipo" name="idTipo" required>
        <option value="">-- selecciona --</option>
        <option value="1">Seguro de casas</option>
        <!-- Podemos agregar mas tipo de seguros segun sea necesario -->
      </select>
    </p>

    <p>
      <label for="costoContratacion">Costo contratación:</label>
      <input type="text" id="costoContratacion"
             name="costoContratacion" required />
    </p>


    <p>
      <label for="costAsegurado">Costo máximo asegurado:</label>
      <input type="text" id="costoAsegurado"
             name="costoAsegurado" required />
    </p>
    <p>
      <button type="submit">Aceptar</button>
    </p>
  </form>

</body>
</html>