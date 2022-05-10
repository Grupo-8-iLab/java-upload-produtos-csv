package com.bolinho.uploadcsv.controller;

import com.bolinho.uploadcsv.models.Pedido;
import com.bolinho.uploadcsv.services.IPedidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class PedidoController {

    @Autowired
    private IPedidoService service;

    @PostMapping("/pedido")
    public String fazerPedido(@RequestBody Pedido p, Model model) {
        service.postOne(p);
        // adicionar no elastic search
        return "mensagem";
    }

}
