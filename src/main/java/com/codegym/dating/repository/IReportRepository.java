package com.codegym.dating.repository;

import com.codegym.dating.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IReportRepository extends JpaRepository<Report, Integer> {
}
