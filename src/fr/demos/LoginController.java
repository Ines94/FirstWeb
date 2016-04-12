package fr.demos;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
		HttpSession session = request.getSession();

		String action = request.getParameter("action");

		if (action != null && action.equals("Login")) {
			String nom = request.getParameter("nom");

			// Retire les espaces de début, de fin et de récuper la chaîne
			nom = nom.trim();
			if (nom != null && !nom.equals("")) {
				session.setAttribute("nom", nom);
				rd = request.getRequestDispatcher("/ListClimatisationController");
			} else {
				request.setAttribute("nomVide", "Saisie obligatoire");
			}
		}
		rd.forward(request, response);
	}
}
