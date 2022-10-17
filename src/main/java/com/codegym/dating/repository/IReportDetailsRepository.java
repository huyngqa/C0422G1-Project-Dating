package com.codegym.dating.repository;

import com.codegym.dating.model.Post;
import com.codegym.dating.model.Report;
import com.codegym.dating.model.ReportDetails;
import com.codegym.dating.model.User;
import com.codegym.dating.model.composite.ReportUserKey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.LocalTime;

public interface IReportDetailsRepository extends JpaRepository<ReportDetails, ReportUserKey> {

    @Transactional
    @Query(value = "SELECT report_details.id , report_details.id_report, report_details.id_post, report_details.id_reporter, "+
            "report_details.time_report, post.id_user, report_details.status " +
            "FROM " +
            "report_details " +
            "JOIN " +
            "post ON post.id_post = report_details.id_post " +
            "WHERE " +
            "report_details.status = 8", nativeQuery = true,
            countQuery = "select count(*) from (select report_details.id, report_details.id_report, " +
                    "report_details.id_post, " +
                    "report_details.id_reporter, " +
                    "report_details.time_report, " +
                    "post.id_user  " +
                    "from  " +
                    "report_details " +
                    "join post on post.id_post = report_details.id_post  " +
                    "where report_details.status = 8) report_details")
    Page<ReportDetails> findByAllReportUser(Pageable pageable);

    @Transactional
    @Query(value = "select report_detail.id_report,report_details.id_post, report_details.id_reporter, report_details.time_report,report_user.status" +
           " from  report_detail where (report_details = :id and report_detail.status = 8) ", nativeQuery = true)
    ReportDetails findReportDetailsByID(@Param("id") Integer id);


    @Modifying
    @Transactional
    @Query(value = "update report_detail set report_detail.status = 9 where id = ?1 ", nativeQuery = true)
    void confirm (Integer id);

    @Modifying
    @Transactional
    @Query(value = "insert into report_detail(report_detail.id_report,report_details.id_post, report_details.id_reporter, " +
            "report_details.time_report,report_details.status)" +
            "values (?1,?2,?3,?4,8)", nativeQuery = true)
    void createReportDetails(Integer report, Integer post, Integer reporter, LocalDateTime timeReport);
}
