package com.renan.ecomerce_api.controller;

import com.renan.ecomerce_api.dto.ClienteRequestDTO;
import com.renan.ecomerce_api.dto.ClienteResponseDTO;
import com.renan.ecomerce_api.model.Cliente;
import com.renan.ecomerce_api.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> save(@RequestBody ClienteRequestDTO dto) {
        Cliente cliente = new Cliente();

        cliente.setNome(dto.getNome());
        cliente.setCpf(dto.getCpf());
        cliente.setTelefone(dto.getTelefone());

        Cliente clienteSalvo = service.save(cliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ClienteResponseDTO(clienteSalvo));
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> findAll() {

        List<Cliente> clientes =  service.findAll();
        List<ClienteResponseDTO> lista = new ArrayList<>();

        for (Cliente registro : clientes) { // Cada registro de clientes será armazenado no "registro" e adicionado na lista (ClienteResponseDTO)
            lista.add(new ClienteResponseDTO(registro));
        }

        return ResponseEntity.ok(lista);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<ClienteResponseDTO> findById(@PathVariable Long id){
       Cliente cliente = service.findById(id);

       return ResponseEntity.ok().body(new ClienteResponseDTO(cliente));
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<ClienteResponseDTO> update(@PathVariable Long id, @RequestBody ClienteRequestDTO dto){
        Cliente cliente = new Cliente();
        
        cliente.setId(id);

        cliente.setNome(dto.getNome());
        cliente.setCpf(dto.getCpf());
        cliente.setTelefone(dto.getTelefone());

        Cliente clienteSalvo = service.update(cliente);

        return ResponseEntity.ok().body(new ClienteResponseDTO(clienteSalvo));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<ClienteResponseDTO> deletebyId(@PathVariable Long id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}