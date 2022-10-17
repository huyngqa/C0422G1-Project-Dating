package com.codegym.dating.service.impl;

import com.codegym.dating.DTO.ReportDetailDto;
import com.codegym.dating.DTO.UserReportDto;
import com.codegym.dating.repository.IReportDetailsRepository;
import com.codegym.dating.service.IReportDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportDetailService implements IReportDetailsService {

    @Autowired
    private IReportDetailsRepository iReportDetailsRepository;

    @Override
    public List<ReportDetailDto> findByIdReportDetailUser(int id) {
        return iReportDetailsRepository.findByIdReportDetail(id);
    }

    @Override
    public List<UserReportDto> findByUserList(List<Integer> userIds) {
        return iReportDetailsRepository.findByUserList(userIds);
    }
}
