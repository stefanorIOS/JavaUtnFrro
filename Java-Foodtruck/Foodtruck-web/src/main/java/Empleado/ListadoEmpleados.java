package Empleado;


import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.EmpleadoDAO;
import data.RolDAO;
import entities.Empleado;
import entities.Rol;

/**
 * Servlet implementation class ListadoEmpleados
 */
@WebServlet("/listadoempleados")
public class ListadoEmpleados extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListadoEmpleados() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmpleadoDAO edao = new EmpleadoDAO();
		LinkedList<Empleado> empleados = edao.getAll();
		
		request.setAttribute("listaEmpleados", empleados);
		
		request.getRequestDispatcher("WEB-INF/listadoEmpleados.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String dni = request.getParameter("dni");
		String nom = request.getParameter("nombre");
		String tur = request.getParameter("turno");
		String pass = request.getParameter("password");
		String rol = request.getParameter("rol");
		
		Rol r = new Rol();
		r.setDesc(rol);
		
		RolDAO rdao = new RolDAO();
		r = rdao.getRolByDesc(r);
		
		EmpleadoDAO edao = new EmpleadoDAO();
		Empleado e = new Empleado(dni,nom,tur,pass);
		e.addRol(r);
		edao.newEmpleado(e);
		
		doGet(request, response);
	}

}