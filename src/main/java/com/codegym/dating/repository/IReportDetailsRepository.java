package com.codegym.dating.repository;

import com.codegym.dating.DTO.UserReportDto;
import com.codegym.dating.model.ReportDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface IReportDetailsRepository extends JpaRepository<ReportDetails, Integer> {
    @Transactional
    @Query(value = "select * " +
            "from report_details " +
            "left join report on report.id_report = report_details.id_report " +
            "left join user on user.id_user = report_details.id_reporter " +
            "where user.id_user = ?1" ,nativeQuery = true)
    List<ReportDetails> findByIdReportDetail(int id);

    @Query(value="SELECT " +
            "      new com.codegym.dating.DTO.UserReportDto(u.idUser, " +
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
