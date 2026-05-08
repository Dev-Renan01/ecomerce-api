package com.renan.ecomerce_api.controller;

import com.renan.ecomerce_api.dto.item.ItemRequestDTO;
import com.renan.ecomerce_api.dto.item.ItemResponseDTO;
import com.renan.ecomerce_api.model.Item;
import com.renan.ecomerce_api.model.Pedido;
import com.renan.ecomerce_api.service.ItemService;
import com.renan.ecomerce_api.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {


    @Autowired
    private ItemService itemService;

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<ItemResponseDTO> save(@RequestBody ItemRequestDTO dto){
        Item item = new Item();

        item.setQuantidade(dto.getQuantidade());
        item.setPrecoUnitario(dto.getPrecoUnitario());

        Pedido pedido = pedidoService.findById(dto.getPedidoId());
        item.setPedido(pedido);

        Item salvar = itemService.save(item);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ItemResponseDTO(salvar));
    }

    @GetMapping
    public ResponseEntity<List<ItemResponseDTO>> findAll(){

        List<Item> item = itemService.findAll();
        List<ItemResponseDTO> lista = new ArrayList<>();

        for(Item i : item){
            lista.add(new ItemResponseDTO(i));
        }
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<ItemResponseDTO> findById(@PathVariable Long id){
        Item item = itemService.findbyId(id);

        return ResponseEntity.ok().body(new ItemResponseDTO(item));
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<ItemResponseDTO> update(@PathVariable Long id, @RequestBody ItemRequestDTO dto){
        Item item = new Item();
        item.setId(id);

        item.setQuantidade(dto.getQuantidade());
        item.setPrecoUnitario(dto.getPrecoUnitario());

        Pedido pedido = pedidoService.findById(dto.getPedidoId());
        item.setPedido(pedido);

        Item salvar = itemService.update(item);

        return ResponseEntity.ok().body(new ItemResponseDTO(salvar));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        delete(id);

        return ResponseEntity.noContent().build();
    }










}
