package com.develop.orcamentoapi.OrcamentoAPI.Domain;

public class Desconto {
    private Integer quantidade;

    public Desconto(Integer quantidade, Double valorDesconto) {
        this.quantidade = quantidade;
        this.valorDesconto = valorDesconto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
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
