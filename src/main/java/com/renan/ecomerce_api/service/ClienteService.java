package com.renan.ecomerce_api.service;

import com.renan.ecomerce_api.model.Cliente;
import com.renan.ecomerce_api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente save(Cliente cliente){
        return repository.save(cliente);
    }

    public List<Cliente> findAll(){
        return repository.findAll();
    }

    public Cliente findById(Long id){
        if(id == null){
            throw new RuntimeException("informe um id válido");
        }

        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));

    }

    public Cliente update(Cliente cliente){

        if(cliente.getId() == null){
            throw new RuntimeException("informe um id válido!");
        }
        Cliente clienteExistente = repository.findById(cliente.getId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));

        clienteExistente.setNome(cliente.getNome());
        clienteExistente.setCpf(cliente.getCpf());
        clienteExistente.setTelefone(cliente.getTelefone());

        return repository.save(clienteExistente);
    }

    public void delete(Long id){
        if(id == null){
            throw new RuntimeException("Informe um id válido!");
        }

        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));

        repository.delete(cliente);
    }
}