package com.codegym.dating.service.impl;

import com.codegym.dating.model.TypeUser;
import com.codegym.dating.model.User;
import com.codegym.dating.repository.ITypeUserRepository;
import com.codegym.dating.repository.IUserRepository;
import com.codegym.dating.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private ITypeUserRepository iTypeUserRepository;

    @Override
    public User findUserById(Integer id) {
        return this.iUserRepository.findUserById(id);
    }

    @Override
    public User saveUser(User user) {
        return this.iUserRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        TypeUser typeUser = this.iTypeUserRepository.findTypeUserById(1);
        user.setTypeUser(typeUser);

        user.setCoin(0);

        user.setJoinDay(String.valueOf(LocalDate.now()));

        this.iUserRepository.save(user);
    }
}
