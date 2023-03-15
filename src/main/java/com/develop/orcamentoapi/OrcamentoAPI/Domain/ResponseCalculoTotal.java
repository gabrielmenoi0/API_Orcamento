package com.develop.orcamentoapi.OrcamentoAPI.Domain;
import javax.persistence.Entity;

public class ResponseCalculoTotal {
    private Double imposto;
    private Double valor;

    public ResponseCalculoTotal(Double imposto, Double valor) {
        this.imposto = imposto;
        this.valor = valor;
    }

    public Double getImposto() {
        return imposto;
    }

    public void setImposto(Double imposto) {
        this.imposto = imposto;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public ResponseCalculoTotal() {
    }
}

