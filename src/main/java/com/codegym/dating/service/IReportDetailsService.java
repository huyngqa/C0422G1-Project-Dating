package com.codegym.dating.service;

import com.codegym.dating.dto.ReportDetailsDto;
import com.codegym.dating.model.ReportDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface IReportDetailsService {
    Page<ReportDetailsDto> findAll( String keyWord,Pageable pageable);

    void confirm(int id);

    void save(ReportDetails reportDetails);

    void delete(int id);

    ReportDetails findById (Integer id);
}
