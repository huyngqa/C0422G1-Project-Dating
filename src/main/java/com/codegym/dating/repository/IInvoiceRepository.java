package com.codegym.dating.repository;

import com.codegym.dating.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInvoiceRepository extends JpaRepository<Invoice, Integer> {
}
