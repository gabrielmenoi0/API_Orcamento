package com.develop.orcamentoapi.OrcamentoAPI.Domain;

import java.time.LocalDateTime;

public class NotaFiscalAdapter {
    private  String empresa;
    private  String cnpj;
    private  double valorTotal;
    private  double valorImpostos;
    private  double subTotal;
    private  LocalDateTime data;
    private  String observacoes;

    public NotaFiscalAdapter(String empresa, String cnpj, double valorTotal, double valorImpostos,  double subTotal, LocalDateTime data, String observacoes) {
        this.empresa = empresa;
        this.cnpj = cnpj;
        this.valorTotal = valorTotal;
        this.subTotal = subTotal;
        this.valorImpostos = valorImpostos;
        this.data = data;
        this.observacoes = observacoes;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorImpostos() {
        return valorImpostos;
    }

    public void setValorImpostos(double valorImpostos) {
        this.valorImpostos = valorImpostos;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}

