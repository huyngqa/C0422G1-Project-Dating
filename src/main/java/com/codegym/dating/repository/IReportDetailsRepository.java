package com.codegym.dating.repository;

import com.codegym.dating.dto.ReportDetailDto;
import com.codegym.dating.dto.UserReportDto;
import com.codegym.dating.model.ReportDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IReportDetailsRepository extends JpaRepository<ReportDetails, Integer> {
    @Transactional
    @Query(value = "select new com.codegym.dating.dto.ReportDetailDto(u.idUser,u.name, rd.timeReport, r.nameReport, rd.reporter.name) " +
            "from ReportDetails rd left join Report r on r.idReport = rd.report.idReport join Post p on p.idPost = rd.post.idPost " +
            "left join User u on u.idUser = p.user.idUser  " +
            "where u.idUser = :id and rd.status = 9")
    List<ReportDetailDto> findByIdReportDetail(@Param("id") int id);

    @Query(value="SELECT " +
            "      new com.codegym.dating.dto.UserReportDto(u.idUser, " +
            "      count(rd)) " +
            "   FROM " +
            "      ReportDetails rd " +
            "   JOIN Post p ON " +
            "      rd.post.idPost = p.idPost " +
            "   JOIN User u ON " +
            "      u.idUser = p.user.idUser " +
            "   WHERE " +
            "      rd.status = 9 AND  u.idUser IN ?1 GROUP BY u.idUser")
    List<UserReportDto> findByUserList(List<Integer> userIds);
}
