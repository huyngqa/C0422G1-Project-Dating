package com.codegym.dating.service;

import com.codegym.dating.model.User;

import java.util.List;

public interface IUserService {

    List<User> findAllUser();

    User findUserById(Integer id);

    User saveUser(User user);
}
