<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="dominio.TipoSeguro" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar Seguros</title>
</head>
<body>
	
	<nav>
	<a href="Inicio.jsp"style="margin-right: 10px;">Inicio</a>
	<a href="servletAgregarSeguro" style="margin-right: 10px;">Agregar seguro</a> <!-- // corregido para ir al servlet -->
	<a href="ListarSeguros.jsp" >Listar seguros</a>
	</nav>

		<h1>Agregar seguros</h1>
		<%
		    if ("1".equals(request.getParameter("exito"))) {
		%>
		    <p style="color:green;">Seguro agregado correctamente.</p>
		<%
		    }
		    if (request.getAttribute("error") != null) {
		%>
		    <p style="color:red;"><%= request.getAttribute("error") %></p>
		<%
		    }
		%>

  <form  action="servletAgregarSeguro" method="post">
    <p>
      <label for="idSeguro">Id Seguro:</label>
		
  		<input type="text" id="idSeguro" name="idSeguro" 
  		value="<%= request.getAttribute("proximoIdSeguro") != null ? request.getAttribute("proximoIdSeguro") : "" %>" readonly />
		
    </p>

    <p>
      <label for="descripcion">Descripción:</label>
      <input type="text" id="descripcion" name="descripcion" required />
    </p>

    <p>
      <label for="idTipo">Tipo de seguro:</label>
      <select id="idTipo" name="idTipo" required>
      <%
   // este bloque imprime los tipos de seguro que el servlet pasó
        List<TipoSeguro> tipos = (List<TipoSeguro>) request.getAttribute("tiposSeguros");
        if (tipos != null) {
            for (TipoSeguro tipo : tipos) {
    %>
                <option value="<%= tipo.getIdTipo() %>"><%= tipo.getDescripcion() %></option>
    <%
            }
        }
        else {
            %>
                <option value="">No hay tipos disponibles</option>
            <%
              }
    %>
    </select><br><br>
      
        <!--<option value="">-- selecciona --</option> -->
        <!--<option value="1">Seguro de casas</option> -->
        
      
    </p>

    <p>
      <label for="costoContratacion">Costo contratación:</label>
      <input type="text" id="costoContratacion"
             name="costoContratacion" required />
    </p>


    <p>
      <label for="costoAsegurado">Costo máximo asegurado:</label>
      <input type="text" id="costoAsegurado"
             name="costoAsegurado" required />
    </p>
    <p>
      <button type="submit">Aceptar</button>
    </p>
  </form>

</body>
</html>