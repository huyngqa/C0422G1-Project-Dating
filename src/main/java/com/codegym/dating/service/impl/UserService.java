package com.codegym.dating.service.impl;

import com.codegym.dating.dto.UserDto;
import com.codegym.dating.model.User;
import com.codegym.dating.repository.IUserRepository;
import com.codegym.dating.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


import org.springframework.stereotype.Service;


@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;


    @Override
    public Optional<UserDto> findByIdDto(Integer id) {
        return this.iUserRepository.findByIdDto(id);
    }

    @Override
    public User findUserById(Integer id) {
        return iUserRepository.findByIdNativeQuery(id);
    }

    @Override
    public void updateCoin(Integer coin, Integer idUser) {
        iUserRepository.updateCoin(coin,idUser);
    }

    @Override
    public void updateTypeUser(Integer coin, Integer idUser) {
        Integer idTypeUser = 0;
        if (coin >= 0 && coin < 100){
            idTypeUser = 1;
        }else if (coin >= 100 && coin < 1000){
            idTypeUser = 2;
        }else if (coin >= 1000 && coin < 5000){
            idTypeUser = 3;
        }else if (coin >= 5000){
            idTypeUser = 4;
        }
        this.iUserRepository.updateTypeUser(idTypeUser, idUser);
    }

}
