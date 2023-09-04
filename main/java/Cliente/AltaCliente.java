package Cliente;


import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.ClienteDAO;
import entities.Cliente;


/**
 * Servlet implementation class AltaCliente
 */
@WebServlet("/listadoclientes")
public class AltaCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaCliente() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClienteDAO cdao = new ClienteDAO();
		LinkedList<Cliente> clientes = cdao.getAll();
		request.setAttribute("listaclientes", clientes);
		request.getRequestDispatcher("WEB-INF/listadoClientes.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String dni = request.getParameter("dni");
		String nom = request.getParameter("nombre");
		String dir = request.getParameter("direccion");
		
		Cliente c = new Cliente(dni,nom,dir);
		
		ClienteDAO cdao = new ClienteDAO();
		
		cdao.newCliente(c);
		
		doGet(request, response);
	}

}
