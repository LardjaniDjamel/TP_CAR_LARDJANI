package com.example.shop.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Produit implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom ;
	private int price ;
	private int quantite;
	private String categorie;
	private String image ;
	
	

	
	public Produit() {
		super();
	}
	
	
	public Produit(int id, String nom,int d,int quantite, String categorie,String img) {
		this.id = id;
		this.nom=nom;
		this.price=d;
		this.image=img;
		this.quantite = quantite;
		this.categorie = categorie;
	}



	public int getIdProduit() {
		return id;
	}


	public void setIdProduit(int idProduit) {
		this.id = idProduit;
	}


	public int getQuantiteStock() {
		return quantite;
	}


	public void setQuantiteStock(int quantiteStock) {
		this.quantite = quantiteStock;
	}


	public String getCategorie() {
		return categorie;
	}

	public String getName() {
		return this.nom;
	}


	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getQuantite() {
		return quantite;
	}


	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}
	
	

}
