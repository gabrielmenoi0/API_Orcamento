package com.develop.orcamentoapi.OrcamentoAPI.Controller;
import com.develop.orcamentoapi.OrcamentoAPI.Domain.NotaFiscal;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class NotaFiscalController {

    @GetMapping(path = "api/nota/")
    @ApiOperation(value = "Consulta nota fiscal")
    public ResponseEntity consultaNotaFiscal(){
        NotaFiscal notaFiscal = new NotaFiscal.Builder()
                .comRazaoSocial("Minha Empresa Ltda.")
                .comCnpj("12.345.678/0001-90")
                .comValorTotal(1000.00)
                .comImpostos(150.00)
                .comData(LocalDateTime.now())
                .comObservacoes("Esta é uma nota fiscal de teste.")
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(notaFiscal);
    }
}
