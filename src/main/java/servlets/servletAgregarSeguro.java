package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Seguro;
import dominio.SeguroDao;
import dominio.TipoSeguro;
import dominio.TipoSeguroDao;


/**
 * Servlet implementation class servletSeguro
 */
@WebServlet("/servletAgregarSeguro")
public class servletAgregarSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletAgregarSeguro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        TipoSeguroDao tipoSeguroDao = new TipoSeguroDao();
        List<TipoSeguro> tipos = tipoSeguroDao.obtenerTodos();
        request.setAttribute("tiposSeguros", tipos);

        //  obtener próximo id de seguro y setearlo en el request
        SeguroDao seguroDao = new SeguroDao();
        int proximoId = seguroDao.obtenerProximoId();  // Método que vamos a crear abajo
        request.setAttribute("proximoIdSeguro", proximoId);

        request.getRequestDispatcher("AgregarSeguro.jsp").forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entró en doPost AgregarSeguro");
		// TODO Auto-generated method stub
		String descripcion = request.getParameter("descripcion");
	    int idTipo = Integer.parseInt(request.getParameter("idTipo")); 
	    float costoContratacion = Float.parseFloat(request.getParameter("costoContratacion"));
	    float costoAsegurado = Float.parseFloat(request.getParameter("costoAsegurado"));

	    Seguro seguro = new Seguro();
	    seguro.setDescripcion(descripcion);
	    seguro.setIdTipo(idTipo);
	    seguro.setCostoContratacion(costoContratacion);
	    seguro.setCostoAsegurado(costoAsegurado);
	    
	    SeguroDao seguroDao = new SeguroDao();
	    boolean agregado = seguroDao.agregarSeguro(seguro);

	    if (agregado) {
	        System.out.println("Seguro agregado");
	        response.sendRedirect("AgregarSeguro.jsp?exito=1"); 
	    } else {
	        request.setAttribute("error", "Error al agregar");
	        request.getRequestDispatcher("AgregarSeguro.jsp").forward(request, response);
	    }
	    
	}
	
}


