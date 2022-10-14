package com.codegym.dating.service;

import com.codegym.dating.model.Invoice;
import com.codegym.dating.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IInvoiceService {
    void savePaypal(Invoice invoice, Integer id);
}
