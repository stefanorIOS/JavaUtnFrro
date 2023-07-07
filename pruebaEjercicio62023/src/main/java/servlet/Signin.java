package servlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.BebidaDAO;
import entities.Bebida;


/**
 * Servlet implementation class Signin
 */
@WebServlet({ "/Signin", "/SIGNIN", "/signin", "/SignIn", "/signIn" })
public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Signin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("GET at: ").append(request.getContextPath());
		String name = request.getParameter("name");
		response.getWriter().append("name").append(name).append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		BebidaDAO bebida1 = new BebidaDAO();
		Bebida bebida2 = new Bebida();
		bebida2.setId(2);
		bebida1.delteBebida(bebida2);
		response.getWriter().append("- Name: -").append(name).append("- Password: -").append(password).append(request.getContextPath());
		
		
		
		
	}

}
