package com.codegym.dating.repository;

import com.codegym.dating.dto.UserDto;
import com.codegym.dating.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IUserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT user.`name`,user.coin,user.gender,user. address,user.job,user .avatar FROM user where  user.`name` like :name",
            countQuery = "select count(*) from (SELECT user.`name`,user.coin,user.gender,user. address,user.job,user .avatar FROM user where  user.`name` like :name)as pageCount",
            nativeQuery = true)
    Page<UserDto> getAllSearchPage(Pageable pageable, @Param("name") String name);
}
