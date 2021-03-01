package com.example.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.shop.entities.Client;
import com.example.shop.repository.ClientRepo;

@SpringBootApplication
public class ShopApplication {
	
	
	public static void main(String[] args) {
		
		//Client c = new Client(1,"djamel" ,"lard","1 rue ","s@gmail","0566","******");
		//crepo.save(c);
		SpringApplication.run(ShopApplication.class, args);
		
	}

}


