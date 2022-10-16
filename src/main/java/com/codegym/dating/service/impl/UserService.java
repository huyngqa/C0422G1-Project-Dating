package com.codegym.dating.service.impl;

import com.codegym.dating.model.TypeUser;
import com.codegym.dating.model.User;
import com.codegym.dating.repository.ITypeUserRepository;
import com.codegym.dating.repository.IUserRepository;
import com.codegym.dating.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private ITypeUserRepository iTypeUserRepository;

    @Override
    public List<User> findAllUser() {
        return this.iUserRepository.findAllUser();
    }

    @Override
    public User findUserById(Integer id) {
        return this.iUserRepository.findUserById(id);
    }

    @Override
    public void saveUser(User user) {

        TypeUser typeUser = this.iTypeUserRepository.findTypeUserById(1);
        user.setTypeUser(typeUser);

        user.setJoinDay(String.valueOf(LocalDate.now()));

        this.iUserRepository.saveUser(user);
    }
}
