package com.codegym.dating.dto;

import com.codegym.dating.model.Post;
import com.codegym.dating.model.Report;
import com.codegym.dating.model.User;

import java.time.LocalDateTime;

public interface ReportDetailsDto {
    Integer getIdReportDetails();
    Integer getIdPost();
    String getReporter();
    Integer getIdReport();
    Integer getStatus();
    String getUserPost();
    String getPostContent();
    String getReportContent();
    LocalDateTime getTimeReport();
}
