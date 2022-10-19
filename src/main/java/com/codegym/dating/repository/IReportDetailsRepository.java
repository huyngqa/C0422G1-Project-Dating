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
    @Query(value = "SELECT " +
            "report_details.id as idReportDetails, " +
            "report_details.id_report as idReport, " +
            "report_details.id_post as idPost," +
            "reporter.`name` as reporter, "+
            "report_details.time_report as timeReport, " +
            "writer.`name` as userPost , " +
            "report_details.status as status, " +
            "report.name_report as reportContent, "+
            "post.content as postContent " +
            "FROM report_details " +
            "Join " +
            "report on report.id_report = report_details.id_report "+
            "JOIN " +
            "`user` reporter on reporter.id_user = report_details.id_reporter " +
            "JOIN " +
            "post ON post.id_post = report_details.id_post " +
            "JOIN " +
            "`user` writer on writer.id_user = post.id_user " +
            "WHERE " +
            "report_details.status = 8 and (post.content like %:keyWord% or writer.`name` like %:keyWord%)", nativeQuery = true,
            countQuery = "select count(*) from (SELECT " +
                    "report_details.id as idReportDetails, " +
                    "report_details.id_report as idReport, " +
                    "report_details.id_post as idPost, " +
                    "reporter.`name` as reporter, " +
                    "report_details.time_report as timeReport, " +
                    "writer.`name` as userPost, " +
                    "report_details.status as status, " +
                    "post.content as postContent " +
                    "FROM report_details " +
                    "JOIN " +
                    "`user` reporter on reporter.id_user = report_details.id_reporter " +
                    "JOIN " +
                    "post ON post.id_post = report_details.id_post " +
                    "JOIN " +
                    "`user` writer on writer.id_user = post.id_user " +
                    "WHERE " +
                    "report_details.status = 8 and (post.content like %:keyWord% or writer.`name` like %:keyWord%)) report_details")
    Page<ReportDetailsDto> findByAllReportUser(@Param("keyWord") String keyWord, Pageable pageable);

    @Transactional
    @Query(value = "select report_details.id_report,report_details.id_post, report_details.id_reporter, report_details.time_report,report_details.status, report_details.id" +
           " from  report_details where (report_details.id = :id and report_details.status = 8) ", nativeQuery = true)
    ReportDetails findReportDetailsByID(@Param("id") Integer id);


    @Modifying
    @Transactional
    @Query(value = "insert into report_details(id_report, id_post, id_reporter, " +
            "time_report, status)" +
            "values (?1,?2,?3,?4,8)", nativeQuery = true)
    void createReportDetails(@Param("post") Integer post,@Param("report")Integer report,@Param("reporter") Integer reporter,@Param("timeReport") LocalDateTime timeReport);



}
