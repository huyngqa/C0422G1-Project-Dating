package com.codegym.dating.service.impl;

import com.codegym.dating.dto.UserDto;
import com.codegym.dating.repository.IUserRepository;
import com.codegym.dating.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public Page<UserDto> findAllSearchPage(Pageable pageable, String name) {
        return userRepository.getAllSearchPage(pageable, '%' + name + '%');
    }
}
