package com.develop.orcamentoapi.OrcamentoAPI.Services;

import com.develop.orcamentoapi.OrcamentoAPI.DTO.OrcamentoTempleteDTO;
import com.develop.orcamentoapi.OrcamentoAPI.Domain.Imposto;
import com.develop.orcamentoapi.OrcamentoAPI.Domain.Orcamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TemplateDeImpostoCondicionalServices extends Imposto {

    public boolean deveUsarMaximaTaxacao(Optional<Orcamento> orcamento) {
        return orcamento.get().getValor() >= 500;
    }
    public double maximaTaxacao(Optional<Orcamento> orcamento) {
        return orcamento.get().getValor() * 0.07;
    }

    public double minimaTaxacao(Optional<Orcamento> orcamento) {
        return orcamento.get().getValor() * 0.05;
    }



    public Optional<OrcamentoTempleteDTO> calc(){
        List<ItemTemplate> itens1 = new ArrayList<>();
        itens1.add(new ItemTemplate("Item A", 100.0));
        itens1.add(new ItemTemplate("Item B", 200.0));
        itens1.add(new ItemTemplate("Item C", 300.0));
        OrcamentoTemplate orcamento1 = new OrcamentoTemplate(itens1, 600.0);

        List<ItemTemplate> itens2 = new ArrayList<>();
        itens2.add(new ItemTemplate("Item A", 100.0));
        itens2.add(new ItemTemplate("Item A", 200.0));
        OrcamentoTemplate orcamento2 = new OrcamentoTemplate(itens2, 300.0);

        ImpostoTemplate ihit = new IHITExemple();
        double valorImposto1 = ihit.calcula(orcamento1);
        double valorImposto2 = ihit.calcula(orcamento2);
        com.develop.orcamentoapi.OrcamentoAPI.DTO.OrcamentoTempleteDTO orcamentoTempleteDTO = new com.develop.orcamentoapi.OrcamentoAPI.DTO.OrcamentoTempleteDTO();
        orcamentoTempleteDTO.setPrimeiroOrcamento(valorImposto1);
        orcamentoTempleteDTO.setSegundoOrcamento(valorImposto2);
        return Optional.of(orcamentoTempleteDTO);
    }


    public abstract class ImpostoTemplate {
        public double calcula(OrcamentoTemplate orcamento) {
            if (deveAplicarTaxaMaxima(orcamento)) {
                return taxaMaxima(orcamento);
            } else {
                return taxaMinima(orcamento);
            }
        }

        protected abstract boolean deveAplicarTaxaMaxima(OrcamentoTemplate orcamento);

        protected abstract double taxaMaxima(OrcamentoTemplate orcamento);

        protected abstract double taxaMinima(OrcamentoTemplate orcamento);
    }

    public class IHITExemple extends ImpostoTemplate {
        protected boolean deveAplicarTaxaMaxima(OrcamentoTemplate orcamento) {
            List<String> nomesItens = new ArrayList<>();
            for (ItemTemplate item : orcamento.getItensTemplate()) {
                if (nomesItens.contains(item.getNomeTemplate())) {
                    return true;
                }
                nomesItens.add(item.getNomeTemplate());
            }
            return false;
        }

        protected double taxaMaxima(OrcamentoTemplate orcamento) {
            return orcamento.getValor() * 0.13 + 100.0;
        }


        protected double taxaMinima(OrcamentoTemplate orcamento) {
            return orcamento.getValor() * 0.01 * orcamento.getItensTemplate().size();
        }
    }

    class OrcamentoTemplate {
        private final List<ItemTemplate> itens;
        private final double valor;

        public OrcamentoTemplate(List<ItemTemplate> itens, double valor) {
            this.itens = itens;
            this.valor = valor;
        }

        public List<ItemTemplate> getItensTemplate() {
            return itens;
        }

        public double getValor() {
            return valor;
        }
    }

    class ItemTemplate {
        private final String nome;
        private final double valor;

        public ItemTemplate(String nome, double valor) {
            this.nome = nome;
            this.valor = valor;
        }

        public String getNomeTemplate() {
            return nome;
        }

        public double getValor() {
            return valor;
        }
    }

}
