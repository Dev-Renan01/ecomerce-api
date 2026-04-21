package com.renan.ecomerce_api.dto.item;

import com.renan.ecomerce_api.model.Item;

public class ItemResponseDTO {

    private Long id;
    private String quantidade;
    private String precoUnitario;

    // O que será exibido da entidade pedido
    private Long pedidoId;
    private String nomePedido;


    public ItemResponseDTO(Item item){
        this.id = item.getId();
        this.quantidade = item.getQuantidade();
        this.precoUnitario = item.getPrecoUnitario();

        // Relacionamento controlado com Pedido
        if(item.getPedido() != null){
           this.pedidoId = item.getPedido().getId();
           this.nomePedido = item.getPedido().getNomePedido();
        }
    }

    public ItemResponseDTO(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(String precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public String getNomePedido() {
        return nomePedido;
    }

    public void setNomePedido(String nomePedido) {
        this.nomePedido = nomePedido;
    }
}
