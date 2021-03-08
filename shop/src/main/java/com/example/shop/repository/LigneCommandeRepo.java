package com.example.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shop.entities.LigneCommande;

public interface LigneCommandeRepo  extends  JpaRepository<LigneCommande, Integer>{
	
 

}
