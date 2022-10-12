package com.codegym.dating.repository;

import com.codegym.dating.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReportRepository extends JpaRepository<Report, Integer> {
}
