package com.develop.orcamentoapi.OrcamentoAPI.DTO;

public class OrcamentoDTO {

    public double Valor;

    public OrcamentoDTO(double valor) {
        Valor = valor;
    }

    public OrcamentoDTO() {
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double valor) {
        Valor = valor;
    }
}
