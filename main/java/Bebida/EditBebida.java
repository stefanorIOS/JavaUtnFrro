package Bebida;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.BebidaDAO;
import entities.Bebida;

/**
 * Servlet implementation class editBebida
 */
@WebServlet("/editbebida")
public class EditBebida extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBebida() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(request.getParameter("id"));
		Bebida be = new Bebida();
		be.setId(id);
		System.out.println(id);
		BebidaDAO bdao = new BebidaDAO();
		be = bdao.getBebida(be);
		request.setAttribute("be1", be);
		
		request.getRequestDispatcher("WEB-INF/editBebida.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		float precio = Float.parseFloat(request.getParameter("precio"));
		String nombre = request.getParameter("nombre");
		float litros = Float.parseFloat(request.getParameter("litros"));
		
		Bebida nuevaBebida = new Bebida();
		nuevaBebida.setId(id);
		nuevaBebida.setLitros(litros);
		nuevaBebida.setNombre(nombre);
		nuevaBebida.setPrecio(precio);
		BebidaDAO bebidadao = new BebidaDAO();
		bebidadao.updateBebida(nuevaBebida);
		
		response.sendRedirect("altabebida");
		
		
	}

}
