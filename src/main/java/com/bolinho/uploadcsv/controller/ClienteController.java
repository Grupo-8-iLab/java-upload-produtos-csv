package com.bolinho.uploadcsv.controller;

import java.util.List;
import java.util.Set;

import com.bolinho.uploadcsv.models.Cliente;
import com.bolinho.uploadcsv.services.IClienteService;
import com.bolinho.uploadcsv.services.RedisService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ClienteController {

    @Autowired
    private IClienteService service;

    @GetMapping("/clientes")
    public String getClientes(ModelMap model) {
        RedisService redisService = new RedisService();
        System.out.println("Ver o que imprime do redis: ");

        Set<String> clientesRedis = redisService.read();
        if (clientesRedis.isEmpty()) {
            redisService.setDataInRedis(service.getAll());
        }
        List<String> lista = List.copyOf(clientesRedis);
        System.out.println(lista);

        List<Cliente> clientes = service.getAll();
        model.addAttribute("clientes", clientes);

        return "listarClientes";
    }

    @GetMapping("/clientesAll")
    @ResponseBody
    public List<Cliente> getClientesInfo() {
        List<Cliente> clientes = service.getAll();
        return clientes;
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
        return "cadastrarCliente";
    }
}
