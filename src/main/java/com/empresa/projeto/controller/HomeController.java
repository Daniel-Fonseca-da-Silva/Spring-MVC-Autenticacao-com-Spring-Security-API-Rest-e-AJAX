package com.empresa.projeto.controller;

import com.empresa.projeto.model.Pedido;
import com.empresa.projeto.model.StatusPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private PedidoRepository pedidoRepository;


    @GetMapping
    public String home(Model model, Principal principal) {

        Sort sort = Sort.by("dataEntrega").descending();
        PageRequest pagination = PageRequest.of(0, 10, sort);

        List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.ENTREGUE, pagination);
        model.addAttribute("pedidos", pedidos);
        return "home";
    }

}
