package com.develop.orcamentoapi.OrcamentoAPI.Controller;

import com.develop.orcamentoapi.OrcamentoAPI.Domain.Desconto;
import com.develop.orcamentoapi.OrcamentoAPI.Domain.Orcamento;
import com.develop.orcamentoapi.OrcamentoAPI.Services.StateServices;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.plaf.nimbus.State;

@RestController
public class StateController {
    @Autowired
    private StateServices stateServices;

    @GetMapping(path = "api/state/check/{status}")
    @ApiOperation(value = "Calculo do valor desconto do orçamento")
    public ResponseEntity realizaCheckStatus(@PathVariable(value = "status") StateServices.States status){
        var valueFinal = stateServices.checkState(status);
        return ResponseEntity.status(HttpStatus.OK).body(valueFinal);
    }
}
