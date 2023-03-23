package com.develop.orcamentoapi.OrcamentoAPI.Domain;

import com.develop.orcamentoapi.OrcamentoAPI.Services.StateServices;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_orcamento")
public class Orcamento {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @org.hibernate.annotations.Type(type="uuid-char")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    public double Valor;
    public double ValorImpostos;
    public String state;
    public Integer qtd;

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public double getValorImpostos() {
        return ValorImpostos;
    }

    public void setValorImpostos(double valorImpostos) {
        ValorImpostos = valorImpostos;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Orcamento(UUID id, double valor, double valorImpostos, String state,Integer qtd) {
        this.id = id;
        this.Valor = valor;
        this.ValorImpostos = valorImpostos;
        this.qtd = qtd;
        this.state = state;
    }

    public Orcamento() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orcamento orcamento = (Orcamento) o;
        return Double.compare(orcamento.Valor, Valor) == 0 && Double.compare(orcamento.ValorImpostos, ValorImpostos) == 0 && id.equals(orcamento.id) && state.equals(orcamento.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Valor, ValorImpostos, state);
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double valor) {
        Valor = valor;
    }
}
