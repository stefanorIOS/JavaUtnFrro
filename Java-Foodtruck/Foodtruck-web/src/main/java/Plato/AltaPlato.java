package Plato;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.ClienteDAO;
import data.PlatoDAO;
import entities.Cliente;
import entities.Plato;

/**
 * Servlet implementation class AltaPlato
 */
@WebServlet({ "/AltaPlato", "/altaPlato", "/Altaplato", "/alta_Plato" })
public class AltaPlato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaPlato() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//Listamos plato
		PlatoDAO listadoPlato = new PlatoDAO();
		LinkedList<Plato> platos = listadoPlato.getAll();
		request.setAttribute("listadoPlato", platos);
		request.getRequestDispatcher("WEB-INF/listadoPlatos.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String receta = request.getParameter("receta");
		float precio = Float.parseFloat(request.getParameter("precio"));
		String descripcion = request.getParameter("descripcion");
		
		Plato p = new Plato();
		p.PlatoC(id,nombre,receta,precio,descripcion);
		
		PlatoDAO pdao = new PlatoDAO();
		
		pdao.newPlato(p);
		
		doGet(request, response);
		
		//agrega el producto pero NO lo muestra, se necesita arreglar eso, gracias
	}

}
