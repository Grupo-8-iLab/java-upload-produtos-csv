package com.bolinho.uploadcsv.dao;

import com.bolinho.uploadcsv.models.Produto;

import org.springframework.data.repository.CrudRepository;

public interface ProdutoDAO extends CrudRepository <Produto, Integer> {
    
}
