package com.codegym.dating.service;

import com.codegym.dating.model.User;

public interface IUserService {
    User findByUser(Integer id);
    void updateCoin(Integer coin, Integer idUSer);
}
