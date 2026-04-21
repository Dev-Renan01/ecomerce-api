package com.renan.ecomerce_api.dto.pedido;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.renan.ecomerce_api.model.Item;
import com.renan.ecomerce_api.model.Pedido;

import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder({"id", "nomePedido", "data", "valorTotalPedido",
        "clienteId", "nomeCliente", "telefoneCliente", "itens"})
public class PedidoResponseDTO{

    private Long id;
    private String nomePedido;
    private String data;
    private String valorTotalPedido;

    // O que será exibido da entidade cliente
    private Long clienteId;
    private String nomeCliente;
    private String telefoneCliente;

    // O que será exibido da entidade Item
    private List<String> itens;



    public PedidoResponseDTO (Pedido pedido){
        this.id = pedido.getId();
        this.nomePedido = pedido.getNomePedido();
        this.data = pedido.getData();
        this.valorTotalPedido = pedido.getValorTotalPedido();

        // Relacionamento controlado com Cliente

        if(pedido.getCliente() != null) {
            this.clienteId = pedido.getCliente().getId();
            this.nomeCliente = pedido.getCliente().getNome();
            this.telefoneCliente = pedido.getCliente().getTelefone();
        }

        // Relacionamento controlado com Item
        this.itens = new ArrayList<>();
        if(pedido.getItens() != null){
            for(Item item : pedido.getItens()){
                itens.add("Id: " + item.getId()
                        + " | Quantidade: " + item.getQuantidade()
                        + " | Preço por unidade: " + item.getPrecoUnitario());
            }

        }
    }

    public PedidoResponseDTO(){}

    public List<String> getItens() {
        return itens;
    }

    public void setItens(List<String> itens) {
        this.itens = itens;
    }

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
