package com.codegym.dating.repository;

import com.codegym.dating.dto.UserDto;
import com.codegym.dating.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT \n" +
            "    id_user AS idUser,\n" +
            "    address,\n" +
            "    avatar,\n" +
            "    coin,\n" +
            "    date_of_birth AS dateOfBirth,\n" +
            "    gender,\n" +
            "    job,\n" +
            "    join_day AS joinDay,\n" +
            "    name,\n" +
            "    id_status_active AS idStatusActive,\n" +
            "    id_type_user AS idTypeUser\n" +
            "FROM\n" +
            "    user\n" +
            "WHERE\n" +
            "    id_user = ?1", nativeQuery = true)
        Optional<UserDto> findByIdDto(Integer id);


}
