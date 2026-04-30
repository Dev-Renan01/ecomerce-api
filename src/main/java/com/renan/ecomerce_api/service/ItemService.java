package com.renan.ecomerce_api.service;

import com.renan.ecomerce_api.model.Item;
import com.renan.ecomerce_api.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository repository;

    public Item save(Item item){
        return repository.save(item);
    }

    public List<Item> findAll(){
        return repository.findAll();
    }

    public Item findbyId(Long id){

        if(id == null){
            throw new RuntimeException("Informe um id válido!");
        }
        return repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Item não encontrado!"));
    }

    public Item update(Item item){

       Item salvar =  findbyId(item.getId());

       salvar.setPedido(item.getPedido());
       salvar.setQuantidade(item.getQuantidade());
       salvar.setPrecoUnitario(item.getPrecoUnitario());

        return repository.save(item);
    }

    public void delete(Long id){
     Item item = findbyId(id);

    repository.delete(item);
    }
}