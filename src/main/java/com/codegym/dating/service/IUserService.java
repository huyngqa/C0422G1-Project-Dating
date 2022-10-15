package com.codegym.dating.service;

import com.codegym.dating.model.User;

public interface IUserService {

    User findUserByIdAccount(Integer idAccount);

    void updateAvatar(User user);

    void updateStatusActive(User user);


}
