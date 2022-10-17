package com.codegym.dating.dto;

import com.codegym.dating.model.Post;
import com.codegym.dating.model.Report;
import com.codegym.dating.model.User;

import java.time.LocalDateTime;

public interface ReportDetailsDto {
    Integer getIdReportDetails();
    Integer getPost();
    Integer getReporter();
    Integer getReport();
    Integer getStatus();
    Integer getUserPost();
    LocalDateTime getTimeReport();
}
