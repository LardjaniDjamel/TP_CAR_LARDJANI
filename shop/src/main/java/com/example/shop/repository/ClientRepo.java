package com.example.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.shop.entities.Client;

public interface ClientRepo extends  JpaRepository<Client, Integer> {

}
