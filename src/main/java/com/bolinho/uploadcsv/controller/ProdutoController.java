package com.bolinho.uploadcsv.controller;

import java.io.IOException;
import java.util.List;

import com.bolinho.uploadcsv.dao.ProdutoDAO;
import com.bolinho.uploadcsv.elasticSearch.RestService;
import com.bolinho.uploadcsv.models.Produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("/produtosAll")
    @ResponseBody
    public List<Produto> getClientesInfo() {
        List<Produto> produtos = (List<Produto>) dao.findAll();
        return produtos;
    }

    @GetMapping("/produtosElastic")
    public String getProdutosElastic(ModelMap model) throws IOException {
        List<Produto> produtos = RestService.getList();
        model.addAttribute("produtos", produtos);
        return "produtos";
    }

}
