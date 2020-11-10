package com.TP_Serveur.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.TP_Serveur.dao.VilleDAO;
import com.TP_Serveur.dao.VilleDAOImpl;
import com.TP_Serveur.dto.Ville;

@RestController
public class VilleControler {
	
	@Autowired
	VilleDAO villeDao;
	
	@RequestMapping(value = "/ville", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Ville> appelGet() {
		System.out.println("Appel Get");
		
		return villeDao.findAllVilles();
	}
	

}
