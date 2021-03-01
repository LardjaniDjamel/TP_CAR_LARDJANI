package com.example.shop.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ligneCommande")
public class LigneCommande implements Serializable 
{
	@Id
	private int id_commande;
	
	@Id
	private int id_produit;
	private int quantite;
	private float prixTotal;
	

	
	
	public LigneCommande(int idc,int idp,int quantite,float prix) 
	{
		
		this.id_commande=idc;
		this.id_produit=idp;
		this.prixTotal=prix;
		this.quantite=quantite;
		
	}


	public int getId_commande() {
		return id_commande;
	}


	public void setId_commande(int id_commande) {
		this.id_commande = id_commande;
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
	
	
}
	
	
	


