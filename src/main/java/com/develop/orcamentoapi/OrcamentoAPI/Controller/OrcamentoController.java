package com.develop.orcamentoapi.OrcamentoAPI.Controller;

import com.develop.orcamentoapi.OrcamentoAPI.DTO.OrcamentoDTO;
import com.develop.orcamentoapi.OrcamentoAPI.Domain.*;
import com.develop.orcamentoapi.OrcamentoAPI.Services.OrcamentoServices;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
public class OrcamentoController {
    @Autowired
    private OrcamentoServices orcamentoServices;

    @GetMapping(path = "api/orcamento/calculo/{value}/{icms}/{pis}/{cofins}/{iss}")
    @ApiOperation(value = "Calcular orçamento com todos os impostos")
    public ResponseEntity<ResponseCalculoTotal> realizaCalulo(
            @PathVariable(value = "value", required = false)Double value,
            @PathVariable(value = "icms", required = false)Double icms,
            @PathVariable(value = "pis", required = false)Double pis,
            @PathVariable(value = "cofins", required = false)Double cofins,
            @PathVariable(value = "iss", required = false)Double iss){
        final COFINS objectCofins = new COFINS();
        final PIS objectPis = new PIS();
        final ISS objectISS= new ISS();
        final ICMS objectIcms= new ICMS();
        final Orcamento orcamento = new Orcamento();
        orcamento.setValor(value);
        objectCofins.setValor(cofins);
        objectIcms.setValor(icms);
        objectPis.setValor(pis);
        objectISS.setValor(iss);
        ResponseCalculoTotal valueFinal = orcamentoServices.realizaCalculoTotal(orcamento,objectIcms,objectPis,objectCofins,objectISS);
        return ResponseEntity.status(HttpStatus.OK).body(valueFinal);
    }
    @GetMapping(path = "api/orcamento/calculo/optional/{value}/{icms}/{pis}/{cofins}/{iss}")
    @ApiOperation(value = "Calcular orçamento apenas com os impostos desejados")
    public ResponseEntity<ResponseCalculoTotal> realizaCaluloOptional(
            @PathVariable(value = "value", required = false)Double value,
            @PathVariable(value = "icms", required = false)Double icms,
            @PathVariable(value = "pis", required = false)Double pis,
            @PathVariable(value = "cofins", required = false)Double cofins,
            @PathVariable(value = "iss", required = false)Double iss){
        final COFINS objectCofins = new COFINS();
        final PIS objectPis = new PIS();
        final ISS objectISS= new ISS();
        final ICMS objectIcms= new ICMS();
        final Orcamento orcamento = new Orcamento();
        orcamento.setValor(value);
        objectCofins.setValor(cofins);
        objectIcms.setValor(icms);
        objectPis.setValor(pis);
        objectISS.setValor(iss);
        ResponseCalculoTotal valueFinal = orcamentoServices.realizaCalculoTotal(orcamento,objectIcms,objectPis,objectCofins,objectISS);
        return ResponseEntity.status(HttpStatus.OK).body(valueFinal);
    }

}
