package com.renan.ecomerce_api.controller;

import com.renan.ecomerce_api.dto.pedido.PedidoRequestDTO;
import com.renan.ecomerce_api.dto.pedido.PedidoResponseDTO;
import com.renan.ecomerce_api.model.Cliente;
import com.renan.ecomerce_api.model.Pedido;
import com.renan.ecomerce_api.service.ClienteService;
import com.renan.ecomerce_api.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<PedidoResponseDTO> save(@RequestBody PedidoRequestDTO dto){

        Pedido pedido = new Pedido();

        pedido.setNomePedido(dto.getNomePedido());
        pedido.setData(dto.getData());
        pedido.setValorTotalPedido(dto.getValorTotalPedido());

        Cliente cliente = clienteService.findById(dto.getClienteId());
        pedido.setCliente(cliente);

        Pedido salvar = pedidoService.save(pedido);

        return ResponseEntity.status(HttpStatus.CREATED).body( new PedidoResponseDTO(salvar));
    }

    @GetMapping
    public ResponseEntity<List<PedidoResponseDTO>> findAll(){
        List<Pedido> pedidos = pedidoService.findAll();

        List<PedidoResponseDTO> lista = new ArrayList<>();

        for(Pedido pedido : pedidos){
            lista.add(new PedidoResponseDTO(pedido));
        }

        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PedidoResponseDTO> findById(@PathVariable Long id){
         Pedido pedido = pedidoService.findById(id);

         return ResponseEntity.ok().body(new PedidoResponseDTO(pedido));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PedidoResponseDTO> update(@PathVariable Long id, @RequestBody PedidoRequestDTO dto){
        Pedido pedido = new Pedido();
        pedido.setId(id);

        pedido.setNomePedido(dto.getNomePedido());
        pedido.setData(dto.getData());
        pedido.setValorTotalPedido(dto.getValorTotalPedido());

        Cliente cliente = clienteService.findById(dto.getClienteId());
        pedido.setCliente(cliente);

        Pedido salvar = pedidoService.update(pedido);

        return ResponseEntity.ok().body(new PedidoResponseDTO(salvar));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){

        pedidoService.delete(id);
        return ResponseEntity.noContent().build();

    }

}
