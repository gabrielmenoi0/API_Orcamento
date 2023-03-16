package com.develop.orcamentoapi.OrcamentoAPI.Services;

import com.develop.orcamentoapi.OrcamentoAPI.Domain.*;
import org.springframework.stereotype.Service;

@Service
public class DescontoServices {
    public Double calculo(Orcamento orcamento, Desconto desconto){
        if (desconto.getQuantidade() > 5) {
            return calculaDesconto5itens(orcamento,desconto);
        }
        else if (orcamento.getValor() > 500.00) {
            return calculaDesconto500Valor(orcamento,desconto);
        } else {
            return calculaSemDesconto(orcamento,desconto);
        }
    }
    public Double calculoRecursivo(Orcamento orcamento, Desconto desconto, Integer qtd){
        int number = qtd;
        if (number == 1) return calculo(orcamento, desconto);
        return calculoRecursivo(orcamento, desconto,number -1);
    }

    public Double calculaDesconto5itens(Orcamento orcamento, Desconto desconto){
        double valueAll = orcamento.getValor();
        double valordesconto = (0.10 * valueAll) ;
        return valordesconto;
    }
    public Double calculaDesconto500Valor(Orcamento orcamento, Desconto desconto){
        double valueAll = orcamento.getValor() ;
        double valordesconto = (0.07 * valueAll);
        return valordesconto;
    }
    public Double calculaSemDesconto(Orcamento orcamento, Desconto desconto){
        return 0.00;
    }
}
