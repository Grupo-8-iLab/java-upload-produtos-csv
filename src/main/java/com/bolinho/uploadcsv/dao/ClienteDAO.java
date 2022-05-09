package com.bolinho.uploadcsv.dao;

import com.bolinho.uploadcsv.models.Cliente;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteDAO extends CrudRepository <Cliente, Integer> {
    
}