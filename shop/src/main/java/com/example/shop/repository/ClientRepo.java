package com.example.shop.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.shop.entities.Client;

public interface ClientRepo extends CrudRepository<Client, Long> {

}
