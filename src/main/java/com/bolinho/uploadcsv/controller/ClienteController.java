package com.bolinho.uploadcsv.controller;

import java.util.List;

import com.bolinho.uploadcsv.models.Cliente;
import com.bolinho.uploadcsv.services.IClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClienteController {

    @Autowired
    private IClienteService service;

    @GetMapping("/clientes")
    public String getClientes(ModelMap model) {
        List<Cliente> clientes = service.getAll();

        model.addAttribute("clientes", clientes);

        return "telaDados";
    }

    @PostMapping("/clientes")
    public String postClient(Cliente cliente, Model model) {
        try {
            service.postOne(cliente);
            model.addAttribute("message", "Cliente cadastrado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "Erro ao salvar cliente: " + e.getMessage());
        }
        return "cliente";
    }
}
