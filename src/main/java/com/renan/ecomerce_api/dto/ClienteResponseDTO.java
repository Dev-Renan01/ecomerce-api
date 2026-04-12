package com.renan.ecomerce_api.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.renan.ecomerce_api.model.Cliente;
import com.renan.ecomerce_api.model.Pedido;

import java.util.List;

@JsonPropertyOrder({"id", "nome", "cpf", "telefone"})
public class ClienteResponseDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String telefone;

    // O que será exibido da entidade Pedido
    private List<String> pedidos;

    public ClienteResponseDTO(){}

    public ClienteResponseDTO(Cliente cliente){
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.telefone = cliente.getTelefone();

        // Relacionamento controlado
        for(Pedido pedido : cliente.getPedidos()){
            this.pedidos.add("ID: " + pedido.getId() + " - " + pedido.getNomePedido());
        }
    }

    public Long getId(){
        return id;
    }

    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public String getTelefone() {
        return telefone;
    }
}
