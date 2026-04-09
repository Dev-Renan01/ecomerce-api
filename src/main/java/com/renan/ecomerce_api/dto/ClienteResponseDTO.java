package com.renan.ecomerce_api.dto;

import com.renan.ecomerce_api.model.Cliente;

public class ClienteResponseDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String telefone;

    public ClienteResponseDTO(){}

    public ClienteResponseDTO(Cliente cliente){
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.telefone = cliente.getTelefone();
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
