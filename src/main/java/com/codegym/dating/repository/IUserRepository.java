package com.codegym.dating.repository;

import com.codegym.dating.DTO.ListUserDto;
import com.codegym.dating.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IUserRepository extends JpaRepository<User, Integer> {
    @Transactional
    @Query(value = "SELECT " +
            "   id_user AS idUser, " +
            "   name, " +
            "   coin, " +
            "   join_day AS joinDay, " +
            "   type_user_name AS typeUser, " +
            "   so_lan_vi_pham AS quantity " +
            "FROM " +
            "   ( " +
            "   SELECT " +
            "      u.id_user, " +
            "      u.name, " +
            "      u.coin, " +
            "      u.join_day, " +
            "      tu.type_user_name, " +
            "      count(*) AS so_lan_vi_pham " +
            "   FROM " +
            "      report_details rd " +
            "   JOIN post p ON " +
            "      rd.id_post = p.id_post " +
            "   JOIN USER u ON " +
            "      u.id_user = p.id_user " +
            "   JOIN type_user tu ON " +
            "      tu.id_type_user = u.id_type_user " +
            "   WHERE " +
            "      rd.status = 9 " +
            "   GROUP BY " +
            "      u.id_user " +
            "UNION " +
            "   SELECT " +
            "      `USER`.id_user, " +
            "      `USER`.name, " +
            "      `USER`.coin, " +
            "      `USER`.join_day, " +
            "      type_user.type_user_name, " +
            "      0 " +
            "   FROM " +
            "      USER " +
            "   JOIN type_user ON " +
            "      user.id_type_user = type_user.id_type_user) AS TEMP " +
            "GROUP BY " +
            "   id_user " +
            "ORDER BY " +
            "   id_user", nativeQuery = true)
    Page<ListUserDto> findAllByName(@Param("name") String name, Pageable pageable);

    Page<User> findByNameContaining(String name, Pageable pageable);

    @Query(value="select u from User u join TypeUser tu on tu.idTypeUser = u.typeUser.idTypeUser where u.name LIKE lower(concat('%', ?1,'%')) AND tu.typeUserName = ?2 ORDER BY u.idUser ASC")
    Page<User> findByTypeUser(String name, String typeUser, Pageable pageable);

    @Modifying
    @Query(value = "update account " +
            "left join user on user.id_user = account.id_user " +
            "set account.status = ?1" +
            "where user.id_user = ?2", nativeQuery = true)
    void updateStatusUserWarning(@Param("status") Integer status,@Param("id") Integer id);
}
