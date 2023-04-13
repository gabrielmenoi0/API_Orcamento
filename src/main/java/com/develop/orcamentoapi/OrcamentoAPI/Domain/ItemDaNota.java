package com.develop.orcamentoapi.OrcamentoAPI.Domain;

public class ItemDaNota {
    public String nome;

    public ItemDaNota(String nome, Double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public ItemDaNota() {
    }

    public Double valor;
}
