package com.codegym.dating.repository;

import com.codegym.dating.dto.UserDto;
import com.codegym.dating.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
    @Query(nativeQuery = true,
            value = "select c.name , c.job , c.gender , h.hobbit_name as hobbitName ,c.date_of_birth as dateOfBirth, c.coin ,c.address,c.avatar " +
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
            countQuery = "select c.name , c.job , c.gender , h.hobbit_name as hobbitName ,c.date_of_birth as dateOfBirth, c.coin ,c.address,c.avatar " +
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

}
