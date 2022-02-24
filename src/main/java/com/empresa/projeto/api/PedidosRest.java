package com.empresa.projeto.api;

import com.empresa.projeto.controller.PedidoRepository;
import com.empresa.projeto.model.Pedido;
import com.empresa.projeto.model.StatusPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosRest {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("aguardando")
    public List<Pedido> getPedidosAguardandoOfertas() {
        Sort sort = Sort.by("id").descending();
        PageRequest pagination = PageRequest.of(0, 10, sort);
        return pedidoRepository.findByStatus(StatusPedido.AGUARDANDO, pagination);
    }

}
