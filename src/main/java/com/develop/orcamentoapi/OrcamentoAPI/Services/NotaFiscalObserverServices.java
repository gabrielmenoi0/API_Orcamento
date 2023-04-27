package com.develop.orcamentoapi.OrcamentoAPI.Services;

import com.develop.orcamentoapi.OrcamentoAPI.Domain.NotaFiscalObserver;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service

public class NotaFiscalObserverServices {

    public NotaFiscalObserver generateNoteObserver(){
        LocalDateTime data = LocalDateTime.now();
        NotaFiscalObserver notaFiscal = new NotaFiscalObserver("Empresa X", "00.000.000/0001-00", 1000.00, 150.00, data, "Observações sobre a nota fiscal");

        NotaFiscalObserver.Observer observer1 = new NotaFiscalObserver.Observer() {
            @Override
            public void update(NotaFiscalObserver notaFiscal) {
                System.out.println("Observer 1: Nota fiscal alterada");
            }
        };

        NotaFiscalObserver.Observer observer2 = new NotaFiscalObserver.Observer() {
            @Override
            public void update(NotaFiscalObserver notaFiscal) {
                System.out.println("Observer 2: Razão social alterada para " + notaFiscal.getRazaoSocial());
            }
        };

        notaFiscal.addObserver(observer1);
        notaFiscal.addObserver(observer2);

// Alterando a razão social da nota fiscal
        notaFiscal.setRazaoSocial("Nova Razão Social");

// Notificando os observers registrados
        notaFiscal.notifyObservers();
        return notaFiscal;

    }
}
