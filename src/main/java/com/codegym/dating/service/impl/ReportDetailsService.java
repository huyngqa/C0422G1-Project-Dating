package com.codegym.dating.service.impl;

import com.codegym.dating.dto.ReportDetailsDto;
import com.codegym.dating.model.ReportDetails;
import com.codegym.dating.repository.IReportDetailsRepository;
import com.codegym.dating.service.IReportDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReportDetailsService implements IReportDetailsService {
    @Autowired
    IReportDetailsRepository reportDetailsRepository;


    @Override
    public Page<ReportDetailsDto> findAll(Pageable pageable) {
        return reportDetailsRepository.findByAllReportUser(pageable);
    }

    @Override
    public void confirm(ReportDetails reportDetails) {
        reportDetailsRepository.confirm(reportDetails.getStatus());
    }

    @Override
    public void save(ReportDetails reportDetails) {
        reportDetailsRepository.createReportDetails(reportDetails.getReport().getIdReport(), reportDetails.getPost().getIdPost(),
                reportDetails.getReporter().getIdUser(),reportDetails.getTimeReport());
    }

    @Override
    public void delete(ReportDetails reportDetails) {
        reportDetailsRepository.deleteReportDetails(reportDetails.getStatus());
    }

    @Override
    public ReportDetails findById(Integer id) {
        return reportDetailsRepository.findReportDetailsByID(id);
    }
}
