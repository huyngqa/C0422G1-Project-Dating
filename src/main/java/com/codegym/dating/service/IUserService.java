package com.codegym.dating.service;

import com.codegym.dating.DTO.ListUserDto;
import com.codegym.dating.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IUserService {
    Page<ListUserDto> findAll(Pageable pageable);
    Optional<User> findByIdUser(int id);
}
