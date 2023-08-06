package Bebida;

import java.io.IOException;
import java.util.LinkedList;

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
 * Servlet implementation class AltaBebida
 */
@WebServlet("/AltaBebida")
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
		
		
		
		// TODO Auto-generated method stub
    	
    	
    	int id = Integer.parseInt(request.getParameter("id"));
		float precio = Float.parseFloat(request.getParameter("precio"));
		String nombre = request.getParameter("nombre");
		float litros = Float.parseFloat(request.getParameter("litros"));
		
		Bebida b = new Bebida();
		b.BebidaB(id, precio, nombre, litros);
		
		BebidaDAO bdao = new BebidaDAO();
		
		bdao.newBebida(b);
		
		//puedo crear de nuevo la lista o simplemente redirijir al doget para ver la lista actualizada, pero se repiten las credenciales
	//	LinkedList<Bebida> bebidas = bdao.getAll();
		//request.setAttribute("listadoBebida", bebidas);
		
	//	request.getRequestDispatcher("WEB-INF/listadoBebida.jsp").forward(request, response);
		doGet(request, response);
		
		
	
		
	}

}
