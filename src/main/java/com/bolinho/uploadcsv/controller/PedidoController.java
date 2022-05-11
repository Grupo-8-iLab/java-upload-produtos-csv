package com.bolinho.uploadcsv.controller;

import com.bolinho.uploadcsv.models.Pedido;
import com.bolinho.uploadcsv.services.IPedidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PedidoController {

    @Autowired
    private IPedidoService service;

    @PostMapping("/pedido")
    @ResponseBody
    public String fazerPedido(@RequestBody Pedido p, Model model) {
        service.postOne(p);
        // response in json
        String json = "{\"message\":\"Pedido realizado com sucesso!\"}";
        return json;
    }

}
