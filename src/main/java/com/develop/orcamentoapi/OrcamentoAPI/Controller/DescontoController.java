package com.develop.orcamentoapi.OrcamentoAPI.Controller;

import com.develop.orcamentoapi.OrcamentoAPI.Domain.Desconto;
import com.develop.orcamentoapi.OrcamentoAPI.Domain.ISS;
import com.develop.orcamentoapi.OrcamentoAPI.Domain.Orcamento;
import com.develop.orcamentoapi.OrcamentoAPI.Services.CalculoServices;
import com.develop.orcamentoapi.OrcamentoAPI.Services.DescontoServices;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DescontoController {
    @Autowired
    private DescontoServices descontoServices;

    @GetMapping(path = "api/desconto/{value}/{qtd}")
    @ApiOperation(value = "Calculo do valor desconto do orçamento")
    public ResponseEntity<Double> realizaCaluloDesconto(@PathVariable(value = "value")Double value, @PathVariable(value = "qtd")Double qtd){
        final Orcamento orcamento = new Orcamento();
        final Desconto desconto = new Desconto();
        desconto.setQuantidade(qtd);
        orcamento.setValor(value);
        var valueFinal = descontoServices.calculo(orcamento,desconto);
        return ResponseEntity.status(HttpStatus.OK).body(valueFinal);
    }
}
