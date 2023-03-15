package com.develop.orcamentoapi.OrcamentoAPI.Services;

import com.develop.orcamentoapi.OrcamentoAPI.Domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrcamentoServices {
    public ResponseCalculoTotal realizaCalculoTotal(Orcamento orcamento, ICMS icms, PIS pis, COFINS cofins, ISS iss){
        double porcent =  porcent(icms,pis,cofins,iss);
        double valueSend = orcamento.Valor * porcent;
        ResponseCalculoTotal response = new ResponseCalculoTotal();
        response.setImposto(porcent*100);
        response.setValor(orcamento.getValor() + valueSend);
        return response;
    }
    public double porcent(ICMS icms, PIS pis, COFINS cofins, ISS iss){
        double valuePorcent = (icms.getValor() /100 + pis.getValor() /100  + cofins.getValor() /100 + iss.getValor() /100 );
        return valuePorcent;
    }
}
