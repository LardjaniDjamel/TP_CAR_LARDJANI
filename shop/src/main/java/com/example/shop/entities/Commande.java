package com.example.shop.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="commande")
public class Commande implements Serializable{
	
	@Id
	@GeneratedValue
	@Column(name="idCommande")
	private int id_commande;
	private int id_client;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	
	
	private Commande (int id,int idC,Date date) 
	{
		this.id_commande=id;
		this.id_client=idC;
		this.date=date;
	}


	public int getId_commande() {
		return id_commande;
	}


	public void setId_commande(int id_commande) {
		this.id_commande = id_commande;
	}


	public int getId_client() {
		return id_client;
	}


	public void setId_client(int id_client) {
		this.id_client = id_client;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
