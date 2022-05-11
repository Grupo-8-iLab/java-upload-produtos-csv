package com.bolinho.uploadcsv.controller;

import java.util.List;

import com.bolinho.uploadcsv.dao.ProdutoDAO;
import com.bolinho.uploadcsv.models.Produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoDAO dao;

    @GetMapping("/produtos")
    public String getProdutos(ModelMap model) {
        List<Produto> produtos = (List<Produto>) dao.findAll();

        model.addAttribute("produtos", produtos);
        System.out.println(produtos);
        return "produtos";
    }
}
