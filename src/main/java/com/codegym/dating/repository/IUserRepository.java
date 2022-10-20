package com.codegym.dating.repository;

import com.codegym.dating.dto.ListUserDto;
import com.codegym.dating.dto.UserDto;
import com.codegym.dating.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Transactional
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


    @Query(value = "SELECT \n" +
            "    id_user AS idUser,\n" +
            "    address,\n" +
            "    avatar,\n" +
            "    coin,\n" +
            "    date_of_birth AS dateOfBirth,\n" +
            "    gender,\n" +
            "    job,\n" +
            "    join_day AS joinDay,\n" +
            "    married,\n" +
            "    name,\n" +
            "    id_status_active AS idStatusActive,\n" +
            "    id_type_user AS idTypeUser\n" +
            "FROM\n" +
            "    user\n" +
            "WHERE\n" +
            "    id_user = ?1\n", nativeQuery = true)
        Optional<UserDto> findByIdDto(Integer id);

    @Query(value = "select * from user u\n" +
            "join account as a  \n" +
            "on u.id_user = a.id_user\n" +
            "join type_user as tu \n" +
            "on u.id_type_user = tu.id_type_user\n" +
            "where u.id_user = :id ", nativeQuery = true)
    User findByIdNativeQuery(@Param("id") Integer id);



    @Modifying
    @Query(value = "update user \n" +
            "set coin = :coin \n" +
            "where id_user = :id_user ", nativeQuery = true)
    void updateCoin(@Param("coin") Integer coin,@Param("id_user") Integer idUser);


    @Modifying
    @Query(value = "update user \n" +
            "set id_type_user = :id_type_user \n" +
            "where id_user = :id_user ", nativeQuery = true)
    void updateTypeUser(@Param("id_type_user") Integer idTypeUser,@Param("id_user") Integer idUser);

    @Query(nativeQuery = true,
            value = "select c.name , c.job , c.gender , h.hobbit_name as hobbitName ,c.date_of_birth as dateOfBirth, c.coin ,c.address, c.avatar " +
                    "from user as c " +
                    "join user_has_hobbit as uhh " +
                    "on c.id_user = uhh.id_user " +
                    "join hobbit as h " +
                    "on uhh.id_hobbit = h.id_hobbit " +
                    "where c.name like ?1 " +
                    "and year(c.date_of_birth) >= ?2 " +
                    "and c.address like ?3 " +
                    "and c.job like ?4 " +
                    "and (c.gender = ?5 or c.gender = ?6) " +
                    "and h.hobbit_name like ?7 group by c.id_user ",
            countQuery = "select c.name , c.job , c.gender , h.hobbit_name as hobbitName ,c.date_of_birth as dateOfBirth, c.coin ,c.address, c.avatar " +
                    "from user as c " +
                    "join user_has_hobbit as uhh " +
                    "on c.id_user = uhh.id_user " +
                    "join hobbit as h " +
                    "on uhh.id_hobbit = h.id_hobbit " +
                    "where c.name like ?1 " +
                    "and year(c.date_of_birth) >= ?2 " +
                    "and c.address like ?3 " +
                    "and c.job like ?4 " +
                    "and (c.gender = ?5 or c.gender = ?6) " +
                    "and h.hobbit_name like ?7 group by c.id_user ")
    Page<UserDto> findAllUserAndSearch(String name,
                                       String dateOfBirth,
                                       String address,
                                       String job,
                                       int gender0,
                                       int gender1,
                                       String hobbitName,
                                       Pageable pageable);

    @Query(value = "SELECT user.`name`,user.coin,user.gender,user. address,user.job,user .avatar FROM user  where  user.`name` like :name ",
            countQuery = "select count(*) from (SELECT user.`name`,user.coin,user.gender,user. address,user.job,user .avatar FROM user )as pageCount",
            nativeQuery = true)
    Page<UserDto> getAllSearchPage(Pageable pageable, @Param("name") String name);

    @Query(value = "SELECT user.`name`,user.coin,user.gender,user. address,user.job,user .avatar FROM user where  user.`name` like :name"
         , nativeQuery = true)
    List<UserDto> getAllSearch(@Param("name") String name);
}
