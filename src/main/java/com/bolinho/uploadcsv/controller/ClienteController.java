package com.bolinho.uploadcsv.controller;

import com.bolinho.uploadcsv.dao.ClienteDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ClienteController {
    @Autowired
    private ClienteDAO cliDao;

    @GetMapping("/clientes")
    public String getClientes(ModelMap model) {
        List<Produto> produtos = (List<Produto>) dao.findAll();

        model.addAttribute("produtos", produtos);
        System.out.println(produtos);
        return "telaDados";
    }
}
