package com.codegym.dating.repository;

import com.codegym.dating.dto.UserDto;
import com.codegym.dating.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select id_user as idUser,\n" +
            " address,\n" +
            " avatar,\n" +
            " coin,\n" +
            " date_of_birth as dateOfBirth,\n" +
            " gender,\n" +
            " job,\n" +
            " join_day as joinDay,\n" +
            " name,\n" +
            " status_active as statusActive,\n" +
            " id_type_user as idTypeUser\n" +
            " from user \n" +
            "where id_user = ?1", nativeQuery = true)
        Optional<UserDto> findByIdDto(Integer id);


}
