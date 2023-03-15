package com.develop.orcamentoapi.OrcamentoAPI.Domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "tb_imposto")
public class Imposto {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @org.hibernate.annotations.Type(type="uuid-char")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;
    public Double valor;

    public Imposto() {
    }

    public Imposto(UUID id, Double valor) {
        this.id = id;
        this.valor = valor;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
