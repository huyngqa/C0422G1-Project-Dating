package com.codegym.dating.service;

import com.codegym.dating.dto.ReportDetailsDto;
import com.codegym.dating.model.ReportDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IReportDetailsService {
    Page<ReportDetails> findAll(Pageable pageable);

    void confirm(ReportDetails reportDetails);

    void save(ReportDetails reportDetails);
}
