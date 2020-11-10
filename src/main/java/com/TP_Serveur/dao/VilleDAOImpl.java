package com.TP_Serveur.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.TP_Serveur.dto.Ville;

@Repository
public class VilleDAOImpl implements VilleDAO {

	public ArrayList<Ville> findAllVilles() {
		ArrayList<Ville> listVille = new ArrayList<Ville>();
		
		//TODO récupération et req sql
		
		return listVille;
	}
}
