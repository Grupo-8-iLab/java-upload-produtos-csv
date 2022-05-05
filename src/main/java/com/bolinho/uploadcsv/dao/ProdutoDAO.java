package com.bolinho.uploadcsv.dao;

import com.bolinho.uploadcsv.models.Produto;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoDAO extends CrudRepository <Produto, Integer> {
    
}
