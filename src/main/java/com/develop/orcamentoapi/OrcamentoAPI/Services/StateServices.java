package com.develop.orcamentoapi.OrcamentoAPI.Services;

import org.springframework.stereotype.Service;

@Service
public class StateServices {
    public enum States{
        EM_APROVACAO,
        APROVADO,
        REPROVADO,
        FINALIZADO
    }
    public States checkState(States states){
        return states;
    }
}
