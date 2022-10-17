package com.codegym.dating.repository;

import com.codegym.dating.dto.ReportDetailsDto;
import com.codegym.dating.model.ReportDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

public interface IReportDetailsRepository extends JpaRepository<ReportDetails, Integer> {

    @Transactional
    @Query(value = "SELECT report_details.id as idReportDetails, report_details.id_report as report, report_details.id_post as post, report_details.id_reporter as reporter, "+
            "report_details.time_report as timeReport, post.id_user as userPost , report_details.status as status " +
            "FROM report_details " +
            "JOIN " +
            "post ON post.id_post = report_details.id_post " +
            "WHERE " +
            "report_details.status = 8", nativeQuery = true,
            countQuery = "select count(*) from (select report_details.id as idReportDetails, report_details.id_report as report, " +
                    "report_details.id_post as post, " +
                    "report_details.id_reporter as reporter, " +
                    "report_details.time_report as timeReport, " +
                    "post.id_user as userPost " +
                    "from  " +
                    "report_details " +
                    "join post on post.id_post = report_details.id_post  " +
                    "where report_details.status = 8) report_details")
    Page<ReportDetailsDto> findByAllReportUser(Pageable pageable);

    @Transactional
    @Query(value = "select report_details.id_report,report_details.id_post, report_details.id_reporter, report_details.time_report,report_details.status, report_details.id" +
           " from  report_details where (report_details.id = :id and report_details.status = 8) ", nativeQuery = true)
    ReportDetails findReportDetailsByID(@Param("id") Integer id);


    @Modifying
    @Transactional
    @Query(value = "update report_details set report_details.status = 9 where report_details.id = ?1 ", nativeQuery = true)
    void confirm (Integer id);

    @Modifying
    @Transactional
    @Query(value = "insert into report_details(report_detail.id_report,report_details.id_post, report_details.id_reporter, " +
            "report_details.time_report,report_details.status)" +
            "values (?1,?2,?3,?4,8)", nativeQuery = true)
    void createReportDetails(Integer report, Integer post, Integer reporter, LocalDateTime timeReport);


    @Modifying
    @Transactional
    @Query(value = "update report_details set report_details.status = 13 where report_details.id = ?1 ", nativeQuery = true)
    void deleteReportDetails (Integer id);
}
