package com.codegym.dating.repository;

import com.codegym.dating.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IUserRepository extends JpaRepository<User, Integer> {
    User findByAccount_IdAccount(Integer idAccount);

    @Modifying
    @Query(value = "update user \n" +
            "set avatar = :avatar \n" +
            "where id_user = :id_user ;", nativeQuery = true)
    void updateAvatar(@Param("avatar") String avatar, @Param("id_user") Integer idUser);


    @Modifying
    @Query(value = "update user \n" +
            "set user.id_status_active = :status \n" +
            "where user.id_user = :id_user", nativeQuery = true)
    void updateStatusActive(@Param("status") Integer status, @Param("id_user") Integer idUser);

}
