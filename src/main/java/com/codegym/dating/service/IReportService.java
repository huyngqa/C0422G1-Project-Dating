package com.codegym.dating.service;

import com.codegym.dating.dto.ReportDto;
import com.codegym.dating.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IReportService {
    List<ReportDto> findAllReport();

    ReportDto findReportById(Integer id);
}
