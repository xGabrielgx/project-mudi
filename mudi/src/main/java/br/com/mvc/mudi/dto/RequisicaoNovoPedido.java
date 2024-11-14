package br.com.mvc.mudi.dto;

import br.com.mvc.mudi.model.Pedido;
import br.com.mvc.mudi.model.StatusPedido;
import jakarta.validation.constraints.NotBlank;

public class RequisicaoNovoPedido {

    @NotBlank
    private String nomeProduto;

    @NotBlank
    private String urlProduto;

    @NotBlank
    private String urlImage;
    private String descricao;



    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getUrlProduto() {
        return urlProduto;
    }

    public void setUrlProduto(String urlProduto) {
        this.urlProduto = urlProduto;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Pedido toPedido() {
        Pedido pedido = new Pedido();
        pedido.setDescricao(descricao);
        pedido.setUrlImage(urlImage);
        pedido.setNomeProduto(nomeProduto);
        pedido.setUrlProduto(urlProduto);
        pedido.setStatus(StatusPedido.AGUARDANDO);
        return pedido;
    }
}
