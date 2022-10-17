package com.codegym.dating.service.impl;

import com.codegym.dating.model.User;
import com.codegym.dating.repository.IUserRepository;
import com.codegym.dating.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;
    @Override
    public User findUserById(Integer id) {
        return iUserRepository.findByIdNativeQuery(id);
    }

    @Override
    public void updateCoin(Integer coin, Integer idUser) {
        iUserRepository.updateCoin(coin,idUser);
    }

}
