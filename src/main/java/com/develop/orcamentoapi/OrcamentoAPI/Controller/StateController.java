package com.develop.orcamentoapi.OrcamentoAPI.Controller;
import com.develop.orcamentoapi.OrcamentoAPI.Domain.Orcamento;
import com.develop.orcamentoapi.OrcamentoAPI.Services.StateServices;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
public class StateController {
    @Autowired
    private StateServices stateServices;

    @PutMapping(path = "api/state/check/{status}/{id}")
    @ApiOperation(value = "Calculo do valor desconto do orçamento")
    public ResponseEntity realizaCheckStatus(@PathVariable(value = "status") StateServices.States status, @PathVariable(value = "id") UUID id){
        Orcamento orcamento = new Orcamento();
        orcamento = stateServices.alterState(status.toString(),id);
        return ResponseEntity.status(HttpStatus.OK).body(orcamento);
    }
}
