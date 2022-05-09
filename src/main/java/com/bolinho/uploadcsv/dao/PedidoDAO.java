package com.bolinho.uploadcsv.dao;

import com.bolinho.uploadcsv.models.Pedido;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoDAO extends CrudRepository <Pedido, Integer> {
    
}