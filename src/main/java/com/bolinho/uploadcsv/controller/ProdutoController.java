package com.bolinho.uploadcsv.controller;

import java.util.List;

import com.bolinho.uploadcsv.dao.ProdutoDAO;
import com.bolinho.uploadcsv.models.Produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProdutoController {
    
    @Autowired
    private ProdutoDAO dao;

    @GetMapping("/dados")
    public String getAllData() {
        List<Produto> dados = (List <Produto>) dao.findAll();
        return null;
    }
}
