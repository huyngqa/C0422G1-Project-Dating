package com.codegym.dating.service.impl;

import com.codegym.dating.dto.IReportDetailsDto;
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
    public Page<IReportDetailsDto> findAll(String keyWord, Pageable pageable) {
        return reportDetailsRepository.findByAllReportUser(keyWord, pageable);
    }

    @Override
    public void confirm(int id) {
        ReportDetails reportDetails = findById(id);
        reportDetails.setStatus(9);
        reportDetailsRepository.save(reportDetails);;
    }

    @Override
    public void save(ReportDetailsDto reportDetailsDto) {
        reportDetailsRepository.createReportDetails(reportDetailsDto.getId(), reportDetailsDto.getReport(),
                reportDetailsDto.getPost(),reportDetailsDto.getReporter(),reportDetailsDto.getTimeReport(),reportDetailsDto.getStatus());
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
