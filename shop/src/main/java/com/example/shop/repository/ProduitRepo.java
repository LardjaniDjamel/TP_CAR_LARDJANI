package com.example.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.shop.entities.*;


public interface ProduitRepo extends JpaRepository<Produit,Integer> , CrudRepository<Produit,Integer> {

}
