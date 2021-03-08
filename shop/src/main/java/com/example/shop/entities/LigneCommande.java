package com.example.shop.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ligneCommande")
public class LigneCommande implements Serializable 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLigne;
	
	
	private int ic_client;
	private int id_produit;
	private int quantite;
	private float prixTotal;
	
	public LigneCommande() 
	{
		super();	
	}

	
	
	public LigneCommande(int idp,int idc,int quantite,float prix) 
	{
		this.ic_client=idc;
		this.id_produit=idp;
		this.prixTotal=prix;
		this.quantite=quantite;
		
	}



	public int getId_produit() {
		return id_produit;
	}


	public void setId_produit(int id_produit) {
		this.id_produit = id_produit;
	}


	public int getQuantite() {
		return quantite;
	}


	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}


	public float getPrixTotal() {
		return prixTotal;
	}


	public void setPrixTotal(float prixTotal) {
		this.prixTotal = prixTotal;
	}



	public int getIdLigne() {
		return idLigne;
	}



	public void setIdLigne(int idLigne) {
		this.idLigne = idLigne;
	}



	public int getIc_client() {
		return ic_client;
	}



	public void setIc_client(int ic_client) {
		this.ic_client = ic_client;
	}
	
	
}
	
	
	


