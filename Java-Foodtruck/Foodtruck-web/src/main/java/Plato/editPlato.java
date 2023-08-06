package Plato;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.BebidaDAO;
import data.PlatoDAO;
import entities.Bebida;
import entities.Plato;

/**
 * Servlet implementation class editPlato
 */
@WebServlet("/editPlato")
public class editPlato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editPlato() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		
		Plato plato = new Plato();
		plato.setId(id);
		request.setAttribute("plato", plato);
		request.getRequestDispatcher("WEB-INF/editPlato.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String receta = request.getParameter("receta");
		Float precio = Float.parseFloat(request.getParameter("precio"));
		String descripcion = request.getParameter("descripcion");
		Plato plato = new Plato();
		plato.setDescripcion(descripcion);
		plato.setId(id);
		plato.setNombre(nombre);
		plato.setPrecio(precio);
		plato.setReceta(receta);
		PlatoDAO pdao = new PlatoDAO();
		pdao.updateBebida(plato);
		response.sendRedirect("AltaPlato");


		
	}

}
