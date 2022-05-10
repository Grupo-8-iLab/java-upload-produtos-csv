package com.bolinho.uploadcsv.services;

import java.util.List;

import com.bolinho.uploadcsv.models.Cliente;

public interface IClienteService {
    public List<Cliente> getAll();
    public Cliente getOne(Integer id);
    public Cliente postOne(Cliente cli);
    public Cliente editOne(Integer id, Cliente cli);
    public boolean deleteOne(Integer id);
    
}
