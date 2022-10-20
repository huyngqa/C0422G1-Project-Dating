package com.codegym.dating.repository;

import com.codegym.dating.dto.UserDto;
import com.codegym.dating.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Transactional
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
            "    married,\n" +
            "    name,\n" +
            "    id_status_active AS idStatusActive,\n" +
            "    id_type_user AS idTypeUser\n" +
            "FROM\n" +
            "    user\n" +
            "WHERE\n" +
            "    id_user = ?1\n", nativeQuery = true)
        Optional<UserDto> findByIdDto(Integer id);

    @Query(value = "select * from user u\n" +
            "join account as a  \n" +
            "on u.id_user = a.id_user\n" +
            "join type_user as tu \n" +
            "on u.id_type_user = tu.id_type_user\n" +
            "where u.id_user = :id ", nativeQuery = true)
    User findByIdNativeQuery(@Param("id") Integer id);



    @Modifying
    @Query(value = "update user \n" +
            "set coin = :coin \n" +
            "where id_user = :id_user ", nativeQuery = true)
    void updateCoin(@Param("coin") Integer coin,@Param("id_user") Integer idUser);


    @Modifying
    @Query(value = "update user \n" +
            "set id_type_user = :id_type_user \n" +
            "where id_user = :id_user ", nativeQuery = true)
    void updateTypeUser(@Param("id_type_user") Integer idTypeUser,@Param("id_user") Integer idUser);

}
