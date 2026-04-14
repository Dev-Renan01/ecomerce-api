package com.renan.ecomerce_api.service;

import com.renan.ecomerce_api.model.Pedido;
import com.renan.ecomerce_api.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    public Pedido save(Pedido pedido){
        return repository.save(pedido);
    }

    public List<Pedido> findAll(){
        return repository.findAll();
    }

    public Pedido findById(Long id){
        if(id == null){
            throw new RuntimeException("Informe um Id válido!");
        }

        return repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Pedido não encontrado"));
    }

    public Pedido update(Pedido pedido){
        Pedido salvar = findById(pedido.getId());

        salvar.setNomePedido(pedido.getNomePedido());
        salvar.setData(pedido.getData());
        salvar.setValorTotalPedido(pedido.getValorTotalPedido());
        salvar.setCliente(pedido.getCliente());

        return repository.save(salvar);
    }

    public void delete(Long id){

        Pedido pedido = findById(id);

        repository.delete(pedido);
    }
}