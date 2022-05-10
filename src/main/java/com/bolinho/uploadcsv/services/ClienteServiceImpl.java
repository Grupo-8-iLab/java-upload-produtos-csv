package com.bolinho.uploadcsv.services;

import java.util.List;

import com.bolinho.uploadcsv.dao.ClienteDAO;
import com.bolinho.uploadcsv.models.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteServiceImpl implements IClienteService{
    @Autowired
    private ClienteDAO dao;

    @Override
    public List<Cliente> getAll() {
        return (List<Cliente>) dao.findAll();
    }
    @Override
    public Cliente getOne(Integer id) {
		return dao.findById(id).orElse(null);
	}

    @Override
    public Cliente postOne(Cliente cli) {
        return dao.save(cli);
    }

    @Override
	public Cliente editOne(Integer id, Cliente cli) {
		Cliente clienteBanco = this.getOne(id);

		if (clienteBanco == null)
			return null;

		cli.setId(id);
		dao.save(cli);
		return cli;
	}

    @Override
    public boolean deleteOne(Integer id) {
        Cliente cli = this.getOne(id);
		
		if(cli == null) return false;
		
		dao.deleteById(id);
		return true;
    }

}
