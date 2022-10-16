package com.codegym.dating.service;

import com.codegym.dating.DTO.UserReportDto;
import com.codegym.dating.model.ReportDetails;

import java.util.List;
import java.util.Optional;

public interface IReportDetailsService {
    List<ReportDetails> findByIdReportDetailUser(int id);

    List<UserReportDto> findByUserList(List<Integer> userIds);
}
