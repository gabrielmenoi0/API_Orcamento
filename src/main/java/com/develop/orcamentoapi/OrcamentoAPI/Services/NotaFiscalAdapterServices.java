package com.develop.orcamentoapi.OrcamentoAPI.Services;
import com.develop.orcamentoapi.OrcamentoAPI.Domain.NotaFiscalAdapter;
import org.springframework.stereotype.Service;

@Service

public class NotaFiscalAdapterServices implements InvoiceService {

    NotaFiscalAdapter notaFiscal;

    public void NotaFiscalAdapter(NotaFiscalAdapter notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public NotaFiscalAdapter generateInvoice(double subtotal) {
        double totalAmount = subtotal + notaFiscal.getValorImpostos() + notaFiscal.getValorTotal();
        notaFiscal.setSubTotal(totalAmount);
        return this.notaFiscal;
    }
}
