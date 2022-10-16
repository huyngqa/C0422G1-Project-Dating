package com.codegym.dating.service;

import com.codegym.dating.DTO.ReportDetailDto;
import com.codegym.dating.DTO.UserReportDto;

import java.util.List;

public interface IReportDetailsService {
    List<ReportDetailDto> findByIdReportDetailUser(int id);

    List<UserReportDto> findByUserList(List<Integer> userIds);
}
