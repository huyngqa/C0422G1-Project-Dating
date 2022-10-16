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

    @Modifying
    @Transactional
    @Query(value = "insert into user (avatar, name, gender, date_of_birth, job, address, married, id_type_user, join_day) " +
            "value (:#{#user.avatar}, :#{#user.name},:#{#user.gender}, :#{#user.dateOfBirth},:#{#user.job}, :#{#user.address},:#{#user.married}, :#{#user.typeUser.idTypeUser}, :#{#user.joinDay})",nativeQuery = true)
    void saveUser(User user);
}
