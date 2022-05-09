package com.bolinho.uploadcsv.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "valor_total")
    private Double valorTotal;
    @Column(name = "data")
    private Timestamp data;
    @ManyToOne
	@JoinColumn(name = "id_cliente")
    private Cliente cliente;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
    public Timestamp getData() {
        return data;
    }
    public void setData(Timestamp data) {
        this.data = data;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
}
