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
    public User findUserByIdAccount(Integer idAccount) {
        return iUserRepository.findByAccount_IdAccount(idAccount);
    }
}
