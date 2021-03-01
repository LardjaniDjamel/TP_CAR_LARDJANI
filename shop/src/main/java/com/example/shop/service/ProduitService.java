package com.example.shop.service;

import java.util.ArrayList;

import com.example.shop.entities.Produit;

public interface ProduitService {
	
	
	public ArrayList<Produit> getAllProduit() ;
	  
	public Produit getById(int idProduit);
	public Produit saveProduit(Produit produit);
	public Produit Update(Produit produit);
	public Boolean deleteProduit(Produit produit);

}
