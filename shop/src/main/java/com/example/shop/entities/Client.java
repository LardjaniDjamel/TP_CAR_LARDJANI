package com.example.shop.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="client")
//@Embeddable
public class Client  implements Serializable {
	
	@Id
	@GeneratedValue
	private int id;
	private String nom;
	private String prenom;
	private String adresse ;
	private String email;
	private String numero;
	private String motDePasse;

	/*
	@OneToMany(mappedBy = "client")
	private List<Produit> ListProduit;
	*/
	
	public Client() {
		super();
	}
	
	
	public Client (int id,String nom ,String prenom,String adresse,String email,String numero,String motDePasse) 
	{
		this.id=id;
		this.nom=nom;
		this.prenom=prenom;
		this.adresse=adresse;
		this.email=email;
		this.numero=numero;
		this.motDePasse=motDePasse;
		//this.ListProduit=new ArrayList<Produit>();
		
	}
 
	
	
	public int getId_client() {
		return id;
	}


	public void setId_client(int id_client) {
		this.id = id_client;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
	
	
	
	

}
