package com.codegym.dating.service;

import com.codegym.dating.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface IUserService {
    Page<User> findAll(String name,Pageable pageable);

    Page<User> findByTypeUser(String name, String typeUser,Pageable pageable);

    Optional<User> findByIdUser(int id);

    void updateWarningUser(Integer id,User user);
}
