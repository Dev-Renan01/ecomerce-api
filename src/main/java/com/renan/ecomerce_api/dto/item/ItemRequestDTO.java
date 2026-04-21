package com.renan.ecomerce_api.dto.item;

public class ItemRequestDTO {

    private String quantidade;
    private String precoUnitario;

    private Long pedidoId; // chave do relacionamento

    public ItemRequestDTO() {}

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
}