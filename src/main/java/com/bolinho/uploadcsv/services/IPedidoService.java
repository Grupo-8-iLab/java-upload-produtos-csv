package com.bolinho.uploadcsv.services;

import java.util.List;

import com.bolinho.uploadcsv.models.Pedido;

public interface IPedidoService {
    public List<Pedido> getAll();
    public Pedido getOne(Integer id);
    public Pedido postOne(Pedido pedido);
    public Pedido editOne(Integer id, Pedido pedido);
    public boolean deleteOne(Integer id);
}
