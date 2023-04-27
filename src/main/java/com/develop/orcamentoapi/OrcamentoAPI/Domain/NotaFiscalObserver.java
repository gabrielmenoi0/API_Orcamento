package com.develop.orcamentoapi.OrcamentoAPI.Domain;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Table(name = "tb_notaObserver")
public class NotaFiscalObserver {

    private String razaoSocial;
    private String cnpj;
    private double valorTotal;
    private double impostos;

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setImpostos(double impostos) {
        this.impostos = impostos;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }

    private LocalDateTime data;
    private String observacoes;

    private List<Observer> observers = new ArrayList<>();

    public NotaFiscalObserver(String razaoSocial, String cnpj, double valorTotal, double impostos, LocalDateTime data, String observacoes) {
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.valorTotal = valorTotal;
        this.impostos = impostos;
        this.data = data;
        this.observacoes = observacoes;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public double getImpostos() {
        return impostos;
    }

    public LocalDateTime getData() {
        return data;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    public static interface Observer {
        public void update(NotaFiscalObserver notaFiscal);
    }

}

