package com.bolinho.uploadcsv.services;

import java.util.List;

import com.bolinho.uploadcsv.dao.PedidoDAO;
import com.bolinho.uploadcsv.models.Pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PedidoServiceImpl implements IPedidoService{

    @Autowired
    private PedidoDAO dao;

    @Override
    public List<Pedido> getAll() {
        return (List<Pedido>) dao.findAll();
    }

    @Override
    public Pedido getOne(Integer id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public Pedido postOne(Pedido pedido) {
        //fazer implementação certa aqui
        return dao.save(pedido);
    }

    @Override
    public Pedido editOne(Integer id, Pedido pedido) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean deleteOne(Integer id) {
        Pedido pedido = this.getOne(id);
		
		if(pedido == null) return false;
		
		dao.deleteById(id);
		return true;
    }
    
}
