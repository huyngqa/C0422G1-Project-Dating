package com.codegym.dating.repository;

import com.codegym.dating.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IUserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select * from user ", nativeQuery = true)
    List<User> findAllUser();

    @Query(value = "select * from user where id_user = :id", nativeQuery = true)
    User findUserById(Integer id);
}
