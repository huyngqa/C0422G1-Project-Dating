package com.codegym.dating.repository;

import com.codegym.dating.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface IUserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select * from user ", nativeQuery = true)
    List<User> findAllUser();

    @Query(value = "select * from user where id_user = :id", nativeQuery = true)
    User findUserById(Integer id);

    @Modifying
    @Query(value = "update user set name = :#{#user.name}," +
            "gender = :#{#user.gender}, date_of_birth = :#{#user.dateOfBirth}, " +
            "address = :#{#user.address}, job = :#{#user.job}, " +
            "avatar = :#{#user.avatar} where id_user = :#{#user.idUser}", nativeQuery = true)
    void updateUser(User user);
}
