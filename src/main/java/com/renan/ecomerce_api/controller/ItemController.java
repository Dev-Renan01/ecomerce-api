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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    










}
