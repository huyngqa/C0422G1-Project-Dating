package com.codegym.dating.repository;

import com.codegym.dating.DTO.ListUserDto;
import com.codegym.dating.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface IUserRepository extends JpaRepository<User, Integer> {
    @Transactional
    @Query(value = "select id_user as idUser, name, coin, join_day as joinDay, type_user_name as typeUser, so_lan_vi_pham as quantity from (select" +
            " user.id_user," +
            " user.name," +
            " user.coin," +
            " user.join_day," +
            " type_user.type_user_name," +
            "count(user.id_user) AS so_lan_vi_pham" +
            " from" +
            " user" +
            " left join" +
            " type_user on type_user.id_type_user = user.id_type_user" +
            " left join" +
            " report_user on report_user.id_reported = user.id_user" +
            " where report_user.status = 9" +
            "group by user.id_user" +
            " union " +
            "select user.id_user," +
            " user.name," +
            " user.coin," +
            " user.join_day, type_user.type_user_name, 0 from user join type_user on user.id_type_user = type_user.id_type_user) as temp" +
            " group by id_user" +
            " order by id_user",nativeQuery = true, countQuery = "select count(*) from (select id_user as idUser, name, coin, join_day as joinDay, type_user_name as typeUser, so_lan_vi_pham as quantity from (select" +
            " user.id_user," +
            " user.name," +
            " user.coin," +
            " user.join_day," +
            " type_user.type_user_name," +
            "count(user.id_user) AS so_lan_vi_pham" +
            " from" +
            " user" +
            " left join" +
            " type_user on type_user.id_type_user = user.id_type_user" +
            " left join" +
            " report_user on report_user.id_reported = user.id_user" +
            " where report_user.status = 9" +
            "group by user.id_user" +
            " union " +
            "select user.id_user," +
            " user.name," +
            " user.coin," +
            " user.join_day, type_user.type_user_name, 0 from user join type_user on user.id_type_user = type_user.id_type_user) as temp" +
            " group by id_user" +
            " order by id_user) as temp")
    Page<ListUserDto> findAllByName(Pageable pageable);

}
