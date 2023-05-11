package com.develop.orcamentoapi.OrcamentoAPI.Services;

import com.develop.orcamentoapi.OrcamentoAPI.Domain.NotaFiscalAdapter;

public interface InvoiceService {
    NotaFiscalAdapter generateInvoice(double subtotal);
}