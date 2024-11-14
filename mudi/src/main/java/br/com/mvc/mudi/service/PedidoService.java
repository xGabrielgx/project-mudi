package br.com.mvc.mudi.service;


import br.com.mvc.mudi.model.Pedido;
import br.com.mvc.mudi.model.StatusPedido;
import br.com.mvc.mudi.repository.PedidoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    @PersistenceContext
    private EntityManager entityManager;


    // exemplo de INJEÇÃO DE DEPEDÊNCIA
    private PedidoRepository pedido;

    public PedidoService(PedidoRepository pedido) {
        this.pedido = pedido;
    }
//    @Autowired
//    private PedidoRepository pedidoRepository;

    public List<Pedido> findAll() {
        return pedido.findAll();
    }

}
