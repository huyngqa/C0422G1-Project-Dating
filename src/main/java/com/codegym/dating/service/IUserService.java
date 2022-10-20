package com.codegym.dating.service;

import com.codegym.dating.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {
    Page<UserDto> userPage(String name,
                           String dateOfBirth,
                           String address,
                           String job,
                           String gender,
                           String hobbitName,
                           Pageable pageable);

}
