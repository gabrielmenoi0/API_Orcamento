package com.develop.orcamentoapi.OrcamentoAPI.Controller;
import com.develop.orcamentoapi.OrcamentoAPI.Domain.NotaFiscalBuilder;
import com.develop.orcamentoapi.OrcamentoAPI.Domain.NotaFiscalObserver;
import com.develop.orcamentoapi.OrcamentoAPI.Repository.OrcamentoRepository;
import com.develop.orcamentoapi.OrcamentoAPI.Services.NotaFiscalObserverServices;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
@RestController
public class NotaFiscalController {
    @Autowired
    public NotaFiscalObserverServices notaFiscal;
    @GetMapping(path = "api/nota/builder")
    @ApiOperation(value = "Consulta nota fiscal Builder")
    public ResponseEntity consultaNotaFiscalBuilder(){
        NotaFiscalBuilder notaFiscalBuilder = new NotaFiscalBuilder.Builder()
                .comRazaoSocial("Minha Empresa Ltda.")
                .comCnpj("12.345.678/0001-90")
                .comValorTotal(1000.00)
                .comImpostos(150.00)
                .comData(LocalDateTime.now())
                .comObservacoes("Esta é uma nota fiscal de teste.")
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(notaFiscalBuilder);
    }

    @GetMapping(path = "api/nota/observer")
    @ApiOperation(value = "Consulta nota fiscal observer")
    public ResponseEntity<NotaFiscalObserver> consultaNotaFiscalObserver(){
        NotaFiscalObserver nota = notaFiscal.generateNoteObserver();
        System.out.println(nota);
        return ResponseEntity.status(HttpStatus.OK).body(nota);
    }
}
