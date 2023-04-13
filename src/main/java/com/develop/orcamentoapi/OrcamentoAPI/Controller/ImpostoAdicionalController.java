package com.develop.orcamentoapi.OrcamentoAPI.Controller;

import com.develop.orcamentoapi.OrcamentoAPI.DTO.OrcamentoTempleteDTO;
import com.develop.orcamentoapi.OrcamentoAPI.Domain.*;
import com.develop.orcamentoapi.OrcamentoAPI.Repository.OrcamentoRepository;
import com.develop.orcamentoapi.OrcamentoAPI.Services.OrcamentoServices;
import com.develop.orcamentoapi.OrcamentoAPI.Services.TemplateDeImpostoCondicionalServices;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
public class ImpostoAdicionalController {
    @Autowired
    public TemplateDeImpostoCondicionalServices templateDeImpostoCondicionalServices;
    @Autowired
    public OrcamentoRepository orcamentoRepository;

    @PostMapping(path = "api/orcamento/calculocondicional/{id}")
    @ApiOperation(value = "Calcular de imposto condicional")
    public ResponseEntity<Double> realizaCaluloCondicional(@PathVariable(value = "id", required = false) UUID id) {
        Optional<Orcamento> orcamento = orcamentoRepository.findById(id);
        boolean uso = templateDeImpostoCondicionalServices.deveUsarMaximaTaxacao(orcamento);
        Double value = 0.0;
        if (uso == true) {
            value = templateDeImpostoCondicionalServices.maximaTaxacao(orcamento);
        } else {
            value = templateDeImpostoCondicionalServices.minimaTaxacao(orcamento);
        }
        return ResponseEntity.status(HttpStatus.OK).body(value);
    }


    @GetMapping(path = "api/orcamento/calculocondicional/IHIT")
    @ApiOperation(value = "Calcular de imposto condicional")
    public ResponseEntity realizaCaluloCondicionalIHIT(){
        Optional<OrcamentoTempleteDTO> orcamentoTempleteDTO = Optional.of(new OrcamentoTempleteDTO());
        orcamentoTempleteDTO = templateDeImpostoCondicionalServices.calc();

        return ResponseEntity.status(HttpStatus.OK).body(orcamentoTempleteDTO);
    }
}
