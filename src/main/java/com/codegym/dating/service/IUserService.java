package com.codegym.dating.service;

import com.codegym.dating.model.User;

import java.util.Optional;

public interface IUserService {
    Optional<User> findById(Integer idUser);
}

