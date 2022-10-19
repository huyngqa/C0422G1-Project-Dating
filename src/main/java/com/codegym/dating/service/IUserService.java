package com.codegym.dating.service;

import com.codegym.dating.dto.UserDto;
import com.codegym.dating.model.User;

import java.util.Optional;

public interface IUserService {
    Optional<UserDto> findByIdDto(Integer id);
    User findUserById(Integer id);
    void updateCoin(Integer coin, Integer idUSer);
    void updateTypeUser(Integer coin, Integer idUser);

}
