package com.codegym.dating.dto;

import com.codegym.dating.model.Post;
import com.codegym.dating.model.Report;
import com.codegym.dating.model.User;

import java.time.LocalDateTime;

public interface ReportDetailsDto {
    Integer getId();
    Post getPost();
    User getReporter();
    Report getReport();
    Integer getStatus();
    LocalDateTime getTimeReport();
    Integer getUserPost();
}
