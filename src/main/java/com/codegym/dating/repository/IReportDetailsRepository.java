package com.codegym.dating.repository;

import com.codegym.dating.model.ReportDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReportDetailsRepository extends JpaRepository<ReportDetails, Integer> {
}
