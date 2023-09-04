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
 * Servlet implementation class AltaBebida
 */
@WebServlet("/altabebida")
public class AltaBebida extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaBebida() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	//Listamos bebida
		BebidaDAO listadoBebida = new BebidaDAO();
		LinkedList<Bebida> bebidas = listadoBebida.getAll();
		request.setAttribute("listadoBebida", bebidas);
		request.getRequestDispatcher("WEB-INF/listadoBebida.jsp").forward(request, response);
		
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		float precio = Float.parseFloat(request.getParameter("precio"));
		String nombre = request.getParameter("nombre");
		float litros = Float.parseFloat(request.getParameter("litros"));
		
		Bebida b = new Bebida(precio, nombre, litros);
		
		BebidaDAO bdao = new BebidaDAO();
		
		bdao.newBebida(b);
		
		response.sendRedirect("altabebida");
		
	}

}
