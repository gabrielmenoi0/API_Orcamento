package com.develop.orcamentoapi.OrcamentoAPI.Services;

import com.develop.orcamentoapi.OrcamentoAPI.Domain.Orcamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StateServices {
    @Autowired
    public OrcamentoServices orcamentoServices;
    public enum States{
        EM_APROVACAO,
        APROVADO,
        REPROVADO,
        FINALIZADO
    }
    public States checkState(States states){
        return states;
    }
    public Orcamento alterState(String states, UUID id){
        Orcamento orcamento = new Orcamento();
        orcamento = orcamentoServices.alter(id,states);
        return orcamento;
    }
}
