package com.develop.orcamentoapi.OrcamentoAPI.DTO;

public class OrcamentoTempleteDTO {
    public double primeiroOrcamento;
    public double segundoOrcamento;


    public OrcamentoTempleteDTO(double primeiroOrcamento, double segundoOrcamento) {
        this.primeiroOrcamento = primeiroOrcamento;
        this.segundoOrcamento = segundoOrcamento;
    }

    public OrcamentoTempleteDTO() {
    }

    public double getPrimeiroOrcamento() {
        return primeiroOrcamento;
    }

    public void setPrimeiroOrcamento(double primeiroOrcamento) {
        this.primeiroOrcamento = primeiroOrcamento;
    }

    public double getSegundoOrcamento() {
        return segundoOrcamento;
    }

    public void setSegundoOrcamento(double segundoOrcamento) {
        this.segundoOrcamento = segundoOrcamento;
    }

}
