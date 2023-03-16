package com.develop.orcamentoapi.OrcamentoAPI.Domain;

public class Desconto {
    private Double quantidade;

    public Desconto(Double quantidade, Double valorDesconto) {
        this.quantidade = quantidade;
        this.valorDesconto = valorDesconto;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(Double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public Desconto() {
    }

    private Double valorDesconto;

}
