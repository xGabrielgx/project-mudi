package br.com.mvc.mudi.controller;

import br.com.mvc.mudi.dto.RequisicaoNovoPedido;
import br.com.mvc.mudi.model.Pedido;
import br.com.mvc.mudi.repository.PedidoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("pedido") // mapea todos tipos de requisição
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("/formulario")
    public String formulario(RequisicaoNovoPedido requisicao) {
        return "pedido/formulario";
    }

    @PostMapping("/novo")
    // para receber uma requisição os atributos precisam ser o mesmo do formulario.html onde fica o input name="";
    public String novo(@Valid RequisicaoNovoPedido requisicao, BindingResult result) {

        if(result.hasErrors()) {
            return "pedido/formulario";
        }

        Pedido pedido = requisicao.toPedido();
        pedidoRepository.save(pedido);
        return "redirect:/home";
    }

}
