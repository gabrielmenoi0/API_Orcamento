package com.develop.orcamentoapi.OrcamentoAPI.Services;

import com.develop.orcamentoapi.OrcamentoAPI.Domain.Orcamento;
import org.springframework.stereotype.Service;

@Service
public class CalculoServices {
    public Double realizaCalculo(Orcamento orcamento, Double imposto){
        double valueSend = orcamento.Valor * (imposto/100);
        return valueSend;
    }
}
