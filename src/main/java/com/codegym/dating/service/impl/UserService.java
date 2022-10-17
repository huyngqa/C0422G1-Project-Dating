package com.codegym.dating.service.impl;

import com.codegym.dating.model.User;
import com.codegym.dating.repository.IUserRepository;
import com.codegym.dating.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public Page<User> userPage(String name,
                               String dateOfBirth,
                               String address,
                               String job,
                               String gender,
                               String hobbitName,
                               Pageable pageable) {
        return iUserRepository.searchAll(
                "%" + name + "%",
                dateOfBirth,
                "%" + address + "%",
                "%" + job + "%",
                "%" + gender + "%",
                "%" + hobbitName + "%",
                pageable);
    }
}
