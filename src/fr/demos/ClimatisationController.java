package fr.demos;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.demos.data.ClimatisationDAO;
import fr.demos.data.SQLClimatisationDAO;
import fr.demos.formation.Climatisation;

/**
 * Servlet implementation class ClimatisationController
 */
@WebServlet("/ClimatisationController")
public class ClimatisationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClimatisationController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/saisieClimatisation.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean erreur = false;
		String action = request.getParameter("action");

		RequestDispatcher rd = request.getRequestDispatcher("/saisieClimatisation.jsp");
		request.setCharacterEncoding("UTF-8");

		if (action != null && action.equals("Enregistrer")) {
			String appareil = request.getParameter("appareil");
			String temperatureString = request.getParameter("temperature");
			String pressionString = request.getParameter("pression");
			String tauxString = request.getParameter("taux");

			double temperature = 0;
			double pression = 0;
			int taux = 0;

			// Conversion
			try {
				temperature = Double.parseDouble(temperatureString);
			} catch (NumberFormatException ex) {
				erreur = true;
				request.setAttribute("temperatureErreur", "nombre incorrect");
			}

			try {
				pression = Double.parseDouble(pressionString);
			} catch (NumberFormatException ex) {
				erreur = true;
				request.setAttribute("pressionErreur", "nombre incorrect");
			}

			try {
				taux = Integer.parseInt(tauxString);
			} catch (NumberFormatException ex) {
				erreur = true;
				;
				request.setAttribute("tauxErreur", "nombre incorrect");
			}
			
			appareil = appareil.trim();
			if (appareil == null || appareil.equals("")) {
				erreur = true;
				request.setAttribute("appareilVide", "Saisie obligatoire");
			}

			if (pression < 0) {
				erreur = true;
				request.setAttribute("pressionNegative", "Pression supérieure à 0");
			}

			if (taux < 0 || taux > 100) {
				erreur = true;
				request.setAttribute("tauxExtreme", "Taux compris entre 0 et 100");
			}

			request.setAttribute("appareil", appareil);
			request.setAttribute("temperature", temperatureString);
			request.setAttribute("pression", pressionString);
			request.setAttribute("taux", tauxString);

			if (!erreur) {
				Climatisation clim = new Climatisation(temperature, pression, taux, appareil);
				
				try{
					ClimatisationDAO dao = new SQLClimatisationDAO();
					dao.sauve(clim);
					rd = request.getRequestDispatcher("/successClimatisation.jsp");
				} catch (Exception ex){
					ex.printStackTrace();
					request.setAttribute("sauvegardeErreur", ex.getMessage());
					rd = request.getRequestDispatcher("/saisieClimatisation.jsp");
				}
			}
		}

		rd.forward(request, response);
	}
}
