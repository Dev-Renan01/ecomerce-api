package com.renan.ecomerce_api.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nomePedido;

    @Column(nullable = false)
    private String data;

    @Column(nullable = false)
    private String valorTotalPedido;

    // Relecionamento com a entidade - Cliente
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    // Relacionamento coma a entidade - Item
    @OneToMany(mappedBy = "pedido")
    private List<Item> itens;

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public Pedido(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomePedido() {
        return nomePedido;
    }

    public void setNomePedido(String nomePedido) {
        this.nomePedido = nomePedido;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getValorTotalPedido() {
        return valorTotalPedido;
    }

    public void setValorTotalPedido(String valorTotalPedido) {
        this.valorTotalPedido = valorTotalPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
