package com.codegym.dating.service;

import com.codegym.dating.dto.IReportDetailsDto;
import com.codegym.dating.dto.ReportDetailsDto;
import com.codegym.dating.model.ReportDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IReportDetailsService {
    Page<IReportDetailsDto> findAll(String keyWord, Pageable pageable);

    void confirm(int id);

    void save(ReportDetailsDto reportDetailsDto);

    void delete(int id);

    ReportDetails findById (Integer id);
}
