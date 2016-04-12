package fr.demos.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import fr.demos.formation.Climatisation;

public class SQLClimatisationDAO implements ClimatisationDAO{

	private DataSource ds = null;
	
	public SQLClimatisationDAO() throws Exception {
		//Recherche dans l'annuaire du pool de connexion (utilisation de la librairie JNDI)
		Context context = new InitialContext();
		ds = (DataSource)context.lookup("jdbc/appliclim");
	}
	
	public void sauve(Climatisation cl) throws Exception {
		//On demande une connexion au pool
		Connection cx = ds.getConnection();
		//On va pouvoir préparer notre requête SQL
		PreparedStatement psmt = cx.prepareStatement("insert into climatisation values (?,?,?,?,?)");
		psmt.setString(1, cl.getNomAppareil());
		psmt.setDouble(2, cl.getTemperature());
		psmt.setDouble(3, cl.getPression());
		psmt.setInt(4, cl.getTauxHumidite());
		psmt.setLong(5, cl.getDatation());
		psmt.executeUpdate();//On lance la commande dans la base
		cx.close();//On rend la connexion au pool car on a fini de l'utiliser
		
		//Exemple de méthode pour passer toutes les informations en même temps
		//Statemet stmt = cx.createStatement()
		//stmt.executeUpdate("insert into climatisation values ("+cl.getNomAppareil()+","+...
		//Ecriture à éviter pour ne pas faire de l'injection	
	}

	@Override
	public List<Climatisation> rechercheTout() throws Exception {
		Connection cx = ds.getConnection();
		PreparedStatement psmt = cx.prepareStatement("select * from climatisation");
		ResultSet rs = psmt.executeQuery();
		ArrayList<Climatisation> liste = new ArrayList<>();
		while (rs.next()){
			String nomAppareil = rs.getString(1);
			double temperature = rs.getDouble(2);
			double pression = rs.getDouble(3);
			int tauxHumidite = rs.getInt(4);
			long datation = rs.getLong(5);
			Climatisation cl = new Climatisation(temperature, pression, tauxHumidite, nomAppareil);
			liste.add(cl);
		}
		return liste;
	}

	@Override
	public List<Climatisation> rechercheTout(String critere) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nombre(String critere) {
		int nb = 0;
		try{
			List<Climatisation> liste = this.rechercheTout();
			nb = liste.size();
		} catch (Exception e){}
		return nb;
	}

}
