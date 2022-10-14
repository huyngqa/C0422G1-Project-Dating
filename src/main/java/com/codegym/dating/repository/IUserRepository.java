package com.codegym.dating.repository;

import com.codegym.dating.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
@Transactional
public interface IUserRepository extends JpaRepository<User, Integer> {
    @Query(value = "select * \n" +
            "from user \n" +
            "where id_user = :id", nativeQuery = true)
    User findByIdNativeQuery(@Param("id") Integer id);



    @Modifying
    @Query(value = "update user \n" +
            "set coin = :coin \n" +
            "where id_user = :id_user ", nativeQuery = true)
    void updateCoin(@Param("coin") Integer coin,@Param("id_user") Integer idUser);
}
