package com.codegym.dating.service;

import com.codegym.dating.model.User;

public interface IUserService {

    User findUserById(Integer id);

    User saveUser(User user);

    void updateUser(User user);
}
