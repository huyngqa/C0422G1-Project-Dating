package com.codegym.dating.repository;

import com.codegym.dating.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Integer> {
    @Query(value = "select * from `user` where id_user = :idUser", nativeQuery = true )
    Optional<User> findById(@Param("idUser") Integer idUser);
}
