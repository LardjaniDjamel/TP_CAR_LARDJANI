package com.example.shop.service.Impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.shop.entities.LigneCommande;
import com.example.shop.repository.LigneCommandeRepo;
import com.example.shop.service.LigneCommandeService;

@Service
public class LigneCommandeServiceImpl implements LigneCommandeService{

	LigneCommandeRepo LigneCommandeRepo;
	@Override
	public ArrayList<LigneCommande> getAllLigneCommande() {
		// TODO Auto-generated method stub
		return (ArrayList<LigneCommande>) LigneCommandeRepo.findAll() ;
	}

	@Override
	public LigneCommande getById(int idLigneCommande) {
		// TODO Auto-generated method stub
		return LigneCommandeRepo.getOne(idLigneCommande);
	}

	@Override
	public LigneCommande saveLigneCommande(LigneCommande LigneCommande) {
		// TODO Auto-generated method stub
		return LigneCommandeRepo.save(LigneCommande);
	}

	@Override
	public LigneCommande Update(LigneCommande LigneCommande) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteLigneCommande(LigneCommande LigneCommande) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int GetIdLigneFromIDP(int idP) {
		for( LigneCommande c: LigneCommandeRepo.findAll()) 
		{
			if(c.getId_produit()==idP) {
				return c.getIdLigne();
			}
			
		}
		return 0;
	}


}
