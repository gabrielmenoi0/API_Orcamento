package com.develop.orcamentoapi.OrcamentoAPI.Services;

import com.develop.orcamentoapi.OrcamentoAPI.Domain.*;
import com.develop.orcamentoapi.OrcamentoAPI.Repository.OrcamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrcamentoServices {

    @Autowired
    private OrcamentoRepository orcamentoRepository;

    public ResponseCalculoTotal realizaCalculoTotal(Orcamento orcamento, ICMS icms, PIS pis, COFINS cofins, ISS iss) {
        double porcent = porcent(icms, pis, cofins, iss);
        double valueSend = orcamento.Valor * porcent;
        ResponseCalculoTotal response = new ResponseCalculoTotal();
        response.setImposto(porcent * 100);
        response.setValor(orcamento.getValor() + valueSend);
        return response;
    }

    public double porcent(ICMS icms, PIS pis, COFINS cofins, ISS iss) {
        double valuePorcent = (icms.getValor() / 100 + pis.getValor() / 100 + cofins.getValor() / 100 + iss.getValor() / 100);
        return valuePorcent;
    }

    public Optional<Orcamento> findById(UUID id) {
        return orcamentoRepository.findById(id);
    }

    public List<Orcamento> findAll() {
        return orcamentoRepository.findAll();
    }

    public Orcamento save(Orcamento orcamento){
        return orcamentoRepository.save(orcamento);
    }
    public Orcamento alter(UUID id, String states){
        Optional<Orcamento> orcamento = orcamentoRepository.findById(id);
        Orcamento updated = new Orcamento();
        updated.setState(states);
        updated.setValorImpostos(orcamento.get().ValorImpostos);
        updated.setId(id);
        updated.setValor(orcamento.get().getValor());
        return orcamentoRepository.save(updated);
    }

    public void delete(Orcamento url){
        orcamentoRepository.delete(url);
    }
    public void deletebyid(UUID id){
        orcamentoRepository.deleteById(id);
    }
}
