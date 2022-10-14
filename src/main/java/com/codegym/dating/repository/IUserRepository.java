package com.codegym.dating.repository;

import com.codegym.dating.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IUserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select * from user where id_user = :id", nativeQuery = true)
    User findUserById(Integer id);
}
