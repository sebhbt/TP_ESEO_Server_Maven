package com.TP_Serveur.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.TP_Serveur.dto.Ville;

@Repository
public class VilleDAOImpl implements VilleDAO {

	public ArrayList<Ville> findAllVilles() {
		ArrayList<Ville> listVille = new ArrayList<Ville>();

		Connection con = null;
		ResultSet résultats = null;
		String requete = "";

		// chargement du pilote
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
			System.out.println("Impossible de charger le pilote org.h2");
		}

		// connection a la base de données

		System.out.println("Connexion a la base de données");
		try {

			String DBurl = "jdbc:h2:tcp://localhost/~/test";
			con = DriverManager.getConnection(DBurl, "sa", "");
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("Connection à la base de données impossible");
		}

		try {
			Statement stmt = con.createStatement();
			boolean nbMaj = stmt.execute(requete);
			System.out.println("Resultat : " + nbMaj);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// creation et execution de la requete
		System.out.println("Creation et execution de la requête");
		requete = "SELECT * FROM VILLE_FRANCE";

		try {
			Statement stmt = con.createStatement();
			résultats = stmt.executeQuery(requete);
		} catch (SQLException e) {
			System.out.println("Anomalie lors de l'execution de la requête");
		}

		// parcours des données retournées
		System.out.println("Parcours des données retournées");
		try {
			ResultSetMetaData rsmd = résultats.getMetaData();
			int nbCols = rsmd.getColumnCount();
			boolean encore = résultats.next();

			while (encore) {
				Ville ville = new Ville();
				ville.setCodeCommune(résultats.getString(1));
				ville.setNomCommune(résultats.getString(2));
				ville.setCodePostal(résultats.getString(3));
				ville.setLibelleAcheminement(résultats.getString(4));
				ville.setLigne(résultats.getString(5));
				
				listVille.add(ville);
				
				encore = résultats.next();
			}

			résultats.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return listVille;
	}
}
