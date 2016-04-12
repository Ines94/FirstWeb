package fr.demos;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.demos.formation.Climatisation;

/**
 * Servlet implementation class MaDate
 */
@WebServlet("/MaDateController")
public class MaDateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MaDateController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//d représente le modèle
		Date d = new Date();
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/YYYY");
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH");
		SimpleDateFormat sdf3 = new SimpleDateFormat("mm");
		
		String s=sdf1.format(d);
		String v=sdf2.format(d);
		String t=sdf3.format(d);
		
		//Transfert du modèle
		request.setAttribute("dateDuJour", s);
		request.setAttribute("heureDuJour", v);
		request.setAttribute("minuteDuJour", t);
		
		Climatisation clim1 = new Climatisation (24,1013,75,"R02");
		
		request.setAttribute("clim1", clim1);
		
		//Appel de la vue
		RequestDispatcher rd = request.getRequestDispatcher("/madateView.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
