package com.codegym.dating.service;

import com.codegym.dating.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInvoiceService {
    void savePaypal(Invoice invoice);
}
