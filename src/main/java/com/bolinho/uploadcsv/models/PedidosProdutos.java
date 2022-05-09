package com.bolinho.uploadcsv.models;

import javax.persistence.*;

@Entity
@Table(name = "pedidos_produtos")
public class PedidosProdutos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @ManyToOne
	@JoinColumn(name = "id_pedido")
    private Pedido pedido;
    @ManyToOne
	@JoinColumn(name = "id_produto")
    private Produto produto;
    @Column(name = "qtd_produto")
    private Integer qtdProduto;
    @Column(name = "preco_unit")
    private Double precoUnit;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Pedido getPedido() {
        return pedido;
    }
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public Integer getQtdProduto() {
        return qtdProduto;
    }
    public void setQtdProduto(Integer qtdProduto) {
        this.qtdProduto = qtdProduto;
    }
    public Double getPrecoUnit() {
        return precoUnit;
    }
    public void setPrecoUnit(Double precoUnit) {
        this.precoUnit = precoUnit;
    }

    
}
