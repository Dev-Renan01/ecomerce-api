package com.renan.ecomerce_api.dto.pedido;

import com.renan.ecomerce_api.model.Pedido;

public class PedidoResponseDTO{

    private Long id;
    private String nomePedido;
    private String data;
    private String valorTotalPedido;

    // O que será exibido da entidade cliente
    private Long clienteId;
    private String nomeCliente;
    private String telefoneCliente;


    public PedidoResponseDTO (Pedido pedido){
        this.id = pedido.getId();
        this.nomePedido = pedido.getNomePedido();
        this.data = pedido.getData();
        this.valorTotalPedido = pedido.getValorTotalPedido();

        // Relacionamento controlado

        if(pedido.getCliente() != null) {
            this.clienteId = pedido.getCliente().getId();
            this.nomeCliente = pedido.getCliente().getNome();
            this.telefoneCliente = pedido.getCliente().getTelefone();
        }
    }

    public PedidoResponseDTO(){}

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

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }
}
