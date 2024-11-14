package br.com.mvc.mudi.controller;


import br.com.mvc.mudi.model.Pedido;
import br.com.mvc.mudi.model.StatusPedido;
import br.com.mvc.mudi.repository.PedidoRepository;
import br.com.mvc.mudi.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/home")
public class HomeController {

    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private PedidoService services;

    public HomeController(PedidoService services) {
        this.services = services;
    }
    @Autowired
    private PedidoService service;

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping
    public String home(Model model) {
        List<Pedido> pedidos = services.findAll();
        model.addAttribute("pedidos", pedidos);
        return "home";
    }

    @GetMapping("/{status}")
    public String porStatus(@PathVariable("status") String status, Model model) {

        List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.valueOf(status.toUpperCase(Locale.ROOT)));
        model.addAttribute("pedidos", pedidos);
        model.addAttribute("status", status);
        return "home";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError() {
        return "redirect:/home";
    }
}
