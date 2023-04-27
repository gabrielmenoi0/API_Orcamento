package com.develop.orcamentoapi.OrcamentoAPI.Domain;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "tb_nota")
public class NotaFiscalBuilder {
    private String razaoSocial;
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @org.hibernate.annotations.Type(type="uuid-char")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String UUID;
//        private String razaoSocial;
        private String cnpj;
        private double valorTotal;
        private double impostos;
        private LocalDateTime data;
        private String observacoes;

        private NotaFiscalBuilder(String razaoSocial, String cnpj, double valorTotal, double impostos, LocalDateTime data, String observacoes) {
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

        public static class Builder {

            private String razaoSocial;
            private String cnpj;
            private double valorTotal;
            private double impostos;
            private LocalDateTime data;
            private String observacoes;

            public Builder comRazaoSocial(String razaoSocial) {
                this.razaoSocial = razaoSocial;
                return this;
            }

            public Builder comCnpj(String cnpj) {
                this.cnpj = cnpj;
                return this;
            }

            public Builder comValorTotal(double valorTotal) {
                this.valorTotal = valorTotal;
                return this;
            }

            public Builder comImpostos(double impostos) {
                this.impostos = impostos;
                return this;
            }

            public Builder comData(LocalDateTime data) {
                this.data = data;
                return this;
            }

            public Builder comObservacoes(String observacoes) {
                this.observacoes = observacoes;
                return this;
            }

            public NotaFiscalBuilder build() {
                return new NotaFiscalBuilder(razaoSocial, cnpj, valorTotal, impostos, data, observacoes);
            }
        }
    }