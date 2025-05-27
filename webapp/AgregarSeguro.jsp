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
	
<jsp:include page="Menu.jsp" />

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
		
  		<label id="idSeguro" name="idSeguro" >
  		<%= request.getAttribute("proximoIdSeguro") != null ? request.getAttribute("proximoIdSeguro") : "" %>
  		</label>
  		<input type="hidden" name="idSeguro" value="<%= request.getAttribute("proximoIdSeguro") != null ? request.getAttribute("proximoIdSeguro") : "" %>" />
  		
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
      
      
    </p>

    <p>
      <label for="costoContratacion">Costo contratación:</label>
      <input type="number" id="costoContratacion"
             name="costoContratacion"
             min="0"
             step="0.01"
              required />
    </p>


    <p>
      <label for="costoAsegurado">Costo máximo asegurado:</label>
      <input type="number" id="costoAsegurado"
             name="costoAsegurado"
             min="0"
             step="0.01"
              required />
    </p>
    <p>
      <button type="submit">Aceptar</button>
    </p>
  </form>

</body>
</html>