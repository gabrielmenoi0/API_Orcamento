package com.develop.orcamentoapi.OrcamentoAPI.Controller;

import com.develop.orcamentoapi.OrcamentoAPI.Domain.*;
import com.develop.orcamentoapi.OrcamentoAPI.Services.CalculoServices;
import com.develop.orcamentoapi.OrcamentoAPI.Services.OrcamentoServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@RestController
@Api(value = "Cálculo")
public class CalculoController {
@Autowired
private CalculoServices calculoServices;

    @GetMapping(path = "api/calculo/icms/{value}/{icms}")
    @ApiOperation(value = "Calculo do orçamento com ICMS")
    public  ResponseEntity<Double> realizaCaluloIcms(@PathVariable(value = "value")Double value,@PathVariable(value = "icms")Double icms){
        final Orcamento orcamento = new Orcamento();
        final ICMS objecticms = new ICMS();
        objecticms.setValor(icms);
        orcamento.setValor(value);
        var valueFinal = calculoServices.realizaCalculo(orcamento,objecticms.getValor());
        return ResponseEntity.status(HttpStatus.OK).body(valueFinal);
    }
    @GetMapping(path = "api/calculo/pis/{value}/{pis}")
    @ApiOperation(value = "Calculo do orçamento com PIS")
    public  ResponseEntity<Double> realizaCaluloPis(@PathVariable(value = "value")Double value,@PathVariable(value = "pis")Double icms){
        final Orcamento orcamento = new Orcamento();
        final PIS objectpis = new PIS();
        objectpis.setValor(icms);
        orcamento.setValor(value);
        var valueFinal = calculoServices.realizaCalculo(orcamento,objectpis.getValor());
        return ResponseEntity.status(HttpStatus.OK).body(valueFinal);
    }
    @GetMapping(path = "api/calculo/iss/{value}/{iss}")
    @ApiOperation(value = "Calculo do orçamento com ISS")
    public  ResponseEntity<Double> realizaCaluloIss(@PathVariable(value = "value")Double value,@PathVariable(value = "iss")Double icms){
        final Orcamento orcamento = new Orcamento();
        final ISS objectiss = new ISS();
        objectiss.setValor(icms);
        orcamento.setValor(value);
        var valueFinal = calculoServices.realizaCalculo(orcamento,objectiss.getValor());
        return ResponseEntity.status(HttpStatus.OK).body(valueFinal);
    }
    @GetMapping(path = "api/calculo/cofins/{value}/{cofins}")
    @ApiOperation(value = "Calculo do orçamento com COFINS")
    public  ResponseEntity<Double> realizaCaluloCofins(@PathVariable(value = "value")Double value,@PathVariable(value = "cofins")Double icms){
        final Orcamento orcamento = new Orcamento();
        final COFINS objectCofins = new COFINS();
        objectCofins.setValor(icms);
        orcamento.setValor(value);
        var valueFinal = calculoServices.realizaCalculo(orcamento,objectCofins.getValor());
        return ResponseEntity.status(HttpStatus.OK).body(valueFinal);
    }

}



