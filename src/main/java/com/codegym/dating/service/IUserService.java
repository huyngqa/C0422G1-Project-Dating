package com.codegym.dating.service;

import com.codegym.dating.dto.UserDto;
import com.codegym.dating.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserService {

    Optional<UserDto> findByIdDto(Integer id);

}
