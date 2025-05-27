package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Seguro;
import dominio.SeguroDao;

/**
 * Servlet implementation class servletListarSeguro
 */
@WebServlet("/servletListarSeguro")
public class servletListarSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletListarSeguro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SeguroDao sdao = new SeguroDao();
		ArrayList<Seguro> lista = sdao.obtenerSeguros();
		
		request.setAttribute("listaS", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("ListarSeguros.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		
		String accion = request.getParameter("accion");
	    String tipo = request.getParameter("tipoSeguros");

	    SeguroDao sdao = new SeguroDao();
	    ArrayList<Seguro> lista;

	    if ("Filtrar".equals(accion) && tipo != null && !tipo.isEmpty()) {
	        lista = sdao.obtenerSegurosPorTipo(tipo);
	    } else {
	        lista = sdao.obtenerSeguros();
	    }

	    request.setAttribute("listaS", lista);
	    RequestDispatcher rd = request.getRequestDispatcher("ListarSeguros.jsp");
	    rd.forward(request, response);
		
	}

}
