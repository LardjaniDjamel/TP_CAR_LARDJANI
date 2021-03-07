package com.example.shop.service;

import java.util.ArrayList;

import com.example.shop.entities.Client;

public interface ClientService {
	
	public ArrayList<Client> getAllClient() ;
	  
	public Client getById(int idClient);
	public Client saveClient(Client Client);
	public Client Update(Client Client);
	public Boolean deleteClient(Client Client);

}
