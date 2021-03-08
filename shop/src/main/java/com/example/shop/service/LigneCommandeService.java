package com.example.shop.service;

import java.util.ArrayList;

import com.example.shop.entities.LigneCommande;

public interface LigneCommandeService {
	
		
		public ArrayList<LigneCommande> getAllLigneCommande() ;
		  
		public LigneCommande getById(int idLigneCommande);
		public LigneCommande saveLigneCommande(LigneCommande LigneCommande);
		public LigneCommande Update(LigneCommande LigneCommande);
		public Boolean deleteLigneCommande(LigneCommande LigneCommande);
		public int GetIdLigneFromIDP(int idP);

	}



