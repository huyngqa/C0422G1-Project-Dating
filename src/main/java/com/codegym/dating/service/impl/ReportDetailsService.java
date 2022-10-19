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
    public Page<ReportDetailsDto> findAll(String keyWord, Pageable pageable) {
        return reportDetailsRepository.findByAllReportUser(keyWord, pageable);
    }

    @Override
    public void confirm(int id) {
        ReportDetails reportDetails = findById(id);
        reportDetails.setStatus(9);
        reportDetailsRepository.save(reportDetails);;
    }

    @Override
    public void save(ReportDetails reportDetails) {
        reportDetailsRepository.createReportDetails(reportDetails.getPost().getIdPost(), reportDetails.getReport().getIdReport(),
                reportDetails.getReporter().getIdUser(),reportDetails.getTimeReport());
    }

    @Override
    public void delete(int id) {
        ReportDetails reportDetails = findById(id);
        reportDetails.setStatus(13);
        reportDetailsRepository.save(reportDetails);
    }

    @Override
    public ReportDetails findById(Integer id) {
        return reportDetailsRepository.findReportDetailsByID(id);
    }
}
