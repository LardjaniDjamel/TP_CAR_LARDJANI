package com.example.shop.service.Impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shop.entities.Produit;
import com.example.shop.repository.ProduitRepo;
import com.example.shop.service.ProduitService;


@Service
public class ProduitServiceImpl implements ProduitService{
	
	@Autowired
	private ProduitRepo produitRepo ;

	@Override
	public ArrayList<Produit> getAllProduit() {
		// TODO Auto-generated method stub
		return (ArrayList<Produit>) produitRepo.findAll() ;
	}

	@Override
	public Produit getById(int idProduit) {
		// TODO Auto-generated method stub
		return produitRepo.getOne(idProduit);
	}

	@Override
	public Produit saveProduit(Produit produit) {
		// TODO Auto-generated method stub
		return produitRepo.save(produit);
	}

	@Override
	public Produit Update(Produit produit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteProduit(Produit produit) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
