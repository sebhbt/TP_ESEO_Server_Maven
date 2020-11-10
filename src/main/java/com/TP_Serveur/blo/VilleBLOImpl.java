package com.TP_Serveur.blo;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.TP_Serveur.dto.Ville;

@Service
public class VilleBLOImpl implements VilleBLO{
	public ArrayList<Ville> getInfoVille(){
		ArrayList<Ville> listeVille;
		
		listeVille = null;
		//TODO DAO
		
		return listeVille;
	}
}
