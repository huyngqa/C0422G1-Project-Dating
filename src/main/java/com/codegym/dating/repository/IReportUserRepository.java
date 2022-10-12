package com.codegym.dating.repository;

import com.codegym.dating.model.ReportUser;
import com.codegym.dating.model.composite.ReportUserKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReportUserRepository extends JpaRepository<ReportUser, ReportUserKey> {
}
